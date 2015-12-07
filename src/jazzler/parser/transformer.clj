(ns jazzler.parser.transformer
  (:require [clojure.string :as str]
            [instaparse.core :as i]))

(defn transform [m s]
  (i/transform m s))

;; TODO: i don't know, if it is used at all
(defn- add-bar-numbers [bars]
  (map #(assoc %1 :bar %2) bars (iterate inc 1)))

(defn string->degree 
  "Converts a string degree into a keyword degree as used in overtone
  Example: \"I\" => :i"
  [s] 
  {:pre [(string? s)]}
  (keyword (str/lower-case s)))

(defn progression 
  [& content]
  (cond
    (seq? content) {:figures {:progression content}}
    (nil? content) {:figures {:progression '()}}
    ;; :else [:progression (list content)];unused
))

(defn title [title] {:title title})

(defn bar [& content] {:elements content})

(defn barchord [content] {:elements (list content)})

(defn majorchord [root] {:chord (string->degree root) 
                         :triad :major})

(defn minorchord [root] {:chord (string->degree root) 
                         :triad :minor})

(defn diminished [{root :chord}] {:chord root, :triad :diminished})

(defn augmented [{root :chord}] {:chord root, :triad :augmented})
