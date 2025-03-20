import java.util.*;

public class HospitalManagementSystem {

    // Patient Class
    static class Patient {
        private String name;
        private int age;
        private String gender;
        private String address;
        private String contactNumber;
        private String patientID;

        public Patient(String name, int age, String gender, String address, String contactNumber) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
            this.contactNumber = contactNumber;
            this.patientID = "P" + System.currentTimeMillis(); // Unique Patient ID
        }

        public String getPatientID() {
            return patientID;
        }

        public void displayPatientInfo() {
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Gender: " + gender);
            System.out.println("Address: " + address);
            System.out.println("Contact Number: " + contactNumber);
        }
    }

    // Appointment Class
    static class Appointment {
        private String patientID;
        private Date appointmentDate;
        private String doctorName;
        private String appointmentID;

        public Appointment(String patientID, Date appointmentDate, String doctorName) {
            this.patientID = patientID;
            this.appointmentDate = appointmentDate;
            this.doctorName = doctorName;
            this.appointmentID = "A" + System.currentTimeMillis(); // Unique Appointment ID
        }

        public String getAppointmentID() {
            return appointmentID;
        }

        public void displayAppointmentInfo() {
            System.out.println("Appointment ID: " + appointmentID);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Appointment Date: " + appointmentDate);
            System.out.println("Doctor: " + doctorName);
        }
    }

    // EHR Class (Electronic Health Records)
    static class EHR {
        private String patientID;
        private String healthRecords;

        public EHR(String patientID, String healthRecords) {
            this.patientID = patientID;
            this.healthRecords = healthRecords;
        }

        public void displayHealthRecords() {
            System.out.println("Health Records for Patient ID: " + patientID);
            System.out.println(healthRecords);
        }

        public void updateHealthRecords(String newRecord) {
            this.healthRecords += "\n" + newRecord;
        }
    }

    // Bill Class
    static class Bill {
        private String patientID;
        private double amount;
        private String billID;

        public Bill(String patientID, double amount) {
            this.patientID = patientID;
            this.amount = amount;
            this.billID = "B" + System.currentTimeMillis(); // Unique Bill ID
        }

        public void displayBill() {
            System.out.println("Bill ID: " + billID);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Amount: $" + amount);
        }
    }

    // InventoryItem Class
    static class InventoryItem {
        private String itemName;
        private int quantity;
        private double pricePerUnit;
        private String itemID;

        public InventoryItem(String itemName, int quantity, double pricePerUnit) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.pricePerUnit = pricePerUnit;
            this.itemID = "I" + System.currentTimeMillis(); // Unique Item ID
        }

        public void displayInventoryItem() {
            System.out.println("Item ID: " + itemID);
            System.out.println("Item Name: " + itemName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per Unit: $" + pricePerUnit);
        }

        public void updateQuantity(int newQuantity) {
            this.quantity = newQuantity;
        }
    }

    // Staff Class
    static class Staff {
        private String name;
        private String role;
        private String staffID;

        public Staff(String name, String role) {
            this.name = name;
            this.role = role;
            this.staffID = "S" + System.currentTimeMillis(); // Unique Staff ID
        }

        public void displayStaffInfo() {
            System.out.println("Staff ID: " + staffID);
            System.out.println("Name: " + name);
            System.out.println("Role: " + role);
        }
    }

    // Main class
    public static void main(String[] args) {
        // List to hold all objects
        List<Patient> patients = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        List<EHR> ehrRecords = new ArrayList<>();
        List<Bill> bills = new ArrayList<>();
        List<InventoryItem> inventoryItems = new ArrayList<>();
        List<Staff> staffMembers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View EHR");
            System.out.println("4. Generate Bill");
            System.out.println("5. Manage Inventory");
            System.out.println("6. Manage Staff");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Register Patient
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patient gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter patient address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter patient contact number: ");
                    String contactNumber = scanner.nextLine();
                    Patient patient = new Patient(name, age, gender, address, contactNumber);
                    patients.add(patient);
                    System.out.println("Patient Registered. Patient ID: " + patient.getPatientID());
                    break;

                case 2:
                    // Schedule Appointment
                    System.out.print("Enter patient ID: ");
                    String patientID = scanner.nextLine();
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter appointment date (dd/mm/yyyy): ");
                    String dateInput = scanner.nextLine();
                    Date appointmentDate = new Date(); // Simplification for the example, in real code, you'd parse date
                    Appointment appointment = new Appointment(patientID, appointmentDate, doctorName);
                    appointments.add(appointment);
                    System.out.println("Appointment Scheduled. Appointment ID: " + appointment.getAppointmentID());
                    break;

                case 3:
                    // View EHR
                    System.out.print("Enter patient ID: ");
                    String ehrPatientID = scanner.nextLine();
                    System.out.print("Enter health records: ");
                    String healthRecords = scanner.nextLine();
                    EHR ehr = new EHR(ehrPatientID, healthRecords);
                    ehrRecords.add(ehr);
                    ehr.displayHealthRecords();
                    break;

                case 4:
                    // Generate Bill
                    System.out.print("Enter patient ID: ");
                    String billPatientID = scanner.nextLine();
                    System.out.print("Enter bill amount: ");
                    double amount = scanner.nextDouble();
                    Bill bill = new Bill(billPatientID, amount);
                    bills.add(bill);
                    bill.displayBill();
                    break;

                case 5:
                    // Manage Inventory
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price per unit: ");
                    double pricePerUnit = scanner.nextDouble();
                    InventoryItem item = new InventoryItem(itemName, quantity, pricePerUnit);
                    inventoryItems.add(item);
                    item.displayInventoryItem();
                    break;

                case 6:
                    // Manage Staff
                    System.out.print("Enter staff name: ");
                    String staffName = scanner.nextLine();
                    System.out.print("Enter staff role: ");
                    String role = scanner.nextLine();
                    Staff staff = new Staff(staffName, role);
                    staffMembers.add(staff);
                    staff.displayStaffInfo();
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting the Hospital Management System.");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
