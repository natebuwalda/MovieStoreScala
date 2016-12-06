package com.jyc.videoscala.scala

class Movie {
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

object Movie {
  val REGULAR: Int = 1
  val NEW_RELEASE: Int = 2
  val CHILDRENS: Int = 3
}
