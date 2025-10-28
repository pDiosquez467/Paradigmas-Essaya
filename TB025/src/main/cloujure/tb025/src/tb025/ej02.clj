(ns tb025.ej02)

(defn palindromo? [s]
  (case (count s)
    (0 1) true
    (let [f (first s)
          m (rest (butlast s))
          l (last s)]
      (and (= f l) (palindromo? m)))))

(defn capicua? [n]
  (palindromo? (seq (str n))))

(assert (capicua? 5))
(assert (capicua? 55))
(assert (capicua? 545))
(assert (capicua? 59895))
(assert not (capicua? 59875))