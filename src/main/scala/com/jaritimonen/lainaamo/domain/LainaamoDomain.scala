package com.jaritimonen.lainaamo.domain
import com.mongodb.casbah.Imports._
abstract class LainaamoDomain

case class Author(firstName: String, lastName:String)
case class Book(id: Option[String], name: String, isbn10: String, isbn13:String,authors: List[Author], description: String)