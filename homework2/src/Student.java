import java.time.Year;

public class Student {
  private String firstName = ConstantValues.NO_NAME;
  private String lastName = ConstantValues.NO_NAME;
  private int id = getRandomId();
  private int startYear = getCurrentYear();
  private int graduationYear;
  private int degreeCount = 3;
  private Degree[] degrees = new Degree[3];
  private String birthDate = ConstantValues.NO_BIRTHDATE;

  public Student(){}

  public Student(String lname, String fname){
    if(lname != null){
      this.lastName = lname;
    }
    if(fname != null){
      this.firstName = fname;
    }
  }
  
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    if(firstName != null){
      this.firstName = firstName;
    }
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    if(lastName != null){
      this.lastName = lastName;
    }
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    if(id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID){
      this.id = id;
    }
  }

  public int getStartYear() {
    return startYear;
  }

  public void setStartYear(final int startYear) {
    int currentYear = getCurrentYear();
    if (startYear > 2000 && startYear <= currentYear) {
      this.startYear = startYear;
    }
  }

  public int getGraduationYear() {
    return graduationYear;
  }

  public String setGraduationYear(final int graduationYear) {
    int currentYear = getCurrentYear();
    int startYear = getStartYear();

    if(!canGraduate()){
      return "Check amount of required credits";
    } else if(graduationYear < startYear || graduationYear > currentYear){
      return "Check graduation year";
    }

    this.graduationYear = graduationYear;
    return "Ok";
  }

  public void setDegreeTitle(final int i, String dName){
    if(i >= 0 && i <= degreeCount){
      degrees[i].setDegreeTitle(dName);
    }
  }

  public boolean addCourse(final int i, StudentCourse course){
    if(i >= 0 && i <= degreeCount && course != null){
      degrees[i].addStudentCourse(course);
      return true;
    }

    return false;
  }

  public int addCourses(final int i, StudentCourse[] courses){
    int count = 0;
    if(i >= 0 && i <= degreeCount){
      for(StudentCourse course : courses){
        if(course != null){
          degrees[i].addStudentCourse(course);
          count++;
        }
      }
    }

    return count;
  }

  public void printCourses(){
    for(Degree degree : degrees){
      if(degree != null){
        degree.printCourses();
      }
    }
  }

  public void printDegrees(){
    for(Degree degree : degrees){
      System.out.println();
      if(degree != null){
        System.out.println(degree);
      }
    }
  }

  public void setTitleOfThesis(final int i, String title){
    if(i >= 0 && i <= degreeCount && title != null){
      degrees[i].setTitleOfThesis(title);
    }
  }

  private String getBirthDate(){
    return birthDate;
  }

  public String setBirthDate(String personId){
    if(personId == null){
      return "No change";
    }
    PersonID id = new PersonID();
    String check = id.setPersonId(personId);
    if(check.equals("Ok")){
      this.birthDate = id.getBirthDate();
      return this.birthDate;
    }
    return "No change";
  }

  public boolean hasGraduated() {
    return graduationYear != 0 && graduationYear < getCurrentYear();
  }

  private boolean canGraduate(){
    double bachelorCredits = 0.0;
    double masterCredits = 0.0;

    for(StudentCourse course : degrees[0].getCourses()){
      if(course != null && course.isPassed()){
        bachelorCredits += course.getCourse().getCredits();
      }
    }

    for(StudentCourse course : degrees[1].getCourses()){
      if(course != null && course.isPassed()){
        masterCredits += course.getCourse().getCredits();
      }
    }

    if(
      masterCredits >= ConstantValues.MASTER_CREDITS &&
      bachelorCredits >= ConstantValues.BACHELOR_CREDITS &&
      degrees[0].getTitleOfThesis() != ConstantValues.NO_TITLE &&
      degrees[1].getTitleOfThesis() != ConstantValues.NO_TITLE
    ){
      return true;
    }

    return false;
  }

  public int getStudyYears(){
    if(hasGraduated()){
      return getGraduationYear() - getStartYear();
    }

    return getCurrentYear() - getStartYear();
  }

  private int getCurrentYear(){
    return Year.now().getValue();
  }

  private int getRandomId(){
    return (int)((Math.random() * (ConstantValues.MAX_ID - ConstantValues.MIN_ID)) + ConstantValues.MIN_ID);
  }

  @Override
  public String toString() {
    String status = hasGraduated() 
      ? String.format("The student has graduated in %d", getGraduationYear())
      : "The student has not graduated, yet";
    
    double bachelorCredits = degrees[0].getCredits();
    double masterCredits = degrees[1].getCredits();
    
    String bachelorCreditsStr = bachelorCredits >= ConstantValues.BACHELOR_CREDITS
      ? String.format(
          "Total bachelor credits completed (%.1f/%.1f)", 
          bachelorCredits, ConstantValues.BACHELOR_CREDITS
        ) 
      : String.format(
          "Missing bachelor credits: %.1f (%.1f/%.1f)", 
          ConstantValues.BACHELOR_CREDITS - bachelorCredits, bachelorCredits, ConstantValues.BACHELOR_CREDITS
        );

    String masterCreditsStr = masterCredits >= ConstantValues.MASTER_CREDITS
      ? String.format(
          "Total master's credits completed (%.1f/%.1f)", 
          masterCredits, ConstantValues.MASTER_CREDITS
        ) 
      : String.format(
          "Missing master's credits: %.1f (%.1f/%.1f)", 
          ConstantValues.MASTER_CREDITS - masterCredits, masterCredits, ConstantValues.MASTER_CREDITS
        );
    
    String bd = getBirthDate() == ConstantValues.NO_BIRTHDATE 
    ? String.format("\"%s\"", ConstantValues.NO_BIRTHDATE) 
    : getBirthDate();
    
    return String.format(
      """
      \n\nStudent id: %d
      \tFirst name: %s, Last name: %s
      \tDate of birth: %s
      \tStatus: %s
      \tStart year: %d (Studies have lasted for %d years)
      \tTotal credits: %.1f
      \tBachelor credits: %.1f
      \t\t%s
      \t\tTitle of BSc Thesis: %s
      \tMaster credits: %.1f
      \t\t%s
      \t\tTitle of MSc Thesis: %s
      """, 
      getId(), getFirstName(), getLastName(), 
      bd, status, getStartYear(), getCurrentYear() - getStartYear(), 
      degrees[0].getCredits() + degrees[1].getCredits(),
      degrees[0].getCredits(), bachelorCreditsStr, degrees[0].getTitleOfThesis(),
      degrees[1].getCredits(), masterCreditsStr, degrees[1].getTitleOfThesis()
    );
  }

  public static void main(String[] args) {
    Student x = new Student();

    Course one = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
    Course two = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
    Course three = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
    Course four = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
    Course five = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
    Course six = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
    Course seven = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
    Course eight = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
    Course nine = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
    Course ten = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
    Course eleven = new Course("Final master studie", 888888, 'S', 1, 5, 18.0, false);

    StudentCourse oneS = new StudentCourse(one, 1, 2013);
    StudentCourse twoS = new StudentCourse(two, 1, 2014);
    StudentCourse threeS = new StudentCourse(three, 1, 2015);
    StudentCourse fourS = new StudentCourse(four, 4, 2016);
    StudentCourse fiveS = new StudentCourse(five, 5, 2017);
    StudentCourse sixS = new StudentCourse(six, 1, 2018);
    StudentCourse sevenS = new StudentCourse(seven, 1, 2019);
    StudentCourse eightS = new StudentCourse(eight, 2, 2020);
    StudentCourse nineS = new StudentCourse(nine, 0, 2021);
    StudentCourse tenS = new StudentCourse(ten, 'A', 2021);
    StudentCourse elevenS = new StudentCourse(eleven, 'f', 2022);

    StudentCourse[] bachelors = {oneS, twoS, threeS, fourS, fiveS};
    StudentCourse[] masters = {sixS, sevenS, eightS, nineS, tenS, elevenS};

    x.degrees[0] = new Degree();
    x.degrees[1] = new Degree();

    x.degrees[0].setDegreeTitle("Bachelor of Science");
    x.degrees[1].setDegreeTitle("Master of Science");
    x.degrees[0].setTitleOfThesis("Bachelor thesis title");
    x.degrees[1].setTitleOfThesis("Master thesis title");

    x.degrees[0].addStudentCourses(bachelors);
    x.degrees[1].addStudentCourses(masters);

    x.setStartYear(2001);
    x.setGraduationYear(2020);
    x.setFirstName("Donald");
    x.setLastName("Duck");

    System.out.println(x);

    x.setBirthDate("230498-045T");

    x.degrees[0].setTitleOfThesis("Christmas - The most wonderful time of the year");
    x.degrees[1].setTitleOfThesis("Dreaming of a white Christmas");

    x.printDegrees();

    x.degrees[1].getCourses()[3].setGrade(3);

    System.out.println(x);

    x.printDegrees();

    x.printCourses();

    x.degrees[1].getCourses()[5].setGrade('X');
    System.out.println(x.degrees[1].getCourses()[5]);
    x.degrees[1].getCourses()[5].setGrade('a');
    System.out.println(x.degrees[1].getCourses()[5]); 

    x.degrees[0].getCourses()[0].setGrade(6);
    System.out.println(x.degrees[0].getCourses()[0]); 
    x.degrees[0].getCourses()[0].setGrade(5);
    System.out.println(x.degrees[0].getCourses()[0]); 

  }
}