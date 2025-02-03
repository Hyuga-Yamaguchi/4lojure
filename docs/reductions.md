# reductions

## Clojure Docs

<https://clojuredocs.org/clojure.core/reductions>

関数 `f` を使って累積計算を行い、その過程のすべての結果をリストとして返す関数。

```clojure
(reductions + 0 (range 5)) ;; => (0 1 3 6 10)
(reductions conj [1] [2 3 4]) ;; => ([1] [1 2] [1 2 3] [1 2 3 4])
```

## セルフ実装

```clojure
(fn self-reductions
    ([f init coll]
     (cons init
           (lazy-seq
            (when-let [[x & xs] coll]
              (self-reductions f (f init x) xs)))))
    ([f coll]
     (if coll
       (self-reductions f (first coll) (rest coll))
       (list))))
```

### 3引数バージョン

#### 引数

- `f` : 累積計算を行う関数 (例: `+`, `conj` など)
- `init` : 初期値 (例: `0` や `[1]`)
- `coll` : 累積計算するデータのコレクション (例: `(range 5)`, `[2 3 4]`)

#### 処理の流れ

- `init` をリストの最初の要素として返す。

```clojure
(cons init ...)
```

- `lazy-seq`を使って遅延評価

```clojure
(lazy-seq ...)
```

- コレクション `coll` から最初の要素 `x` を取り出し、残りの `xs` を `rest` として取得
  - `when-let` は `coll` が `nil` なら `nil` を返し、`coll` に要素がある場合は `[x & xs]` に展開。

```clojure
(when-let [[x & xs] (seq coll)]
```

- 累積値を計算し、再帰的に処理
  - `f init x` を計算し、それを新しい `init` として `xs` に対して `self-reductions` を再帰的に適用。

```clojure
(self-reductions f (f init x) xs)
```
