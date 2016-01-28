package fi.sondeco.nlo2016;

import java.util.Arrays;

public class Exercise3 {

  public static double[] gradientDescentWithGoldenSection(double[] x0, double precision, GradientObjectiveFunction f) {
    double[] next = x0;
    double[] current;
    
    int iteration = 0;
    
    do {
      iteration++;
      current = new double[next.length];
      System.arraycopy(next, 0, current, 0, next.length);
      
      double[] gradient = f.gradient(current);
      
      for (int i = 0; i < current.length; i++) {
        GoldenGradientDescentFunction gradientFunc = new GoldenGradientDescentFunction(f, current, i);
        double goldenStep = Exercise2.goldenRatioSearch(-gradient[i], 0, gradientFunc, 0.001);
        
        next[i] = current[i] + goldenStep;
      }
      
      System.out.println(String.format("Golden Iter: %d Vector: %s", iteration, Arrays.toString(next)));
    } while (Math.abs(f.f(current) - f.f(next)) > precision);
    
    return next;
  }
  
  public static double[] gradientDescent(double[] x0, double step, double precision, GradientObjectiveFunction f) {
    double[] next = x0;
    double[] current;
    
    int iteration = 0;
    do {
      iteration++;
      current = new double[next.length];
      System.arraycopy(next, 0, current, 0, next.length);
      
      double[] gradient = f.gradient(current);
      
      for (int i = 0; i < current.length; i++) {
        next[i] = current[i] - step * gradient[i];
      }

      System.out.println(String.format("GradDesc Iter: %d Vector: %s", iteration, Arrays.toString(next)));
    } while (Math.abs(f.f(current) - f.f(next)) > precision);
    
    return current;
  }

}
