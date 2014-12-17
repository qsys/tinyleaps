(ns qsys.be
  (:require [vertx.core :refer [config deploy-verticle deploy-module]]))

(let [cfg (config)]
  (deploy-verticle "qsys/be/api.clj"
    :config (:api cfg))

  (deploy-module "io.vertx~mod-web-server~2.0.0-final"
    :config (:webserver cfg))

  (deploy-module "com.bloidonia~mod-jdbc-persistor~2.1.2"
    :config (:db cfg)
    :instances 1))


