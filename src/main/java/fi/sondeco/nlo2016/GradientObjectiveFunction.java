package fi.sondeco.nlo2016;

public interface GradientObjectiveFunction extends ObjectiveFunction {
  
  double[] gradient(double[] x);
  
}
