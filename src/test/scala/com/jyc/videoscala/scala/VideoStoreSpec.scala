package com.jyc.videoscala.scala

import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class VideoStoreSpec extends Specification {
  val expectedStatement  =
    "Rental Record for Nate\n\tPulp Fiction\t2.0\n\tLilo & Stitch\t1.5\n\tGladiator\t8.0\n\tMagic Mike\t3.0\nYou owed 14.5\nYou earned 4 frequent renter points\n"

  "The customer statement" should {
    "look like the expected statement in Java" in {
      val nate = new Customer("Nate")
      nate.addRental(new Rental(new Movie("Pulp Fiction", Movie.REGULAR), 2))
      nate.addRental(new Rental(new Movie("Lilo & Stitch", Movie.CHILDRENS), 3))
      nate.addRental(new Rental(new Movie("Gladiator", Movie.REGULAR), 6))
      nate.addRental(new Rental(new Movie("Magic Mike", Movie.NEW_RELEASE), 1))

      nate.statement() must beEqualTo(expectedStatement)
    }

    "look the same in Scala" in {
      import com.jyc.videoscala.scala._

      val nate = new Customer("Nate")
      nate.addRental(new Rental(new Movie("Pulp Fiction", Movie.REGULAR), 2))
      nate.addRental(new Rental(new Movie("Lilo & Stitch", Movie.CHILDRENS), 3))
      nate.addRental(new Rental(new Movie("Gladiator", Movie.REGULAR), 6))
      nate.addRental(new Rental(new Movie("Magic Mike", Movie.NEW_RELEASE), 1))

      nate.statement must beEqualTo(expectedStatement)
    }


  }

}
