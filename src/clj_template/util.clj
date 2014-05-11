(ns clj-template.util
  (:gen-class))

(defmacro str-loop
  "Allows a user to easily loop through a vector and operate on each item returning a single string
  Example usage:
  (str-loop [link [\"css/a.css\" \"css/b.css\"]] (link- {:rel \"stylesheet\" :type \"text/css\" :href link}))
  => \"<link rel='stylesheet' type='text/css' href='css/a.css' />
       <link rel='stylesheet' type='text/css' href='css/b.css' />\""
  [[sym v] body]
  `(loop [ret# "" v# ~v]
     (let [~(symbol sym) (first v#)]
       (if (empty? v#) ret# (recur (str ret# ~body) (rest v#))))))
