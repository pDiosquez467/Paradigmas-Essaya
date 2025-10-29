(ns tb025.ej05)

(defn qsort [xs] 
  "Recibe una secuencia y la ordena usando
   quicksort."
  (if (empty? xs) 
    xs
    (let [pivot (first xs)
          r (rest xs)] 
      (concat 
       (qsort (filter #(<= % pivot) r))
       [pivot]
       (qsort (filter #(> % pivot) r))
       ))))

(assert (= '(1 2 3 4 5 6) (qsort '(1 4 3 2 6 5))))