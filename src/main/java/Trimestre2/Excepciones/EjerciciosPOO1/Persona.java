package Trimestre2.Excepciones.EjerciciosPOO1;

class Persona {
  private Nif nif;
  private FullName fullName;
  private Gender gender;
  private Status status;
  private double sueldo;

  private static final String DEFAULT_NAME = "****";
  private static final String DEFAULT_APELLIDO1 = "*****";
  private static final String DEFAULT_APELLIDO2 = "******";

  public void displayDetails() {
    this.nif.displayDetails();
    System.out.println("Nombre: " + this.fullName.getFirstName());
    System.out.println("Primer Apellido: " + this.fullName.getLastName1());
    System.out.println("Segundo Apellido: " + this.fullName.getLastName2());
    System.out.println("Sexo:" + this.gender);
    System.out.println("Estado:" + this.status);
    this.getBirthDate().verFecha();
  }

  public Persona(String nif, String no, String ap1, String ap2, Gender gender, Status estado, double su, int d, int m,
      int a) {
    this.nif = new Nif(nif); // Assuming nif is a valid string DNI
    this.fullName = new FullName(no, ap1, ap2);
    this.gender = gender;
    this.status = estado;
    this.sueldo = su;
    this.birthDate = new Fecha(d, m, a);
  }

  public Persona(Nif ni, String no, String ap1, String ap2, Gender gender, Status estado, double su, Fecha fe) {
    this.nif = ni;
    this.fullName = new FullName(no, ap1, ap2);
    this.gender = gender;
    this.status = estado;
    this.sueldo = su;
    this.birthDate = fe;
  }

  public Persona() {

    this.nif = new Nif();
    this.fullName = new FullName(DEFAULT_NAME, DEFAULT_APELLIDO1, DEFAULT_APELLIDO2);
    this.gender = Gender.UNKNOWN;
    this.status = Status.ACTIVE;
    this.birthDate = new Fecha();
  }

  public Nif getNif() {
    return nif;
  }

  public void setNif(Nif nif) {
    this.nif = nif;
  }

  public FullName getFullName() {
    return fullName;
  }

  public void setFullName(FullName fullName) {
    this.fullName = fullName;
  }

  public String getFirstName() {
    return fullName.getFirstName();
  }

  public void setFirstName(String firstName) {
    this.fullName = new FullName(firstName, fullName.getLastName1(), fullName.getLastName2());
  }

  public String getLastName1() {
    return fullName.getLastName1();
  }

  public void setLastName1(String lastName1) {
    this.fullName = new FullName(fullName.getFirstName(), lastName1, fullName.getLastName2());
  }

  public String getLastName2() {
    return fullName.getLastName2();
  }

  public void setLastName2(String lastName2) {
    this.fullName = new FullName(fullName.getFirstName(), fullName.getLastName1(), lastName2);
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public double getSueldo() {
    return sueldo;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  private Fecha birthDate;

  public Fecha getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Fecha birthDate) {
    this.birthDate = birthDate;
  }

  public void updateDetails(String nombre, String apellido1, String apellido2, Gender gender,
      double sueldo) {

    this.fullName = new FullName(nombre, apellido1, apellido2);
    this.gender = gender;
    this.sueldo = sueldo;

  }

  @Override
  public String toString() {
    return "Persona [nif=" + nif + ", fullName=" + fullName + ", gender=" + gender + ", sueldo=" + sueldo +
        ", birthDate=" + birthDate + ", status=" + status + "]";
  }

  public static void main(String[] args) {
    Persona Alberto;
    Alberto = new Persona();
    System.out.println(Alberto.toString());
    Alberto.displayDetails();

    System.out.println("     -----      ");
    Alberto.setFirstName("Juan");
    Alberto.setLastName1("Garcia");
    Alberto.setLastName2("Torreznos");
    Alberto.gender = Gender.MALE;
    Alberto.sueldo = 1050.4;

    Alberto.displayDetails();
    Persona ana = new Persona("123455", "Ana", "Robles", "Montilla", Gender.FEMALE, Status.ACTIVE, 1200, 5, 1, 1980);
    System.out.println(ana.toString());
    ana.displayDetails();

    Fecha fe = new Fecha(01, 01, 1980);
    Nif ni = new Nif("888888881A");
    Persona elena = new Persona(ni, "Elena", "Lopez", "Lopez", Gender.FEMALE, Status.ACTIVE, 1500, fe);
    System.out.println(elena.toString());
    elena.displayDetails();
  }
}
