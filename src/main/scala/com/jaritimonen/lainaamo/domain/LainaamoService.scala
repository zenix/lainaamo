package com.jaritimonen.lainaamo.domain

import com.jaritimonen.lainaamo.infrastructure.BookRepository
import com.mongodb.casbah.commons.MongoDBObject

/**
 * Created with IntelliJ IDEA.
 * User: saha
 * Date: 2.11.2013
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
class LainaamoService {
  def getAllBooks():List[Book] = {
    //TODO: Connection is left open.
    BookRepository.find(MongoDBObject.empty).toList
  }

}
