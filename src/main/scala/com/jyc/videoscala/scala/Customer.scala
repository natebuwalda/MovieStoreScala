package com.jyc.videoscala.scala

import collection.mutable.ListBuffer
import java.lang.String
import scala.Predef.String


class Customer(val name: String) {

  val rentals = ListBuffer[Rental]()

  def statement(): String = {
    var totalAmount: Double = 0
    var frequentRenterPoints: Int = 0
    var result: String = "Rental Record for " + name + "\n"

    val iterator: Iterator[Rental] = rentals.iterator

    while (iterator.hasNext) {
      var thisAmount: Double = 0
      val each: Rental = iterator.next
      each.getMovie.getPriceCode match {
        case Movie.REGULAR =>
          thisAmount += 2
          if (each.getDaysRented > 2) thisAmount += (each.getDaysRented - 2) * 1.5
        case Movie.NEW_RELEASE =>
          thisAmount += each.getDaysRented * 3
        case Movie.CHILDRENS =>
          thisAmount += 1.5
          if (each.getDaysRented > 3) thisAmount += (each.getDaysRented - 3) * 1.5
        case _ =>
      }

      frequentRenterPoints += 1
      if ((each.getMovie.getPriceCode == Movie.NEW_RELEASE) && each.getDaysRented > 1) ({
        frequentRenterPoints += 1; frequentRenterPoints - 1
      })

      result += "\t" + each.getMovie.getTitle + "\t" + String.valueOf(thisAmount) + "\n"
      totalAmount += thisAmount
    }

    result += "You owed " + String.valueOf(totalAmount) + "\n"
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n"

    return result
  }

  def addRental(rental: Rental) = rentals += rental

}
