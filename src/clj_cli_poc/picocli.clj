(ns clj-cli-poc.picocli)

(import 'picocli.CommandLine$Option
        'picocli.CommandLine)

(defrecord Address [^{CommandLine$Option {:names ["--street" "-s"]}} street
                    ^{CommandLine$Option {:names ["--city" "-c"]}} city
                    ^{CommandLine$Option {:names ["--state" "-st"]}} state
                    ^{CommandLine$Option {:names ["--zip" "-z"]}} ^Integer zip])

(defn -main [& args]
  (let [address (map->Address {})]
    (. (CommandLine. address) (parseArgs (into-array args)))
    (prn (into {} address))))