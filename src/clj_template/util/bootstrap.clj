(ns clj-template.util.bootstrap
  "Built to house all functions helpful for developing Bootstrap-based HTML templates

  **NOTE** Feel free to submit a pull request to add to this file if you'd like to see something here"
  (:require clojure.string)
  (:gen-class))

(def ^{:private true} single-classes
  "Generate all div tags with single class fields (i.e. <div class='row'></div>, etc.) that are typically used in
  Bootstrap"
  (concat
   ["row" "form-group"]
   (for [n (range 1 13)
        s ["xs" "sm" "md" "lg"]]
    (str "col-"s"-"n))))

;; Using the vector returned by `single-classes` will generate functions for each
(doall
 (map
  (fn [col]
    (eval
     `(defn ~(symbol col) [& ~(symbol "body")]
        (if ~(symbol "body")
          (str "<div class=\"" ~col "\">" (clojure.string/join " " ~(symbol "body")) "</div>")
          (str "<div class=\"" ~col "\">" "</div>")))))
  single-classes))
