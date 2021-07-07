package com.company.incomplete;

import com.company.Job;
import com.company.Employer;
import com.company.Location;
import com.company.PositionType;
import com.company.CoreCompetency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JobTests {


    private static final Job jobOne = new Job();
    private static final Job jobTwo = new Job();
    private static final Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private static final Job jobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private static final Job jobFive = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));

    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
        Assertions.assertEquals(1, jobOne.getId());
        Assertions.assertEquals(2, jobTwo.getId());
        Assertions.assertFalse(jobOne.getId() == jobTwo.getId());
        Assertions.assertTrue((jobOne.getId() + 1) == jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Assertions.assertEquals(3, jobThree.getId());
        Assertions.assertEquals("Product tester", jobThree.getName());
        Assertions.assertEquals("ACME", jobThree.getEmployer().toString());
        Assertions.assertEquals("Desert", jobThree.getLocation().toString());
        Assertions.assertEquals("Quality control", jobThree.getPositionType().toString());
        Assertions.assertEquals("Persistence", jobThree.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {
        Assertions.assertEquals(false, jobThree == jobFour);
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        String toString = jobThree.toString();
        Assertions.assertTrue(toString.contains("\n" + "ID: "));
        Assertions.assertTrue((toString.contains(jobThree.getCoreCompetency() + "\n")));
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        String toString = jobThree.toString();
        Assertions.assertTrue(toString.contains("ID: "));
        Assertions.assertTrue(toString.contains("Name: "));
        Assertions.assertTrue(toString.contains("Employer: "));
        Assertions.assertTrue(toString.contains("Location: "));
        Assertions.assertTrue(toString.contains("Position Type: "));
        Assertions.assertTrue(toString.contains("Core Competency: "));
    }

    @Test
    public void testToStringDataNotAvailable() {

    }
}
