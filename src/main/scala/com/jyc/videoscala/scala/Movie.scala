package com.jyc.videoscala.scala

import scala.Predef.String

class Movie {
  final val REGULAR: Int = 1
  final val NEW_RELEASE: Int = 2
  final val CHILDRENS: Int = 3

  private var title: String = null
  private var priceCode: Int = 0

  def this(title: String, priceCode: Int) {
    this()
    this.title = title
    this.priceCode = priceCode
  }

  def getTitle: String = {
    title
  }

  def getPriceCode: Int = {
    priceCode
  }
}
