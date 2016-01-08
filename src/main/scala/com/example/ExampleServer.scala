package com.example

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

object ExampleServerMain extends ExampleServer

class ExampleServer extends HttpServer {

  override def defaultFinatraHttpPort = ":9999"

  override def configureHttp(router: HttpRouter) {
    val pingController = new PingController
    router.add(pingController)
  }

}
