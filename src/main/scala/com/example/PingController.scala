package com.example

import java.net.URLDecoder

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class PingController extends Controller {

  get("/ping") { request: Request =>
    "pong"
  }

  get("/article/:id") { request: Request =>
    val id = URLDecoder.decode(request.params("id"), "UTF-8")
    s"You requested article $id"
  }

  get("/:id/fulltext.html") { request: Request =>
    val id = URLDecoder.decode(request.params("id"), "UTF-8")
    s"You requested fulltext for $id"
  }
}
