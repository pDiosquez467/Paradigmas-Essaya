(ns tb025.ej04)

;; (defn nth-fibo [n]
;;   (if (or (= n 0) (= n 1))
;;     n 
;;     (+ (nth-fibo (- n 1)) (nth-fibo (- n 2)))))

(defn nth-fibo [n]
  "Recibe un número entero no negativo y devuelve
   el correspondiente término de la sucesión de Fibonacci"
  (if (or (zero? n) (= n 1)
          n)
    (loop [i 2
           previo 1
           actual 1]
      (if (= i n)
        actual
        (recur (inc i)
               actual
               (+ previo actual))))))