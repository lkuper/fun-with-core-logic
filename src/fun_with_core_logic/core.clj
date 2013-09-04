(ns fun-with-core-logic.core
  (:refer-clojure :exclude [==])
  (:require [clojure.core.logic :refer :all]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn append
  "Appends two lists together."
  [ls1 ls2]
  (cond
   (empty? ls1) ls2
   :else (cons (first ls1) (append (rest ls1) ls2))))

(defn our-appendo
  "Relationally append lists"
  [ls1 ls2 out]
  (conde
   [(== ls1 ()) (== ls2 out)]
   [(fresh (fst1 rst1 res)
      ;; destructure ls1 into fst1 and rst1
      (conso fst1 rst1 ls1)

      ;; actually do the appending
      (conso fst1 res out)
      (our-appendo rst1 ls2 res))]))



