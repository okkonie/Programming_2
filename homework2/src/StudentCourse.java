import java.time.Year;

public class StudentCourse {
  private Course course;
  private int gradeNum;
  private int yearCompleted = 0;

  public StudentCourse(){}

  public StudentCourse(
    Course course, final int gradeNum, 
    final int yearCompleted
  ){
    setCourse(course);
    setGrade(gradeNum);
    setYear(yearCompleted);
  }

  private int getCurrentYear(){
    return Year.now().getValue();
  }

  public Course getCourse(){
    return course;
  }

  public void setCourse(Course course){
    this.course = course;
  }

  public int getGradeNum(){
    return gradeNum;
  }

  protected void setGrade(final int gradeNum){
    if(checkGradeValidity(gradeNum)){
      this.gradeNum = gradeNum;
      if(yearCompleted == 0){
        setYear(getCurrentYear());
      }
    }
  }

  private boolean checkGradeValidity(int gradeNum){
    if(getCourse().isNumericGrade()){
      return (gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE);
    } else {
      return (gradeNum == ConstantValues.GRADE_FAILED || gradeNum == ConstantValues.GRADE_ACCEPTED);
    }
  }

  public boolean isPassed(){
    int grade = getGradeNum();
    if(course.isNumericGrade()){
      return grade != 0;
    }
    return grade != 'F' && grade != 'f';
  }

  public int getYear(){
    return yearCompleted;
  }

  public void setYear(final int year){
    if(year >= 2000 && year <= getCurrentYear()){
      this.yearCompleted = year;
    }
  }

  @Override
  public String toString() {
    int grade = getGradeNum();
    String gradeString = 
      grade == 0 ? "\"Not graded\"" 
      : course.isNumericGrade() ? Integer.toString(grade)
      : Character.toString((char)grade);
  
    return String.format(
      "[%s, (%5.2f cr), \"%s\". %s, period: %d.] Year: %d, Grade: %s.]", 
      course.getCourseCode(), course.getCredits(), course.getName(), 
      course.getCourseTypeString(), course.getPeriod(), getYear(), gradeString
    );
  }

  public static void main(String[] args) {
    Course x = new Course("a", 666666, 'A', 2, 3, 20.0, true);

    StudentCourse y = new StudentCourse(x, 'A', 2021);

    System.out.println(y);
  }
}
