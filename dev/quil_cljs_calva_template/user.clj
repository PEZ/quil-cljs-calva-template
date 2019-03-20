(ns quil-cljs-calva-template.user
  (:use [figwheel-sidecar.repl-api :as ra]))

(defn figwheel-start []
  (ra/start-figwheel!)
  (ra/cljs-repl "dev"))

(defn figwheel-stop []
  (ra/stop-figwheel!))
