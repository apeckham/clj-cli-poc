(ns clj-cli-poc.picocli)

(import 'picocli.CommandLine$Option
        'picocli.CommandLine)

(defrecord Address [^{picocli.CommandLine$Option {:names ["--street" "-s"]}} street
                    ^{picocli.CommandLine$Option {:names ["--city" "-c"]}} city
                    ^{picocli.CommandLine$Option {:names ["--state" "-st"]}} state
                    ^{picocli.CommandLine$Option {:names ["--zip" "-z"]}} zip])

(defn -main [& args]
  (let [address (map->Address {:zip 90210})]
    (. (CommandLine. address) (parseArgs (into-array args)))
    (prn (into {} address))))