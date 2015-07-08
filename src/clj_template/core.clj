(ns clj-template.core
  (:require [clojure.string :as clj-str])
  (:gen-class))

(defn gen-attributes
  "Generate attributes based on attrs map"
  [attrs]
  (clj-str/join " " (for [[k v] attrs]
                      (str (name k) "=\"" (name v) "\""))))

(defn assoc-to-fn
  "Associates a given list of tags into clojure functions which will output bracket-attribute markup

  `(assoc-to-fn [\"html\" \"title\"])`

  `(html {:id \"my-id\"} (title \"My Title\"))` => `<html id=\"my-id\"><title>My Title</title></html>`"
  [tag-list]
  (doall
   (map
    (fn [markup-tag]
      (eval
       `(defn ~(symbol markup-tag) [& [attrs# & body#]]
          (let [[str-attrs# str-body#]
                (if (and (map? attrs#)
                         (not (empty? attrs#)))
                  [(str " " (gen-attributes attrs#) ">")
                   body#]
                  [">" (concat (if (not (empty? attrs#))
                                 [attrs#]
                                 [])
                               body#)])]
            (if str-body#
              (str "<" ~markup-tag str-attrs# (clj-str/join " " str-body#) "</" ~markup-tag ">")
              (str "<" ~markup-tag str-attrs# "</" ~markup-tag ">"))))))
    tag-list)))

(defn assoc-to-fn-unbalanced
  "Like above, except the bracket-attribute markup will output unbalanced nodes and the function bindings end with a
  dash (-). Cannot add any `body` elements with these functions.

  `(assoc-to-fn-unbalanced [\"img\" \"br\"])`

  `(img- {:src \"http://placehold.it/350x150\"})` => `<img src=\"http://placehold.it/350x150\" />`
  `(br-)` => `<br />`"
  [tag-list]
  (doall
   (map
    (fn [markup-tag]
      (eval
       `(defn ~(symbol (str markup-tag "-"))
          [& [attrs# & body#]]
          (let [str-attrs#
                (if (and (map? attrs#)
                         (not (empty? attrs#)))
                  (str " " (gen-attributes attrs#) "/>")
                  " />")]
            (str "<" ~markup-tag str-attrs#)))))
    tag-list)))
