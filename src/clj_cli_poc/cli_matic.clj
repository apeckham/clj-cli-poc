(ns clj-cli-poc.cli-matic)

(require '[cli-matic.core :refer [run-cmd]])

(defn add_numbers
  "Sums A and B together, and prints it in base `base`"
  [{:keys [a b base] :as x}]
  (prn x)
  (println
   (Integer/toString (+ a b) base)))

(defn subtract_numbers
  "Subtracts B from A, and prints it in base `base` "
  [{:keys [a b base]}]
  (println
   (Integer/toString (- a b) base)))

(def CONFIGURATION
  {:app         {:command     "toycalc"
                 :description "A command-line toy calculator"
                 :version     "0.0.1"}

   :global-opts [{:option  "base"
                  :as      "The number base for output"
                  :type    :int
                  :default 10}]

   :commands    [{:command     "add"
                  :description "Adds two numbers together"
                  :opts        [{:option "a" :as "Addendum 1" :type :int :default :present :env "VARA"}
                                {:option "b" :as "Addendum 2" :type :int :default 0}]
                  :runs        add_numbers}

                 {:command     "sub"
                  :description "Subtracts parameter B from A"
                  :opts        [{:option "a" :as "Parameter A" :type :int :default 0}
                                {:option "b" :as "Parameter B" :type :int :default 0}]
                  :runs        subtract_numbers}]})

(defn -main
  "This is our entry point.
  Just pass parameters and configuration.
  Commands (functions) will be invoked as appropriate."
  [& args]
  (run-cmd args CONFIGURATION))