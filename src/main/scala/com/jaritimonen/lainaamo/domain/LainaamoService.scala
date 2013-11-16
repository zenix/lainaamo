package com.jaritimonen.lainaamo.domain

import com.jaritimonen.lainaamo.infrastructure.BookRepository
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.Imports._

class LainaamoService {
  def findByName(name: String): List[Book] = {
    val toFind = "(?i).*" + name +".*"
    BookRepository.find(MongoDBObject("name" -> toFind.r)).toList
  }

  def getAllBooks():List[Book] = {
    //TODO: Connection is left open.
    BookRepository.find(MongoDBObject.empty).toList
  }

  def insertBook(book: Book) = {
    BookRepository.insert(book)
  }

}
