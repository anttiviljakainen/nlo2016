package fi.sondeco.nlo2016;

public class PenalizedObjectiveFunction implements ObjectiveFunction {

  public PenalizedObjectiveFunction(ObjectiveFunction of, double r) {
    this.of = of;
    this.r = r;
  }
  
  public double f(double[] x) {
    return of.f(x) + r * penalty(x);
  }
  
  private double penalty(double[] x) {
    return 0;
  }

  private double r;
  private ObjectiveFunction of;
}
