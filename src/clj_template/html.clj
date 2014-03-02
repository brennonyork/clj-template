(ns clj-template.html
  (:require [clj-template.core :as core])
  (:gen-class))

;; ## HTML4 Tags
;;
;; This set contains all HTML4 tags as [specified by the W3C](http://www.w3.org/TR/html4/index/elements.html)
(def html4-tag-list
  ["a" "abbr" "acronym" "address" "applet" "area"
   "b" "base" "basefont" "bdo" "big" "blockquote" "body" "br" "button"
   "caption" "center" "cite" "code" "col" "colgroup"
   "dd" "del" "dfn" "dir" "div" "dl" "dt"
   "em"
   "fieldset" "font" "form" "frame" "frameset"
   "h1" "h2" "h3" "h4" "h5" "h6" "head" "hr" "html"
   "i" "iframe" "img" "input" "ins" "isindex"
   "kbd"
   "label" "legend" "li" "link"
   "map" "menu" "meta"
   "noframes" "noscript"
   "object" "ol" "optgroup" "option"
   "p" "param" "pre"
   "q"
   "s" "samp" "script" "select" "small" "span" "strike" "strong" "style" "sub" "sup"
   "table" "tbody" "td" "textarea" "tfoot" "th" "thead" "title" "tr" "tt"
   "u" "ul"
   "var"])

(core/assoc-to-fn html4-tag-list)
(core/assoc-to-fn-unbalanced html4-tag-list)
