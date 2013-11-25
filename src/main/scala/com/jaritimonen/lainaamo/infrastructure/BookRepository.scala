package com.jaritimonen.lainaamo.infrastructure

import com.jaritimonen.lainaamo.domain.{Author, Book}
import com.mongodb.casbah.Imports._

abstract class BookRepository {

  var collection:MongoCollection

  def insert(book:Book) = {
    val authors = book.authors.map((author: Author) => MongoDBObject("firstName" -> author.firstName, "lastName" -> author.lastName))
    val bookData = MongoDBObject("name" -> book.name,
                  "authors" -> authors,
                  "isbn10" -> book.isbn10,
                  "isbn13" -> book.isbn13,
                  "description" -> book.description)
    collection.insert(bookData)
  }

  def findByName(name:String):List[Book] = {
    collection.find(createMongoDbObjectForNameLike(name)).map(book => toBook(book)).toList
  }

  //TODO:test
  def findAll(): List[Book] = {
    collection.find().map(book => toBook(book)).toList
  }

  //TODO:test
  def remove(name: String) = {
    collection.findAndRemove(createMongoDbObjectForNameLike(name))
  }

  def createMongoDbObjectForNameLike(name: String): DBObject = {
    MongoDBObject("name" -> getAllIgnoreCaseRegexp(name).r)
  }

  def getAllIgnoreCaseRegexp(name: String) : String = {
    return "(?i).*" + name + ".*"
  }

  def toBook(dbObject: DBObject): Book = {
    Book(Some(dbObject._id.get.toString), dbObject.as[String]("name"),dbObject.as[String]("isbn10"), dbObject.as[String]("isbn13"), toAuthors(dbObject.as[MongoDBList]("authors")), dbObject.as[String]("description"))
  }

  def toAuthors(authors: MongoDBList): List[Author] = {
    authors.map((dbObject: Any) => Author(dbObject.asInstanceOf[DBObject].as[String]("firstName"),dbObject.asInstanceOf[DBObject].as[String]("lastName"))).toList
  }

}