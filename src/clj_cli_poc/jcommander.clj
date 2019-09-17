; (defrecord M [^{com.beust.jcommander.Parameter {:names ["--length" "-l"]}} ^Integer length])
; (def m (M. nil))
; (. (JCommander/newBuilder) (addObject m) build (parse (into-array ["--length" "5"])))
; (.-length m)
; nil