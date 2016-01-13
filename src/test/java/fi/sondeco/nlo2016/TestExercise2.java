package fi.sondeco.nlo2016;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestExercise2 {

  @Test
  public void testBisectSearch() {
    double quality = 0.01;
    assertEquals(Math.sqrt(2), Exercise2.bisectSearch(0, 2, sqrt2TestFunction, quality, quality / 10), quality);
  }

  @Test
  public void testGoldenSearch() {
    double quality = 0.01;
    assertEquals(Math.sqrt(2), Exercise2.goldenRatioSearch(0, 2, sqrt2TestFunction, quality), quality);
  }

  @Test
  public void testExercise2() {
    /**
     * NLO Exercise 2
     */
    
    double quality = 0.001;
    
    double bisect = Exercise2.bisectSearch(0, 2, exercise2Function, quality, quality / 10);
    double golden = Exercise2.goldenRatioSearch(0, 2, exercise2Function, quality);
    
    System.out.println("Exercise 2 Bisect search optima: " + bisect);
    System.out.println("Exercise 2 Golden search optima: " + golden);
  }

  /**
   * Test function with optimal (min) at sqrt(2).
   */
  SingleVariableObjectiveFunction sqrt2TestFunction = new SingleVariableObjectiveFunction() {
    public double f(double x) {
      return Math.abs(x - Math.sqrt(2));
    }
  };
  
  /**
   * Function used in the course for exercise 2.
   */
  SingleVariableObjectiveFunction exercise2Function = new SingleVariableObjectiveFunction() {
    public double f(double x) {
      return Math.pow(1 - x, 2) + x;
    }
  };
}
