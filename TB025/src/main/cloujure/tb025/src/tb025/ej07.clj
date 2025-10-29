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