(ns quil-cljs-calva-template.user
  (:use [figwheel-sidecar.repl-api :as sidercar]))

(defn figwheel-start []
  (sidercar/start-figwheel!)
  (sidercar/cljs-repl "dev"))

(defn figwheel-stop []
  (sidercar/stop-figwheel!))
