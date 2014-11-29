(defproject flechette "0.1.0-SNAPSHOT"
  :description "An incredibly over-engineered blog."
  :url "http://example.com/FIXME"
  :min-lein-version "2.4.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-devel "1.3.2"]
                 [cheshire "5.3.1"]
                 [org.immutant/immutant "2.0.0-beta1"]]
  :plugins [[lein-immutant "2.0.0-alpha2"]]
  :main flechette.core 
  :uberjar-name "flechette-standalone.jar"
  :profiles {:uberjar {:aot [flechette.core]}})
