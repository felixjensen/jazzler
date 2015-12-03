(ns user
  (:require [clojure.repl :refer [doc source apropos]]
            [clojure.pprint :refer [pprint]]
            [midje.repl :refer :all]
            [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [jazzler.song :refer :all]
            [jazzler.repl :as jrepl]
            [jazzler.repl.io :as io]
            [jazzler.repl.runtime :as rt]
            [jazzler.repl.song-commands :as sc]
            [jazzler.repl.system :as sys]
            [jazzler.repl.state-machine :as sm]
            ;; [jazzler.player :refer [play-song play-chord]]
            ))
