package com.example

import java.net.URLEncoder

import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.finagle.http.{Response, Request}
import com.twitter.util.Future

class DoiEncodingFilter extends SimpleFilter[Request, Response] {
  override def apply(request: Request, service: Service[Request, Response]): Future[Response] = {
    if (request.uri.startsWith("/article/")) {
      service(Request("/article/" + URLEncoder.encode(request.uri.stripPrefix("/article/"), "UTF-8")))
    } else if (request.uri.endsWith("/fulltext.html")) {
      service(Request("/" + URLEncoder.encode(request.uri.substring(1).stripSuffix("/fulltext.html"), "UTF-8") + "/fulltext.html"))
    } else {
      service(request)
    }
  }
}