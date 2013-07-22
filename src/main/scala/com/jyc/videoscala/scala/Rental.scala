package com.jyc.videoscala.scala

class Rental {
  private var movie: Movie = null
  private var daysRented: Int = 0

  def this(movie: Movie, daysRented: Int) {
    this()
    this.movie = movie
    this.daysRented = daysRented
  }

  def getMovie: Movie = {
    return movie
  }

  def getDaysRented: Int = {
    return daysRented
  }
}
