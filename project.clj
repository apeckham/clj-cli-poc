(defproject clj-cli-poc "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.beust/jcommander "1.78"]
                 [cli-matic "0.3.8"]
                 [info.picocli/picocli "4.0.4"]]
  :main ^:skip-aot clj-cli-poc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
