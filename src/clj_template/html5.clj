(ns clj-template.html5
  (:require [clj-template.core :as core])
  (:gen-class))

;; ## HTML5 Tags
;;
;; This set contains all HTML5 tags as [specified by the W3C](http://dev.w3.org/html5/markup/elements.html)
(def html5-tag-list
  ["a" "abbr" "address" "area" "article" "aside" "audio"
   "b" "base" "bdi" "bdo" "blockquote" "body" "br" "button"
   "canvas" "caption" "cite" "code" "col" "colgroup" "command"
   "datalist" "dd" "del" "details" "dfn" "div" "dl" "dt"
   "em" "embed"
   "fieldset" "figcaption" "figure" "footer" "font" "form"
   "h1" "h2" "h3" "h4" "h5" "h6" "head" "header" "hgroup" "hr" "html"
   "i" "iframe" "img" "input" "ins"
   "kbd" "keygen"
   "label" "legend" "li" "link"
   "map" "mark" "menu" "meta" "meter"
   "nav" "noscript"
   "object" "ol" "optgroup" "option" "output"
   "p" "param" "pre" "progress"
   "q"
   "rp" "rt" "ruby"
   "s" "samp" "script" "section" "select" "small" "source" "span" "strong" "style" "sub" "summary" "sup"
   "table" "tbody" "td" "textarea" "tfoot" "th" "thead" "time" "title" "tr" "track"
   "u" "ul"
   "var" "video"
   "wbr"])

(core/assoc-to-fn html5-tag-list)
(core/assoc-to-fn-unbalanced html5-tag-list)

