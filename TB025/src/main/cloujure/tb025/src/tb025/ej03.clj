(ns tb025.ej03)

(defn suma_lista [ns]
  (if (empty? ns)
    0
    (let [f (first ns)
          t (rest ns)]
      (+ f (suma_lista t)))))

;; (defn fact [n]
;; "Calcula el factorial del número entero no negativo 'n' utilizando recursión simple."
;;   (if (= n 0)
;;     1
;;     (* n (fact (- n 1)))))

(defn _fact [n acum]
  "Función auxiliar para calcular el 
   factorial."
  (if (zero? n)
    acum
    (_fact (dec n) (* acum n))))

(defn fact [n] 
  "Función que calcula el factorial de un número  entero
   'n' no negativo."
  (_fact n 1))

(defn maximo [ns]
;;   (if (empty? ns)
;;     nil
;;     (loop [max-actual (first ns)
;;            resto (rest ns)]
;;       (if (empty? resto)
;;         max-actual
;;         (recur (max max-actual (first resto))
;;                (rest resto))))
  (reduce max ns))
    
(defn _aprox-pi [n]
  (cond
    (zero? n) 0
    (even? n) (- (_aprox-pi (dec n)) (/ 1 (dec (* 2 n)))) ; Resta término (ej. 1/3, 1/7)
    :else    (+ (_aprox-pi (dec n)) (/ 1 (dec (* 2 n))))))

(defn aprox-pi [n] (* 4 (_aprox-pi n)))

(defn aprox-pi-final [n]
  (loop [i 1
         sum 0]
    (if (> i n)
      (* 4 sum) ; Multiplica por 4 al final, ya que la serie converge a pi/4
      (let [denominador (dec (* 2 i))
            termino (/ 1.0 denominador)] ; Usar 1.0 para forzar la división a flotante
        (if (odd? i)
          (recur (inc i) (+ sum termino))
          (recur (inc i) (- sum termino)))))))