package com.jaritimonen.lainaamo.infrastructure

import com.novus.salat.dao.SalatDAO
import com.jaritimonen.lainaamo.domain.Book
import com.mongodb.casbah.MongoConnection
import com.novus.salat.global._
/**
 * Created with IntelliJ IDEA.
 * User: saha
 * Date: 2.11.2013
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
object BookRepository extends SalatDAO[Book, Double](collection = MongoConnection()("lainaamo")("books"))