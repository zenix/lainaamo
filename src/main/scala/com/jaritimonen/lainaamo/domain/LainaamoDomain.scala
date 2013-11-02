package com.jaritimonen.lainaamo.domain

import com.novus.salat.annotations.Key
abstract class LainaamoDomain
case class Author(firstName: String, lastName:String)
case class Book(name: String, isbn10: String, isbn13:String,authors: List[Author], description: String)
