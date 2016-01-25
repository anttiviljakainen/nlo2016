package fi.sondeco.nlo2016;

public interface GradientObjectiveFunction {
  
  double f(double[] x);
  
  double[] gradient(double[] x);
  
}
