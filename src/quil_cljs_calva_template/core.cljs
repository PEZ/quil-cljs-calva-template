(ns quil-cljs-calva-template.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  ; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
  ; Set color mode to HSB (HSV) instead of default RGB.
  (q/color-mode :hsb)
  ; setup function returns initial state. It contains
  ; circle color and position.
  {:color 0
   :angle 0})

(defn update-state [state]
  ; Update sketch state by changing circle color and position.
  {:color (mod (+ (:color state) 0.7) 255)
   :angle (+ (:angle state) 0.1)})

(defn draw-state [state]
  ; Clear the sketch by filling it with light-grey color.
  (q/background 240)
  ; Set circle color.
  (q/fill (:color state) 255 255)
  ; Calculate x and y coordinates of the circle.
  (let [angle (:angle state)
        x (* 150 (q/cos angle))
        y (* 150 (q/sin angle))]
    ; Move origin point to the center of the sketch.
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      ; Draw the circle.
      (q/ellipse x y 100 100))))

; this function is called in index.html
(defn ^:export run-sketch []
  (q/defsketch quil-cljs-calva-template
    :host "quil-cljs-calva-template"
    :size [500 500]
    ; setup function called only once, during sketch initialization.
    :setup setup
    ; update-state is called on each iteration before draw-state.
    :update update-state
    :draw draw-state
    ; This sketch uses functional-mode middleware.
    ; Check quil wiki for more info about middlewares and particularly
    ; fun-mode.
    :middleware [m/fun-mode]))

;; To reset the sketch: evaluate the `(run-sketch)` form below.
(comment
  (run-sketch))
;; Easiest way to do it in Calva is to place the cursor anywhere
;; in the form and run the **Evaluate top level form** command,
;; Keyboard shortcut for this is: `ctrl+alt+v space`
;; (Hold down ctrl and alt while pressing v, release the buttons and press space)

;; Evaluate top level form will regard anything directly in a `(comment)` as
;; top level. Try evaluating each of the below top level forms by moving the
;; cursor inside them and issue `ctrl+alt+v space`.
;; Use `ctrl+alt+v alt+space` to instead evaluate the forms in the REPL window.

(comment
  (Math/sin (/ Math/PI 6))
  (/ (* 1000 (Math/sin (/ Math/PI 6))) 1000)
  (/ (Math/round (* 1000 (Math/sin (/ Math/PI 6)))) 1000)
  (range 0 (* 2 Math/PI) (/ Math/PI 12))
  (map #(/ (Math/round (* 1000 (Math/sin %))) 1000) (range 0 (* 2 Math/PI) (/ Math/PI 12)))
  (map #(/ (Math/round (* 1000 (Math/cos %))) 1000) (range 0 (* 2 Math/PI) (/ Math/PI 12))))

;; To evaluate a form a particular form, place the cursour immediately before
;; or after it. For instance try placing the cursor right behind the closing paren
;; of `(* 2 Math/PI)` above and see what happens. Place the cursor between the I
;; in PI and the closing paren and see what happens.

;; To see what Calva commands are available, bring up the command palette with
;; `cmd+shift+p` on Mac, `ctrl+shift+p` on Windows, and type `Calva`.

;; Happy ClojureScript coding! ❤️