(defproject quil-cljs-calva-template "0.1.0-SNAPSHOT"
  :description "A template project for using Calva for quil-cljs"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [quil "2.8.0"]
                 [org.clojure/clojurescript "1.10.439"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.15"]]

  :profiles {:dev
             {:source-paths ["dev"]}
             :repl {:plugins [[cider/cider-nrepl "0.21.2-SNAPSHOT"]]
                    :dependencies [[nrepl "0.6.0"]
                                   [cider/piggieback "0.4.0"]
                                   [figwheel-sidecar "0.5.19-SNAPSHOT"]]
                    :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]
                                   :skip-default-init false
                                   :init-ns quil-cljs-calva-template.user}}}

  :hooks [leiningen.cljsbuild]

  :clean-targets ^{:protect false} ["resources/public/js"]

  :cljsbuild
  {:builds [; development build with figwheel hot swap
            {:id "development"
             :source-paths ["src"]
             :figwheel true
             :compiler
             {:main "quil_cljs_calva_template.core"
              :output-to "resources/public/js/main.js"
              :output-dir "resources/public/js/development"
              :asset-path "js/development"}}
            ; minified and bundled build for deployment
            {:id "optimized"
             :source-paths ["src"]
             :compiler
             {:main "quil_cljs_calva_template.core"
              :output-to "resources/public/js/main.js"
              :output-dir "resources/public/js/optimized"
              :asset-path "js/optimized"
              :optimizations :advanced}}]}
  :figwheel {:server-port 3449})
