import java.time.Year;

public class Student {
  private String firstName = ConstantValues.NO_NAME;
  private String lastName = ConstantValues.NO_NAME;
  private int id;
  private double bachelorCredits;
  private double masterCredits;
  private String titleOfMasterThesis = ConstantValues.NO_TITLE;
  private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
  private int startYear = Year.now().getValue();
  private int graduationYear;
  private String birthDate = ConstantValues.NO_BIRTHDATE;

  public Student(){
    this.id = getRandomId();
  }

  public Student(String lname, String fname){
    this.id = getRandomId();
  }

  public int getRandomId(){
    return (int)((Math.random() * (ConstantValues.MAX_ID - ConstantValues.MIN_ID)) + ConstantValues.MIN_ID);
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

  public double getBachelorCredits() {
    return bachelorCredits;
  }

  public void setBachelorCredits(double bachelorCredits) {
    if (bachelorCredits >= 0.0 && bachelorCredits <= 300.0){
      this.bachelorCredits = bachelorCredits;
    }
  }

  public double getMasterCredits() {
    return masterCredits;
  }

  public void setMasterCredits(double masterCredits) {
    if (masterCredits >= 0.0 && masterCredits <= 300.0){
      this.masterCredits = masterCredits;
    }
  }

  public String getTitleOfMasterThesis() {
    return titleOfMasterThesis;
  }

  public void setTitleOfMasterThesis(String titleOfMasterThesis) {
    if (titleOfMasterThesis != null) {
      this.titleOfMasterThesis = titleOfMasterThesis;
    }
  }

  public String getTitleOfBachelorThesis() {
    return titleOfBachelorThesis;
  }

  public void setTitleOfBachelorThesis(String titleOfBachelorThesis) {
    if (titleOfBachelorThesis != null) {
      this.titleOfBachelorThesis = titleOfBachelorThesis;
    }
  }

  public int getStartYear() {
    return startYear;
  }

  public void setStartYear(int startYear) {
    if (startYear > 1999 && startYear <= Year.now().getValue()) {
      this.startYear = startYear;
    }
  }

  public int getGraduationYear() {
    return graduationYear;
  }

  public void setGraduationYear(int graduationYear) {
    if(canGraduate()){
      this.graduationYear = graduationYear;
    }
  }

  public boolean hasGraduated(){
    if (graduationYear <= Year.now().getValue()) {
      return true;
    }
    return false;
  }

  private boolean canGraduate(String titleOfBachelorThesis, String titleOfMasterThesis, double bachelorCredits, double masterCredits){
    if (
      !titleOfBachelorThesis.equals(ConstantValues.NO_TITLE)
      && !titleOfMasterThesis.equals(ConstantValues.NO_TITLE)
      && bachelorCredits >= ConstantValues.BACHELOR_CREDITS
      && bachelorCredits >= ConstantValues.BACHELOR_CREDITS
    ) {
      return true;
    }
    return false;
  }

  public int getStudyYears(int startYear, int graduationYear, boolean hasGraduated){
    if(hasGraduated){
      return graduationYear - startYear;
    }

    return Year.now().getValue() - startYear;
  }

  @Override
  public String toString() {
    return ""
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    if(id > 0 && id < 101){
      this.id = id;
    }
  }

  public static void main(String[] args) {
    Student x = new Student();

    System.out.println(x.id);
  }
}