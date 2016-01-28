package fi.sondeco.nlo2016;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import fi.sondeco.nlo2016.testfunctions.SphereObjectiveFunction;

public class TestExercise3 {

  @Test
  public void testGradientDescentEx3Golden() {
    double[] x0 = { -1, 3 };
    
    System.out.println("Ex3 with golden section gradient descent:");
    double[] result = Exercise3.gradientDescentWithGoldenSection(x0, 0.0000001, ex3TestFunction);
    System.out.println("Ex3, golden line search gradient descent result: " + Arrays.toString(result));

    assertEquals(-0.5, result[0], 0.001);
    assertEquals(-1, result[1], 0.001);
  }
  
  @Test
  public void testGradientDescentEx3() {
    double[] x0 = { -1, 3 };
    
    System.out.println("Ex3 with normal gradient descent:");
    double[] result = Exercise3.gradientDescent(x0, 0.1, 0.0000001, ex3TestFunction);

    System.out.println("Ex3, normal gradient descent result: " + Arrays.toString(result));

    assertEquals(-0.5, result[0], 0.001);
    assertEquals(-1, result[1], 0.001);
  }
  
  @Test
  public void testGradientDescent() {
    double[] x0 = { 1, 2, 3 };
    
    System.out.println("3D Sphere test");
    double[] result = Exercise3.gradientDescent(x0, 0.1, 0.0000001, new SphereObjectiveFunction());
    System.out.println("3D Sphere test result " + Arrays.toString(result));

    for (int i = 0; i < result.length; i++)
      assertEquals(0, result[i], 0.001);
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
  
}
