public class Degree {
  static final int MAX_COURSES = 50;
  private int count;
  private String degreeTitle = ConstantValues.NO_TITLE;
  private String titleOfThesis = ConstantValues.NO_TITLE;
  private StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];

  public StudentCourse[] getCourses(){
    return myCourses;
  }

  public void addStudentCourses(StudentCourse[] courses){
    for(StudentCourse course : courses){
      addStudentCourse(course);
    }
  }

  public boolean addStudentCourse(StudentCourse course){
    if(count < MAX_COURSES && course != null){
      myCourses[count] = course;
      count++;
      return true;
    }

    return false;
  }

  public String getDegreeTitle() {
    return degreeTitle;
  }

  public void setDegreeTitle(String degreeTitle) {
    if(degreeTitle != null) {
      this.degreeTitle = degreeTitle;
    }
  }

  public String getTitleOfThesis() {
    return titleOfThesis;
  }

  public void setTitleOfThesis(String titleOfThesis) {
    if(degreeTitle != null){
      this.titleOfThesis = titleOfThesis;
    }
  }

  public double getCreditsByBase(Character base){
    double credits = 0.0;

    for(StudentCourse course : getCourses()){
      double courseBase = course.getCourse().getCourseBase();

      if(courseBase == base){
        credits += course.getCourse().getCredits();
      }
    }

    return credits;
  }

  public double getCreditsByType(final int courseType){
    double credits = 0.0;

    for(StudentCourse course : getCourses()){
      int currentCourseType = course.getCourse().getCourseType();
      
      if(currentCourseType == courseType){
        credits += course.getCourse().getCredits();
      }
    }

    return credits;
  }

  public double getCredits(){
    double credits = 0.0;

    for(StudentCourse course : getCourses()){
      if(course != null){
        credits += course.getCourse().getCredits();
      }
    }

    return credits;
  }

  private boolean isCourseCompleted(StudentCourse c){
    if(c != null & c.isPassed()){
      return true;
    }

    return false;
  }

  public void printCourses(){
    StudentCourse[] courses = getCourses();
    System.out.println();
    for(StudentCourse course : courses){
      if(course != null){
        System.out.println(course);
      }
    }
  }

  public int getCount() {
    return count;
  }

  @Override
  public String toString() {

    String s = String.format(
      "Degree [Title: \"%s\" (courses: %d)]\n\tThesis title: \"%s\"", 
      getDegreeTitle(), getCount(), getTitleOfThesis()
    );

    int count  = 0;

    for(StudentCourse course : getCourses()){
      if(course != null){
        count++;
        s += String.format("\n\t%d. %s", count, course.toString());
      }
    }
    return s;
  }

  public static void main(String[] args) {
    
    Course x = new Course("a", 123, 'A', 1, 3, 50.0, true);
    Course xx = new Course("b", 333, 'P', 1, 3, 25.0, true);

    StudentCourse y = new StudentCourse(x, 2, 2021);
    StudentCourse yy = new StudentCourse(xx, 3, 2023);

    Degree z = new Degree();

    z.addStudentCourse(y);
    z.addStudentCourse(yy);
    z.setDegreeTitle("asdasdas");
    z.setTitleOfThesis("oasdok asdo");

    System.out.println(z);

  }
}
