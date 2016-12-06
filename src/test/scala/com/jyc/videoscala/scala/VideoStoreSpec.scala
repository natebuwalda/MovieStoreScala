package com.jyc.videoscala.scala

import org.scalatest.{MustMatchers, WordSpec}


class VideoStoreSpec extends WordSpec with MustMatchers {

  "The customer statement" should {
    "contain all of the movies rented by a customer" in {
      val expectedStatement  =
        "Rental Record for Nate\n\tPulp Fiction\t2.0\n\tLilo & Stitch\t1.5\n\tGladiator\t8.0\n\tMagic Mike\t3.0\nYou owed 14.5\nYou earned 4 frequent renter points\n"

      val nate = new Customer("Nate")
      nate.addRental(new Rental(new Movie("Pulp Fiction", Movie.REGULAR), 2))
      nate.addRental(new Rental(new Movie("Lilo & Stitch", Movie.CHILDRENS), 3))
      nate.addRental(new Rental(new Movie("Gladiator", Movie.REGULAR), 6))
      nate.addRental(new Rental(new Movie("Magic Mike", Movie.NEW_RELEASE), 1))

      nate.statement must be(expectedStatement)
    }

    "still render successfully if no movies were rented" in {
      val expectedStatement  =
        "Rental Record for Nate\nYou owed 0.0\nYou earned 0 frequent renter points\n"

      val nate = new Customer("Nate")

      nate.statement must be(expectedStatement)
    }

  }

}
