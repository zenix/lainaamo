package com.jaritimonen.lainaamo.ui

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import com.jaritimonen.lainaamo.domain.{Book, LainaamoService}

abstract class LainaamoServlet extends ScalatraServlet with JacksonJsonSupport  {

  protected implicit val jsonFormats: Formats = DefaultFormats
  var lainaamoService:LainaamoService

  before() {
    contentType = formats("json")
  }

  get("/books") {
  }

  post("/book") {
    lainaamoService.insertBook(parsedBody.extract[Book])
  }

  get("/book/find/by/name/:name"){
    lainaamoService.findByName(params("name"))
  }

  delete("/book/delete/by/name/:name"){
  }
}
