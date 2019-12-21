(defproject darmok-core-logic "0.1.0-SNAPSHOT"
  :description "A project to demonstrate core.logic based on the Tamarian language presented in the Darmok Star Trek TNG episode."
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/core.logic "0.8.11"]]
  :repl-options {:init-ns darmok-core-logic.core})
