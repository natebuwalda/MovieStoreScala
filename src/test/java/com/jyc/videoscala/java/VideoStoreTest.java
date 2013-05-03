package com.jyc.videoscala.java;

import org.junit.Assert;
import org.junit.Test;

public class VideoStoreTest {

    @Test
    public void shouldProduceAStatement() throws Exception {
        Customer nate = new Customer("Nate");
        nate.addRental(new Rental(new Movie("Pulp Fiction", Movie.REGULAR), 2));
        nate.addRental(new Rental(new Movie("Lilo & Stitch", Movie.CHILDRENS), 3));
        nate.addRental(new Rental(new Movie("Gladiator", Movie.REGULAR), 6));
        nate.addRental(new Rental(new Movie("Magic Mike", Movie.NEW_RELEASE), 1));

        String natesStatement = nate.statement();

        String expectedStatement = "Rental Record for Nate\n" +
                "\tPulp Fiction\t2.0\n" +
                "\tLilo & Stitch\t1.5\n" +
                "\tGladiator\t8.0\n" +
                "\tMagic Mike\t3.0\n" +
                "You owed 14.5\n" +
                "You earned 4 frequent renter points\n";

        Assert.assertEquals(expectedStatement, natesStatement);
    }
}
