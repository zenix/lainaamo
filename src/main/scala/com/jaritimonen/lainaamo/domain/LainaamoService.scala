package com.jaritimonen.lainaamo.domain

import com.jaritimonen.lainaamo.infrastructure.BookRepository
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.Imports._

abstract class LainaamoService {
  //TODO: Connection is left open.
  var bookRespository: BookRepository
  def findByName(name: String): List[Book] = {
    bookRespository.findByName(name)
  }

  def getAllBooks():List[Book] = {
    bookRespository.findAll()
  }

  def insertBook(book: Book) = {
    bookRespository.insert(book)
  }

  def deleteBook(name: String) = {
    bookRespository.remove(name)
  }

}
