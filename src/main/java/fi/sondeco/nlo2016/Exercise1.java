package fi.sondeco.nlo2016;

public class Exercise1 {
  
  public static void main(String[] args) {
  }

  /**
   * Finds minimum number of points needed to achieve a given grade.
   * 
   * @param grade grade wanted
   * @param maxPoints maximum points of class
   * @return minimum number of points needed for the grade
   */
  public static int findMinimumPointsForGrade(int grade, int maxPoints) {
    for (int points = 0; points <= maxPoints; points++) {
      if (getGrade(points, maxPoints) >= grade)
        return points;
    }
    
    return -1;
  }
  
  /**
   * Returns grade (0 for failed, 1 - 5 for passed) for given points < maxPoints.
   * 
   * 50% of the points are needed for grade 1, 90+% for grade 5.
   * 
   * @param points points achieved on class
   * @param maxPoints maximum points of class
   * @return grade
   */
  public static int getGrade(int points, int maxPoints) {
    double gradePerPoint = 10d / maxPoints;
    double grade = gradePerPoint * points - 4;
    
    return Math.min(5, Math.max(0, (int) Math.floor(grade)));
  }
  
}
