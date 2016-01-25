package fi.sondeco.nlo2016;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestExercise3 {

  @Test
  public void testGradientDescentEx3() {
    double[] x0 = { -1, 3 };
    
    double[] result = Exercise3.gradientDescent(x0, 0.1, 0.000001, ex3TestFunction);

    System.out.println("Ex3 with normal gradient descent:");
    System.out.println(Arrays.toString(result));

    assertEquals(-0.5, result[0], 0.0001);
    assertEquals(-1, result[1], 0.0001);
  }
  
  @Test
  public void testGradientDescent() {
    double[] x0 = { 1, 2, 3 };
    
    double[] result = Exercise3.gradientDescent(x0, 0.1, 0.000001, pow2TestFunction);

    System.out.println(Arrays.toString(result));

    for (int i = 0; i < result.length; i++)
      assertEquals(0, result[i], 0.0001);
  }

  /**
   * Test function for exercise 3.
   */
  GradientObjectiveFunction ex3TestFunction = new GradientObjectiveFunction() {
    public double f(double[] x) {
      return x[0] * x[0] + x[1] * x[1] + x[0] + 2 * x[1];
    }

    public double[] gradient(double[] x) {
      double[] grad = new double[2];

      grad[0] = 2 * x[0] + 1;
      grad[1] = 2 * x[1] + 2;
      
      return grad;
    }
  };
  
  /**
   * Test function with optimal at [0, 0, ... 0].
   */
  GradientObjectiveFunction pow2TestFunction = new GradientObjectiveFunction() {
    public double f(double[] x) {
      double sum = 0;
      
      for (int i = 0; i < x.length; i++)
        sum += x[i] * x[i];
      
      return sum;
    }

    public double[] gradient(double[] x) {
      double[] grad = new double[x.length];
      
      for (int i = 0; i < x.length; i++)
        grad[i] = 2 * x[i];
      
      return grad;
    }
  };
}
