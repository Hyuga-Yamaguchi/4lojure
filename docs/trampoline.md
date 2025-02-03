# trampoline

## **1. `trampoline` の基本的な機能**

Clojure の `trampoline` は、**関数の再帰呼び出しをスタックオーバーフローなしで処理するための関数** です。

通常、Clojure の **末尾再帰最適化（TCO: Tail Call Optimization）は関数呼び出しの形に制約がある** ため、`trampoline` を使うことで **深い再帰を効率的に処理** できます。

---

## 2. `trampoline` の基本構造

```clojure
(trampoline f arg1 arg2 ...)
```

- `f` を **引数付きで1回呼び出す**。
- `f` の戻り値が **関数であれば、それを引数なしで呼び出し続ける**。
- 戻り値が **関数でない値になったら、それを返す**。

---

## 3. `trampoline` の基本例

### 1. `trampoline` を使わない通常の再帰

```clojure
(defn even? [n]
  (if (zero? n) true (odd? (dec n))))

(defn odd? [n]
  (if (zero? n) false (even? (dec n))))

(even? 10000) ;; StackOverflowError（深い再帰でクラッシュ）
```

- `even?` と `odd?` は **相互再帰（mutual recursion）** で呼び合う。
- しかし、Clojure は **末尾最適化されない相互再帰** で **深い再帰に耐えられない**。

---

### 2. `trampoline` を使って解決

```clojure
(defn even? [n]
  (if (zero? n) true #(odd? (dec n)))) ;; 再帰の際に関数を返す

(defn odd? [n]
  (if (zero? n) false #(even? (dec n)))) ;; 再帰の際に関数を返す

(trampoline even? 10000) ;; => true
```

#### `trampoline` の処理の流れ

1. `trampoline` が `even? 10000` を呼び出す。
2. `even? 10000` は `#(odd? 9999)`（**関数オブジェクト**）を返す。
3. `trampoline` は `odd? 9999` を **引数なしで実行** する。
4. `odd? 9999` は `#(even? 9998)`（**関数オブジェクト**）を返す。
5. **この手続きを繰り返し、最終的に `true` を返す**。

**深い再帰でもスタックオーバーフローせずに処理できる！**

---

## 4. `trampoline` の仕組みを分かりやすく説明

### 3. `trampoline` の動作をシンプルな例で確認

```clojure
(defn step [n]
  (if (< n 5)
    #(step (inc n)) ;; 関数を返す（遅延評価）
    n)) ;; 5になったら値を返す

(trampoline step 0) ;; => 5
```

#### `trampoline step 0` の処理

1. `trampoline` が `step 0` を呼び出す。
2. `step 0` は `#(step 1)`（関数オブジェクト）を返す。
3. `trampoline` は `step 1` を **引数なしで実行** する。
4. これを `step 5` まで繰り返し、`5` を返す。

**関数オブジェクトを使って遅延評価することで、再帰を安全に実行！**

---

## 5. `trampoline` を使うべき場面

### 1. 深い再帰処理

再帰が深くなると **StackOverflowError** が発生するが、`trampoline` を使うと解決できる。

```clojure
(defn factorial [n acc]
  (if (zero? n)
    acc
    #(factorial (dec n) (* acc n)))) ;; 再帰を関数でラップ

(trampoline factorial 1000 1) ;; => 1000! の計算が成功
```

---

### 2. 相互再帰

```clojure
(defn even? [n]
  (if (zero? n) true #(odd? (dec n))))

(defn odd? [n]
  (if (zero? n) false #(even? (dec n))))

(trampoline even? 1000000) ;; => true
```

相互再帰のとき、`trampoline` が **関数のジャンプを安全に処理** してくれる。

---

### 3. 遅延評価を伴う計算

```clojure
(defn lazy-sum [x]
  (if (> x 100)
    x
    #(lazy-sum (+ x 10))))

(trampoline lazy-sum 0) ;; => 110
```

- `lazy-sum` は **関数を返すことで計算を遅延** する。
- `trampoline` を使うことで **必要な計算だけを評価できる**。

---

## 6. `trampoline` の動作を Clojure 風に模擬

`trampoline` の動作は `loop/recur` に近いが、関数オブジェクトを再帰的に呼び出すことで `stack` を消費しないようになっている。

### `trampoline` の簡易的な実装

```clojure
(defn my-trampoline [f & args]
  (loop [result (apply f args)]
    (if (fn? result)
      (recur (result)) ;; 関数なら評価を続ける
      result))) ;; 関数でなければ結果を返す

(my-trampoline step 0) ;; => 5
```

 `trampoline` は関数を評価し続け、最終結果を取得するだけ！

---

## 7. `trampoline` のポイントまとめ

| **ポイント** | **説明** |
|------------|--------|
|  **深い再帰に強い** | スタックオーバーフローを防ぐ |
|  **相互再帰の処理が可能** | `even?` → `odd?` のような相互再帰を扱える |
|  **遅延評価ができる** | 再帰のたびに関数を返すことで評価を後回しにする |
|  **ループの代替として使える** | `trampoline` は `loop/recur` のような処理を安全に実行 |

**再帰が深くなる問題を解決したい場合や、遅延評価を使いたい場合に `trampoline` は非常に便利！**
