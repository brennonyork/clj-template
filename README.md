# clj-template

Ever begin to write HTML and feel the urge to gouge out your eyes? Ever realize you have to write XML and get the sudden urge to rip your hair out?

Welcome `clj-template`, your savior.

## Installation

To jump in and get started simply add:

* `[clj-template "0.8.0"]` to your project.clj file
* `(:require [clj-template.html :refer :all])` to your project namespace
  * Note that doing the above will collide with a few default `clojure.core` namespace functions, namely `map` and `meta`. To resolve this you can either namespace the import (i.e. something like `(:require [clj-template.html :as h])`) or reference Clojure map and meta functions as `clojure.core/map` and `clojure.core/meta` respectively.

## Usage

`clj-template` makes it very simple to generate html. Assuming you've loaded `clj-template.html` into your namespace we can start with some very basic examples.

#### Generating a simple webpage

```clojure
(html
  (head (title {:style "font-family:'Courier';"} "My Simple Web Site"))
  (body (p "A paragraph of content.") (br)
        (p "Another paragraph of content")))
```

which will output...

```html
<html>
  <head><title style="font-family:'Courier';">My Simple Web Site</title>
  </head>
  <body><p>A paragraph of content.</p><br></br>
        <p>Another paragraph of content</p>
  </body>
</html>
```

## License

Copyright © 2014

Distributed under the Eclipse Public License.
