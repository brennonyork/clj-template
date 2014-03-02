(ns clj-template.core
  (:require clojure.string)
  (:gen-class))

(defn assoc-to-fn
  "Associates a given list of tags into clojure functions which will output bracket-attribute markup

  `(assoc-to-fn [\"html\" \"title\"])`

  `(html {:id \"my-id\"} (title \"My Title\"))` => `<html id=\"my-id\"><title>My Title</title></html>`"
  [tag-list]
  (doall
   (map
    (fn [markup-tag]
      (eval
       `(defn ~(symbol markup-tag) [& [~(symbol "attrs") & ~(symbol "body")]]
          (let [[~(symbol "attrs") ~(symbol "body")]
                (if (and (map? ~(symbol "attrs")) (not (empty? ~(symbol "attrs"))))
                  [(str " " (clojure.string/join " " (for [[~(symbol "k") ~(symbol "v")] ~(symbol "attrs")]
                                                       (str (name ~(symbol "k")) "=\"" ~(symbol "v") "\""))) ">")
                   ~(symbol "body")]
                  [">" (concat (if (not (empty? ~(symbol "attrs"))) [~(symbol "attrs")] []) ~(symbol "body"))])]
            (if ~(symbol "body")
              (str "<" ~markup-tag ~(symbol "attrs") (clojure.string/join " " ~(symbol "body")) "</" ~markup-tag ">")
              (str "<" ~markup-tag ~(symbol "attrs") "</" ~markup-tag ">"))))))
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
       `(defn ~(symbol (str markup-tag "-")) [& [~(symbol "attrs") & ~(symbol "body")]]
          (let [~(symbol "attrs")
                (if (and (map? ~(symbol "attrs")) (not (empty? ~(symbol "attrs"))))
                  (str " " (clojure.string/join " " (for [[~(symbol "k") ~(symbol "v")] ~(symbol "attrs")]
                                                       (str (name ~(symbol "k")) "=\"" ~(symbol "v") "\""))) " />") " />")]
            (str "<" ~markup-tag ~(symbol "attrs"))))))
    tag-list)))
