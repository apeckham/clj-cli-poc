(ns clj-cli-poc.picocli
  (:import picocli.CommandLine$Option
           picocli.CommandLine))

(defrecord Address [^{picocli.CommandLine$Option {:names ["-a"]}} street])

(defn -main [& args]
  (let [a (Address. nil)
        r (. (CommandLine. a) (parseArgs (into-array args)))
        option (first (. r matchedOptions))]
    (prn (. option shortestName))
    (prn (. option getValue))))