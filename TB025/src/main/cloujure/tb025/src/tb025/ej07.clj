(ns tb025.ej07 
  (:require
    [clojure.string :as str]))

(defn pangrama? [s]
  (-> s 
      str/lower-case
      (str/replace #" " "")
      set
      count
      (= 27)))

(assert (true? (pangrama? "Fabio me exige sin tapujos que añada cerveza al whisky")))

(assert (false? (pangrama? "Pablo me exige sin tapujos que añada cerveza al whisky")))