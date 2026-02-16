public class Course {
  private String name;
  private String courseCode;
  private Character courseBase;
  private int courseType;
  private int period;
  private double credits;
  private boolean numericGrade;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if(name != null || name != ""){
      this.name = name;
    }
  }

  public String getCourseTypeString(){
    return courseType == 0 ? "Optional" : "Mandatory";
  }

  public int getCourseType(){
    return courseType;
  }

  public void setCourseType(final int type) {
    if(type == 1 || type == 0){
      this.courseType = type;
    }
  }

  public String getCourseCode(){
    return courseCode;
  }

  public void setCourseCode(final int courseCode, Character courseBase){
    boolean codeValid = courseCode > 0 && courseCode < 1000000;
    boolean baseValid = courseBase == 'A' || courseBase == 'P' || courseBase == 'S';

    if(codeValid && baseValid){
      this.courseCode = Integer.toString(courseCode) + courseBase;
    }
  }

  public Character getCourseBase(){
    return courseBase;
  }

  public int getPeriod(){
    return period;
  }

  public void setPeriod(final int period){
    if(period <= ConstantValues.MAX_PERIOD && period >= ConstantValues.MIN_PERIOD){
      this.period = period;
    }
  }

  public double getCredits(){
    return credits;
  }

  public void setCredits(final double credits){
    if(credits <= ConstantValues.MAX_COURSE_CREDITS && credits >= ConstantValues.MIN_CREDITS){
      this.credits = credits;
    }
  }

  public boolean isNumericGrade(){
    return numericGrade;
  }

  public void setNumericGrade(boolean numericGrade){
    this.numericGrade = numericGrade;
  }

  @Override
  public String toString() {
    return String.format(
      "[%s, (%5.2f cr),\"%s\". %s, period: %d.]", 
      getCourseCode(), getCredits(), getName(), 
      getCourseTypeString(), getPeriod()
    );
  }

  public Course(){}

  public Course(
    String name, final int code, 
    Character courseBase, final int type, 
    final int period, final double credits, 
    boolean numericGrade
  ) {
    setName(name);
    setCourseCode(code, courseBase);
    setCourseType(type);
    setPeriod(period);
    setCredits(credits);
  }

  public static void main(String[] args) {
    Course x = new Course("a", 123, 'A', 1, 3, 5000.0, true);

    System.out.println(x);
  }

}
