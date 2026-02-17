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
      myCourses[count + 1] = course;
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
    
  }
}
