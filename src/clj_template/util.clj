(ns clj-template.util
  (:require [clojure.walk :as clj-walk]
            [clojure.xml :as xml])
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

(defn into-template
  "Slurps a website given the URL and returns clojure template code as a string; can optionally be spit to a file if
  given a filename."
  [url & [filename]]
  (let [template-str (pr-str
                      (clj-walk/postwalk
                       #(if (and (map? %) (contains? % :tag) (contains? % :attrs) (contains? % :content))
                          (let [attrs (% :attrs)]
                            (if attrs
                              (concat [(symbol (name (% :tag))) (% :attrs)] (% :content))
                              (concat [(symbol (name (% :tag)))] (% :content))))
                          %)
                       (clj-walk/postwalk
                        #(cond
                          (map? %) (into {} %)
                          (vector? %) (into [] %)
                          :else %)
                        (xml/parse url))))]
    (if filename
      (spit filename template-str)
      template-str)))
