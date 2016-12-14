package com.jyc.videoscala.scala

import com.jyc.videoscala.scala.refactor.CustomerStatement
import org.scalatest.{MustMatchers, WordSpec}


class VideoStoreSpec extends WordSpec with MustMatchers {

  "The customer statement in Java-like Scala" should {
    "contain all of the movies rented by a customer" in {
      val expectedStatement  =
        "Rental Record for Nate\n\tPulp Fiction\t2.0\n\tLilo & Stitch\t1.5\n\tGladiator\t8.0\n\tMagic Mike\t6.0\nYou owed 17.5\nYou earned 5 frequent renter points\n"

      val nate = new Customer("Nate")
      nate.addRental(new Rental(new Movie("Pulp Fiction", Movie.REGULAR), 2))
      nate.addRental(new Rental(new Movie("Lilo & Stitch", Movie.CHILDRENS), 3))
      nate.addRental(new Rental(new Movie("Gladiator", Movie.REGULAR), 6))
      nate.addRental(new Rental(new Movie("Magic Mike", Movie.NEW_RELEASE), 2))

      nate.statement must be(expectedStatement)
    }

    "still render successfully if no movies were rented" in {
      val expectedStatement  =
        "Rental Record for Nate\nYou owed 0.0\nYou earned 0 frequent renter points\n"

      val nate = new Customer("Nate")

      nate.statement must be(expectedStatement)
    }

  }

  "The customer statement in refactored Scala" should {
    import com.jyc.videoscala.scala.refactor._

    "contain all of the movies rented by a customer" in {

      val expectedStatement  =
        "Rental Record for Nate\n\tPulp Fiction\t2.0\n\tLilo & Stitch\t1.5\n\tGladiator\t8.0\n\tMagic Mike\t6.0\nYou owed 17.5\nYou earned 5 frequent renter points\n"

      val nate = Customer("Nate")
      val rentals = Seq(
        Rental(nate, Movie("Pulp Fiction", RegularPriceCode.price, RegularPriceCode.points), 2),
        Rental(nate, Movie("Lilo & Stitch", ChildrensPriceCode.price, ChildrensPriceCode.points), 3),
        Rental(nate, Movie("Gladiator", RegularPriceCode.price, RegularPriceCode.points), 6),
        Rental(nate, Movie("Magic Mike", NewReleasePriceCode.price, NewReleasePriceCode.points), 2)
      )

      CustomerStatement.createStatement(nate, rentals) must be(expectedStatement)
    }

    "still render successfully if no movies were rented" in {
      val expectedStatement  =
        "Rental Record for Nate\nYou owed 0.0\nYou earned 0 frequent renter points\n"

      val nate = Customer("Nate")

      CustomerStatement.createStatement(nate, Seq()) must be(expectedStatement)
    }

  }

}
