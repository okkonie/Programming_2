public class StudentCourse {
  private Course course;
  private int gradeNum;
  private int yearCompleted;

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getGradeNum() {
    return gradeNum;
  }

  protected void setGrade(int gradeNum) {
    course.isNumericGrade()
    this.gradeNum = gradeNum;
  }

  public StudentCourse(){}

  public StudentCourse(
    Course course, final int gradeNum, 
    final int yearCompleted
  ){
    setCourse(course);
    setGradeNum(gradeNum);
    setYearCompleted(yearCompleted);
  }
}
