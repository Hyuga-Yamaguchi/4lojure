# Functions

## interleave

`(interleave c1 c2 & colls)`

複数のシーケンスを交互に並べた遅延シーケンスを返す

```clojure
(interleave [1 2 3] [:a :b :c])
;; => (1 :a 2 :b 3 :c)

(interleave [1 2 3] [:a :b :c] ["X" "Y" "Z"])
;; => (1 :a "X" 2 :b "Y" 3 :c "Z")

(interleave [1 2] [:a :b :c])
;; => (1 :a 2 :b) ;; 短いリストに合わせて終了
```

## interpose

`(interpose sep coll)`

シーケンスの各要素の間に指定した値を挿入した遅延シーケンスを返す

```clojure
(interpose :x [1 2 3])
;; => (1 :x 2 :x 3)

(interpose ", " ["apple" "banana" "cherry"])
;; => ("apple" ", " "banana" ", " "cherry")
```

## split-at

`(split-at n coll)`

`[(take n coll) (drop n coll)]` のベクタを返す。

```clojure
(split-at 3 [1 2 3 4 5 6])
;; => [(1 2 3) (4 5 6)]

(split-at 0 [1 2 3])
;; => [() (1 2 3)]

(split-at 5 [1 2 3])
;; => [(1 2 3) ()] ;; 長さを超える場合、後半は空
```

## distinct

`(distinct coll)`

シーケンス内の重複を削除し、最初に出現した順序を保持した遅延シーケンスを返す

```clojure
(distinct [1 2 2 3 4 4 5])
;; => (1 2 3 4 5)

(distinct [:a :b :a :c :b :d])
;; => (:a :b :c :d)

(distinct "banana")
;; => (\b \a \n)
```

## juxt

`(juxt f g h & fs)`

複数の関数を同じ引数に適用し、その結果をベクターとして返す

```clojure
((juxt inc dec) 10)
;; => [11 9]  ;; inc(10) = 11, dec(10) = 9

((juxt first last count) [1 2 3 4 5])
;; => [1 5 5]  ;; first = 1, last = 5, count = 5

((juxt :a :b) {:a 10 :b 20 :c 30})
;; => [10 20]  ;; :a の値 10, :b の値 20
```

## reductions

[reductions.md](./reductions.md)

## lazy-seq

[lazy-seq.md](./lazy-seq.md)

## zipmap

`(zipmap keys vals)`

キーのリストと値のリストを組み合わせてマップを作成する

```clojure
(zipmap [:a :b :c] [1 2 3])
;; => {:a 1, :b 2, :c 3}

(zipmap [1 2 3] ["one" "two" "three"])
;; => {1 "one", 2 "two", 3 "three"}

(zipmap [:x :y :z] [10])
;; => {:x 10}  ;; 余ったキーは無視される

(zipmap [:a :b] [1 2 3 4])
;; => {:a 1, :b 2}  ;; 余った値は無視される
```
