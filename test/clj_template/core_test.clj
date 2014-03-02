(ns clj-template.core-test
  (:require [clj-template.html :refer :all])
  (:use midje.sweet))

(fact "Clojure makes better HTML than HTML"
  (html (head (title "MySite")) (body (p "some content"))) => "<html><head><title>MySite</title></head> <body><p>some content</p></body></html>"
  (a {:href "http://www.google.com"} "Google it!") => "<a href=\"http://www.google.com\">Google it!</a>")

