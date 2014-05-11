(ns clj-template.core-test
  (:refer-clojure :exclude [map meta time])
  (:require [clj-template.html :refer :all]
            [midje.sweet :refer [fact]]))

(fact "Clojure makes better HTML than HTML"
  (html (head (title "MySite")) (body (p "some content"))) => "<html><head><title>MySite</title></head> <body><p>some content</p></body></html>"
  (a {:href "http://www.google.com"} "Google it!") => "<a href=\"http://www.google.com\">Google it!</a>"
  (br-) => "<br />"
  (img- {:src "http://placehold.it/350x150"}) => "<img src=\"http://placehold.it/350x150\" />")

