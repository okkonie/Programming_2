public class Degree {
  static final int MAX_COURSES = 50;
  private int count = 0;
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
    if(titleOfThesis != null){
      this.titleOfThesis = titleOfThesis;
    }
  }

  public double getCreditsByBase(Character base){
    double credits = 0.0;

    for(StudentCourse course : getCourses()){
      if(course != null && isCourseCompleted(course)){
        Character courseBase = course.getCourse().getCourseBase();

        if(courseBase == base){
          credits += course.getCourse().getCredits();
        }
      }
    }

    return credits;
  }

  public double getCreditsByType(final int courseType){
    double credits = 0.0;

    for(StudentCourse course : getCourses()){
      if(course != null && isCourseCompleted(course)){
        int currentCourseType = course.getCourse().getCourseType();
        
        if(currentCourseType == courseType){
          credits += course.getCourse().getCredits();
        }
      }
    }

    return credits;
  }

  public double getCredits(){
    double credits = 0.0;

    for(StudentCourse course : getCourses()){
      if(course != null && isCourseCompleted(course)){
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
    
    Degree z = new Degree();

    System.out.println(z);

  }
}
