package fi.sondeco.nlo2016;

public class Exercise2 {

  /**
   * Bisect search for optimal (minimizing) value of a given function f.
   * 
   * @param x minimum parameter value
   * @param y maximum parameter value
   * @param f objective function to minimize
   * @param quality quality of the required answer, when accuracy is reached the result is returned
   * @param epsilon small modifier < quality that is used to decide on the search section
   * @return parameter value that minimized function f in given range
   */
  public static double bisectSearch(double x, double y, SingleVariableObjectiveFunction f, double quality, double epsilon) {
    double mid = (x + y) / 2;

    while (mid - x > quality) {
      if (f.f(mid - epsilon) < f.f(mid + epsilon))
        y = mid;
      else
        x = mid;

      mid = (x + y) / 2;
    }

    return mid;
  }

  /**
   * Golden ratio search for optimal (minimum) value of given function f.
   * 
   * @param x minimum parameter value
   * @param y maximum parameter value
   * @param f objective function to minimize
   * @param quality quality of the required answer, when accuracy is reached the result is returned
   * @return parameter value that minimized function f in given range
   */
  public static double goldenRatioSearch(double x, double y, SingleVariableObjectiveFunction f, double quality) {
    double goldenSection = (Math.sqrt(5) - 1) / 2;
    double range = y - x;

    while (range > 2 * quality) {
      if (f.f(x + goldenSection * range) < f.f(y - goldenSection * range))
        x = y - goldenSection * range;
      else
        y = x + goldenSection * range;

      range = y - x;
    }

    return (x + y) / 2;
  }
  
}
