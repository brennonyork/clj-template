(ns clj-template.html5
  (:refer-clojure :rename {map clj-map meta clj-meta time clj-time})
  (:require [clj-template.core :as core])
  (:gen-class))

;; ## HTML5 Tags
;;
;; This set contains all HTML5 tags as [specified by the W3C](http://dev.w3.org/html5/markup/elements.html)
;;
;; Additional tags from...
;;   - data https://developer.mozilla.org/en-US/docs/Web/HTML/Element/data
;;   - menuitem https://developer.mozilla.org/en-US/docs/Web/HTML/Element/menuitem
;;   - main https://developer.mozilla.org/en-US/docs/Web/HTML/Element/main
;;   - math https://developer.mozilla.org/en-US/docs/Web/MathML/Element/math
;;   - svg https://developer.mozilla.org/en-US/docs/Web/SVG/Element/svg
(def html5-tag-list
  ["a" "abbr" "address" "area" "article" "aside" "audio"
   "b" "base" "bdi" "bdo" "blockquote" "body" "br" "button"
   "canvas" "caption" "cite" "code" "col" "colgroup" "command"
   "datalist" "dd" "del" "details" "dfn" "div" "dl" "dt" "data"
   "em" "embed"
   "fieldset" "figcaption" "figure" "footer" "font" "form"
   "h1" "h2" "h3" "h4" "h5" "h6" "head" "header" "hgroup" "hr" "html"
   "i" "iframe" "img" "input" "ins"
   "kbd" "keygen"
   "label" "legend" "li" "link"
   "map" "mark" "menu" "menuitem" "meta" "meter" "main" "math"
   "nav" "noscript"
   "object" "ol" "optgroup" "option" "output"
   "p" "param" "pre" "progress"
   "q"
   "rp" "rt" "ruby"
   "s" "samp" "script" "section" "select" "small" "source" "span" "strong" "style" "sub" "summary" "sup" "svg"
   "table" "tbody" "td" "textarea" "tfoot" "th" "thead" "time" "title" "tr" "track"
   "u" "ul"
   "var" "video"
   "wbr"])

(core/assoc-to-fn html5-tag-list)
(core/assoc-to-fn-unbalanced html5-tag-list)

