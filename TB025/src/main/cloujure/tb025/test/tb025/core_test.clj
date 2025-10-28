(ns tb025.core-test
  (:require [clojure.test :refer :all]
            [tb025.ej01 :refer [segundos]]))

(deftest segundos-test
  (testing "Convierte correctamente dias, horas, minutos y segundos a segundos totales"
    (is (= 3660 (segundos 0 1 1 0)) "Una hora y un minuto son 3660 segundos")))