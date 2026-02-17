import java.time.Year;

public class StudentCourse {
  private Course course;
  private int gradeNum;
  private int yearCompleted = 0;

  private int getCurrentYear(){
    return Year.now().getValue();
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getGradeNum() {
    return gradeNum;
  }

  protected void setGrade(final int gradeNum) {
    if(checkGradeValidity(gradeNum)){
      this.gradeNum = gradeNum;
      if(yearCompleted == 0){
        this.yearCompleted = getCurrentYear();
      }
    }
  }

  private boolean checkGradeValidity(int gradeNum){
    if(
      (gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE)
      || gradeNum == ConstantValues.GRADE_FAILED 
      || gradeNum == ConstantValues.GRADE_ACCEPTED
    ){
      return true;
    }
    return false;
  }

  public boolean isPassed(){
    int grade = getGradeNum();
    if(grade == 0 || grade == 'F'){
      return false;
    }
    return true;
  }

  public int getYear(){
    return yearCompleted;
  }

  public void setYear(final int year){
    int currentYear = getCurrentYear();

    if(year >= 2000 && year <= currentYear){
      this.yearCompleted = year;
    }
  }

  @Override
  public String toString() {
    int grade = getGradeNum();
    String gradeString = grade == 0 ? "\"Not graded\"" : Integer.toString(grade);
    return String.format(
      "[%s, (%5.2f cr), \"%s\". %s, period: %d.] Year: %d, Grade: %s.]", 
      course.getCourseCode(), course.getCredits(), course.getName(), 
      course.getCourseTypeString(), course.getPeriod(), getYear(), gradeString
    );
  }

  public StudentCourse(){}

  public StudentCourse(
    Course course, final int gradeNum, 
    final int yearCompleted
  ){
    setCourse(course);
    setGrade(gradeNum);
    setYear(yearCompleted);
  }

  public static void main(String[] args) {
    Course x = new Course("a", 123, 'A', 1, 3, 5000.0, true);

    StudentCourse y = new StudentCourse(x, 2, 2021);

    System.out.println(y);
  }
}
