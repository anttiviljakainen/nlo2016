package fi.sondeco.nlo2016;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import fi.sondeco.nlo2016.testfunctions.SphereObjectiveFunction;

public class TestNelderMead {

  @Test
  public void testSphere() {
    NelderMead nm = new NelderMead();
    
    double[] x0 = { 1, 2, 3 };
    
    System.out.println("3D Sphere test");
    double[] result = nm.minimize(x0, new SphereObjectiveFunction());
    System.out.println("3D Sphere test result " + Arrays.toString(result));

    for (int i = 0; i < result.length; i++)
      assertEquals(0, result[i], 0.001);
  }
  
}
