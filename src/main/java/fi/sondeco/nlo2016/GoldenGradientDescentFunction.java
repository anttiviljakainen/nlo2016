package fi.sondeco.nlo2016;

class GoldenGradientDescentFunction implements SingleVariableObjectiveFunction {

  public GoldenGradientDescentFunction(GradientObjectiveFunction f, double[] vector, int componentIndex) {
    this.gradientFunction = f;
    this.componentIndex = componentIndex;
    this.vector = new double[vector.length];
    System.arraycopy(vector, 0, this.vector, 0, vector.length);
  }
  
  public double f(double x) {
    vector[componentIndex] = x;
    return this.gradientFunction.f(vector);
  }
  
  private GradientObjectiveFunction gradientFunction;
  private double[] vector;
  private int componentIndex;
}