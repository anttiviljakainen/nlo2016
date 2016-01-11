package fi.sondeco.nlo2016;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestExercise1 {

  @Test
  public void testGrades() {
    assertEquals(0, Exercise1.getGrade(9, 20));
    assertEquals(1, Exercise1.getGrade(10, 20));
    assertEquals(2, Exercise1.getGrade(13, 20));
    assertEquals(5, Exercise1.getGrade(18, 20));
    assertEquals(5, Exercise1.getGrade(20, 20));

    assertEquals(2, Exercise1.getGrade(130, 200));
  }

  @Test
  public void testFindMinimumPoints() {
    assertEquals(0, Exercise1.findMinimumPointsForGrade(0, 20));
    assertEquals(10, Exercise1.findMinimumPointsForGrade(1, 20));
    assertEquals(12, Exercise1.findMinimumPointsForGrade(2, 20));
    assertEquals(14, Exercise1.findMinimumPointsForGrade(3, 20));
    assertEquals(16, Exercise1.findMinimumPointsForGrade(4, 20));
    assertEquals(18, Exercise1.findMinimumPointsForGrade(5, 20));

    assertEquals(120, Exercise1.findMinimumPointsForGrade(2, 200));
  }
  
}
