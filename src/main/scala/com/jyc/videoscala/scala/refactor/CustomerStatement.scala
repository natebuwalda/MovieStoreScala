package com.jyc.videoscala.scala.refactor

object CustomerStatement {

  private val lines: Seq[Printable[StoreEntity]] = Seq()

  def createStatement(customer: Customer, rentals: Seq[Rental]): String = {
    StatementHeader.print(customer) + rentals.map(r => MovieAmount.print(r)).fold("")((acc, l) => acc + l) + OwedAmount.print(rentals) + RenterPoints.print(rentals)
  }

}

trait StoreEntity
case class Customer(name: String) extends StoreEntity
case class Movie(name: String, price: Int => Double, points: Int => Int) extends StoreEntity
case class Rental(customer: Customer, movie: Movie, days: Int) extends StoreEntity

trait Printable[T] {
    def print(input: T): String
}

object StatementHeader extends Printable[Customer] {
  override def print(customer: Customer): String =
    "Rental Record for " + customer.name + "\n"
}

object MovieAmount extends Printable[Rental] {
  override def print(rental: Rental): String =
    "\t" + rental.movie.name + "\t" + rental.movie.price(rental.days) + "\n"
}

object OwedAmount extends Printable[Seq[Rental]] {
  override def print(rentals: Seq[Rental]): String =
    "You owed " + rentals.map(rental => rental.movie.price(rental.days)).sum + "\n"
}

object RenterPoints extends Printable[Seq[Rental]] {
  override def print(input: Seq[Rental]): String =
    "You earned " + input.map(rental => rental.movie.points(rental.days)).sum + " frequent renter points\n"
}

trait PriceCode {
  def price(days: Int): Double
  def points(days: Int): Int
}

case object RegularPriceCode extends PriceCode {
  override def price(days: Int): Double = {
    def overage(days: Int): Double = {
      if (days > 2) (days - 2) * 1.5 else 0.0
    }

    2.0 + overage(days)
  }

  override def points(days: Int): Int = 1
}

case object NewReleasePriceCode extends PriceCode {
  override def price(days: Int): Double = {
    3.0 * days
  }

  override def points(days: Int): Int = {
    if (days > 1) 2 else 1
  }
}

case object ChildrensPriceCode extends PriceCode {
  override def price(days: Int): Double = {
    def overage(days: Int): Double = {
      if (days > 3) (days - 3) * 1.5 else 0.0
    }

    1.5 + overage(days)
  }

  override def points(days: Int): Int = 1
}
