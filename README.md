# quil-cljs-calva-template

A template project to get you started with ClojureScript and Quil, using [Figwheel](https://github.com/bhauman/lein-figwheel), VS Code, and [Calva](https://github.com/BetterThanTomorrow/calva).

Prerequisites:

* Java is installed. (I recommend using [SDK-MAN](https://sdkman.io) for that.)
* [Leiningen is installed](https://leiningen.org/#install).
* You have installed Calva in VS Code. (Search for it in the Extensions pane, `cmd+shift+x` on Mac, `ctrl+shift+x` on Windows.)

## Usage

There are two steps:

1. First start the example/starter app in your browser.
1. Then connect Calva to the ClojureScript REPL and start hacking.

Like so:

### Start the app:

1. From the project directory, run `lein repl` in a terminal window and wait for the REPL prompt.
1. Run `(figwheel-start)` and wait for the message `Successfully compiled "resources/public/js/main.js"`.
1. Open [localhost:3449](http://localhost:3449) in your browser and look at the circles moving around.

Figwheel will be your best friend while developing your Quil sketch. Whenever you save your source files the browser will automatically refresh everything, providing you with quick feedback. For more information about Figwheel, check the [Figwheel repository on GitHub](https://github.com/bhauman/lein-figwheel).


### Connect Calva

1. Open `src/quil_cljs_calva_template/core.cljs` of this project in VS Code.
2. Run the **Calva: Connect** command, `ctrl+alt+v c`.

See [the bottom of that core.cljs](https://github.com/PEZ/quil-cljs-calva-template/blob/master/src/quil_cljs_calva_template/core.cljs#L50) file for some starting tips on REPL powered, interactive development with Calva.


## Happy ClojureScript Coding!

❤️

## Publishing your sketch

Before you publish your sketch, run `lein do clean, cljsbuild once optimized`. This will compile your code and run Google Closure Compiler with advanced optimizations. Take `resources/public/index.html` and `resources/public/js/main.js` and upload them to server of your choice.

## License

I (PEZ) claim no Copyright to any of the code or text in this project. Use it as you like. (I do hope you will use it for the good.)

The original project, created by the `lein new quil-cljs something-something` command had the below licence information. I don't know if that is important, so keeping it.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
