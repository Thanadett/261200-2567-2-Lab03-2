public class Patient {
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;
    private String bloodGroup;
    private String phoneNumber;

    private Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this.id = id;
        this.name = name;

        if (birthYear > 0) {
            this.birthYear = birthYear;
        } else {
            System.out.println("Invalid birthYear!");
            this.birthYear = 2000;
        }

        if (height > 0.0) {
            this.height = height;
        } else {
            System.out.println("Invalid height!");
            this.height = 170;
        }

        if (weight > 0.0) {
            this.weight = weight;
        } else {
            System.out.println("Invalid weight!");
            this.weight = 60;
        }

        if (bloodGroup.equals("A") || bloodGroup.equals("B") || bloodGroup.equals("AB") || bloodGroup.equals("O")){
            this.bloodGroup = bloodGroup;
        } else {
            System.out.println("Invalid BloodGroup");
            this.bloodGroup = "A";
        }

        if (phoneNumber.length() == 10){
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid PhoneNumber");
            this.phoneNumber = null;
        }
    }

    public int getAge(int currentYear){
        if (currentYear >= birthYear) {
            return currentYear - this.birthYear;
        } else {
            System.out.println("Invalid Age!");
            return 0;
        }
    }

    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("Patient BloodGroup: " + bloodGroup);
        System.out.println("Patient PhoneNumber: " + phoneNumber);
        System.out.println("Patient BMI: " + getBMI());
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBMI(){
        if (height <= 0 || weight <= 0){
            return 0.0;
        }
        else {
            double heightInM = height / 100.0;
            return weight / (heightInM * heightInM);
        }
    }

    public static void main(String[] args) {
        int currentYear = 2024;
        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0, "A", "0991981222");
        patient.displayDetails(currentYear);
        patient.getBMI();
        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0, "X", "012345678910");
        invalidPatient.displayDetails(currentYear);
    }
}

