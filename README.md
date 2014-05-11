# clj-template

Ever begin to write HTML and feel the urge to gouge out your eyes? Ever realize you have to write XML and get the sudden urge to rip your hair out?

Welcome `clj-template`, a modern attempt to make writing HTML, XML, and other bracket-attribute structures simple, lightweight, and accessible to the Clojure community.

The founding principle behind `clj-template` is that of binding HTML tags to Clojure functions and allowing attributes to be passed in as Clojure maps. Why would someone do this? Well, aside from being overly verbose when typing typical HTML, moving into a pure Clojure-based solution allows a new type of templating engine where the user can leverage all the power of Clojure to generate his web pages.

Gone are the days of learning a given templating engine's DSL or wondering whether a given engine supports a certain data structure, looping capability, output function, etc. Purity in the Clojure language grants all the expressiveness of Clojure without any of the heartache of polyglot projects (i.e. mixing .html, .hbs, and .clj files). 

## Key Features

1. First class Clojure functions for bracket-attribute tags
2. HTML and HTML5 support built in
3. Dead simple to use
4. Works with Ring and other Clojure webstack frameworks
5. Support for generating user-defined tags

## Installation

To jump in and get started simply add:

* `[clj-template "1.0.0"]` to your project.clj file
* `(:require [clj-template.html :refer :all])` to your project namespace
  * Note that doing the above will collide with a few default `clojure.core` namespace functions, namely `map` and `meta` (`time` as well for html5). To resolve this you can either namespace the import (i.e. something like `(:require [clj-template.html :as h])`, but that's no fun) or refer Clojure core in your namespace (more below for a brief primer).

#### Referring Clojure

To refer Clojure into a project you can use the following example namespace as a guide.

```clojure
(ns foo.bar
  (:refer-clojure :rename {map clj-map meta clj-meta time clj-time})
  (:require [clj-template.html5 :refer :all]))
```

This refers all `clojure.core` into the `foo.bar` namespace (substitute for your project) and renames...

* `map` to `clj-map`
* `meta` to `clj-meta`
* and `time` to `clj-time`

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

Now, when rendering this you might notice that the pesky `<br></br>` element turns into two separate `<br>` tags. To resolve this, and achieve the intended results, we suffix the function with a dash (i.e. `br-`) which will render an unbalanced node (i.e. `<br />`).

Our modified code then looks like...

```clojure
(html
  (head (title {:style "font-family:'Courier';"} "My Simple Web Site"))
  (body (p "A paragraph of content.") (br-)
        (p "Another paragraph of content")))
```

which renders...

```html
<html>
  <head><title style="font-family:'Courier';">My Simple Web Site</title>
  </head>
  <body><p>A paragraph of content.</p><br />
        <p>Another paragraph of content</p>
  </body>
</html>
```

## License

Copyright © 2014

Distributed under the Eclipse Public License.
