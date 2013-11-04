package com.jaritimonen.lainaamo.domain

import com.jaritimonen.lainaamo.infrastructure.BookRepository
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.Imports._
/**
 * Created with IntelliJ IDEA.
 * User: saha
 * Date: 2.11.2013
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
class LainaamoService {
  def findByName(name: String): List[Book] = {
    val toFind = "^" + name +".*"
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
