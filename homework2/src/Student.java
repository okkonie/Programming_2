import java.time.Year;

public class Student {
  private String firstName = ConstantValues.NO_NAME;
  private String lastName = ConstantValues.NO_NAME;
  private int id;
  private double bachelorCredits;
  private double masterCredits;
  private String titleOfMasterThesis = ConstantValues.NO_TITLE;
  private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
  private int startYear = getCurrentYear();
  private int graduationYear = 0;
  private String birthDate = ConstantValues.NO_BIRTHDATE;

  public Student(){
    setId(getRandomId());
  }

  public Student(String lname, String fname){
    if(lname != null){
      this.lastName = lname;
    }
    if(fname != null){
      this.firstName = fname;
    }
    setId(getRandomId());
  }

  private String getBirthDate(){
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  private int getCurrentYear(){
    return Year.now().getValue();
  }

  private int getRandomId(){
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

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    if(id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID){
      this.id = id;
    }
  }

  public double getBachelorCredits() {
    return bachelorCredits;
  }

  public void setBachelorCredits(final double bachelorCredits) {
    if (bachelorCredits >= 0.0 && bachelorCredits <= 300.0){
      this.bachelorCredits = bachelorCredits;
    }
  }

  public double getMasterCredits() {
    return masterCredits;
  }

  public void setMasterCredits(final double masterCredits) {
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
      return "Check the required studies";
    } else if(graduationYear < startYear || graduationYear > currentYear){
      return "Check graduation year";
    }

    this.graduationYear = graduationYear;
    return "Ok";
  }

  public boolean hasGraduated() {
    return graduationYear != 0 && graduationYear < getCurrentYear();
  }

  private boolean canGraduate(){
    if (
      !getTitleOfBachelorThesis().equals(ConstantValues.NO_TITLE)
      && !getTitleOfMasterThesis().equals(ConstantValues.NO_TITLE)
      && getBachelorCredits() >= ConstantValues.BACHELOR_CREDITS
      && getMasterCredits() >= ConstantValues.MASTER_CREDITS
    ) {
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

  private String bdString(){
    boolean hasBd = !getBirthDate().equals(ConstantValues.NO_BIRTHDATE);
    String s = "\n\tDate of birth: " + (!hasBd ? "\"" : "") + getBirthDate() + (!hasBd ? "\"" : "");
    return s;
  }

  private String status(){
    if(hasGraduated()){
      return "\n\tStatus: The student has graduated in " + getGraduationYear();
    }
    return "\n\tStatus: The student has not graduated, yet";
  }

  private String startYear(){
    int startYear = getStartYear();
    int studyYears = getStudyYears();

    if(hasGraduated()){
      return "\n\tStart year: " + startYear + " (studies lasted for " + studyYears + " years)";
    }

    return "\n\tStart year: " + startYear + " (studies have lasted for " + studyYears + " years)";
  }

  private String bachelorCredits(){
    bachelorCredits = getBachelorCredits();
    if(bachelorCredits < ConstantValues.BACHELOR_CREDITS){
      return 
        "\n\tBachelorCredits: " + 
        "%.1f".formatted(getBachelorCredits()) + 
        " ==> Missing bachelor credits " +
        String.format("%.1f", ConstantValues.BACHELOR_CREDITS - bachelorCredits) +
        " (" + String.format("%.1f", bachelorCredits) + "/" +
        String.format("%.1f", ConstantValues.BACHELOR_CREDITS) + ")";
    }

    return 
      "\n\tBachelorCredits: " + 
      "%.1f".formatted(getBachelorCredits()) + 
      " ==>  All required bachelor credits completed" +
      " (" + String.format("%.1f", bachelorCredits) + "/" +
      String.format("%.1f", ConstantValues.BACHELOR_CREDITS) + ")";
  }

  private String titleOfBachelor(){
    return "\n\tTitleOfBachelorThesis: " + "\"" + getTitleOfBachelorThesis() + "\"";
  }

  private String masterCredits(){
    masterCredits = getMasterCredits();
    if(masterCredits < ConstantValues.MASTER_CREDITS){
      return 
        "\n\tMasterCredits: " + 
        "%.1f".formatted(getMasterCredits()) + 
        " ==> Missing master credits " +
        String.format("%.1f", ConstantValues.MASTER_CREDITS - masterCredits) +
        " (" + String.format("%.1f", masterCredits) + "/" +
        String.format("%.1f", ConstantValues.MASTER_CREDITS) + ")";
    }

    return 
      "\n\tMasterCredits: " + 
      "%.1f".formatted(getMasterCredits()) + 
      " ==>  All required master credits completed" +
      " (" + String.format("%.1f", masterCredits) + "/" +
      String.format("%.1f", ConstantValues.MASTER_CREDITS) + ")";
  }

  private String titleOfMaster(){
    return "\n\tTitleOfMasterThesis: " + "\"" + getTitleOfMasterThesis() + "\"";
  }

  @Override
  public String toString() {
    return 
      "Student id: " + getId()
      + "\n\tFirstName: " + getFirstName() + ", LastName: " + getLastName()
      + bdString()
      + status()
      + startYear()
      + bachelorCredits()
      + titleOfBachelor()
      + masterCredits()
      + titleOfMaster()
      + "\n\n";
  }
}