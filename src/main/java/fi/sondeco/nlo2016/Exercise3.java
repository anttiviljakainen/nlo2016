package fi.sondeco.nlo2016;

public class Exercise3 {

  public static double[] gradientDescent(double[] x0, double step, double precision, GradientObjectiveFunction f) {
    double[] next = x0;
    double[] current;
    
    do {
      current = new double[next.length];
      System.arraycopy(next, 0, current, 0, next.length);
      
      double[] gradient = f.gradient(current);
      
      for (int i = 0; i < current.length; i++) {
        next[i] = current[i] - step * gradient[i];
      }
    } while (rmse(current, next) > precision);
    
    return current;
  }
  
  public static void quasiNewton(double epsilon) {
    
  }
  
  private static double rmse(double[] a, double[] b) {
    double ret = 0;

    for (int i = 0; i < a.length; i++)
      ret += (a[i] - b[i]) * (a[i] - b[i]);
    
    return Math.sqrt(ret);
  }
}
