package Week9;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        ArrayList<Doctor> doctor = new ArrayList<Doctor>();
        ArrayList<Patient> patients = new ArrayList<Patient>();

        while(true) {
            System.out.println("Choose an option\n" +
                    "1. Add Doctor\n" +
                    "2. Add Patient\n" +
                    "3. Perform Examination\n" +
                    "4. Exit");
            ch = sc.nextInt();
            boolean breakCon = false;
            int inform;
            String name, d;
            int age;
            switch (ch) {
                case 1:
                    System.out.println("Select type of Doctor:\n" +
                            "1. Physician (Internal Medicine)\n" +
                            "2. Surgeon (Surgery)\n" +
                            "3. Pediatrician (Pediatrics)");
                    inform = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Doctor's Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Doctor's Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Hospital Affiliation: ");
                    d = sc.nextLine();
                    switch (inform) {
                        case 1:
                            Physician physician = new Physician(name, age, d);
                            doctor.add(physician);
                            break;
                        case 2:
                            Surgeon surgeon = new Surgeon(name, age, d);
                            doctor.add(surgeon);
                            break;
                        case 3:
                            Pediatrician pediatrician = new Pediatrician(name, age, d);
                            doctor.add(pediatrician);
                            break;
                        default:
                            System.out.println("Your input is wrong index");
                            break;
                    }
                    System.out.println("Doctor added successfully!\n");
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Enter Patient's Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Patient's Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Select Department:\n" +
                            "1. Internal Medicine\n" +
                            "2. Surgery\n" +
                            "3. Pediatrics\n");
                    inform = sc.nextInt();
                    switch (inform) {
                        case 1:
                            Patient phy = new Patient(name, age, "Internal Medicine");
                            patients.add(phy);
                            break;
                        case 2:
                            Patient sur = new Patient(name, age, "Surgery");
                            patients.add(sur);
                            break;
                        case 3:
                            Patient ped = new Patient(name, age, "Pediatrics");
                            patients.add(ped);
                            break;
                        default:
                            System.out.println("Your input is wrong index");
                            break;
                    }
                    System.out.println("Patient added successfully!\n");
                    break;
                case 3:
                    if(doctor.isEmpty() || patients.isEmpty()) {
                        System.out.println("Add some doctors and patients first!\n");
                        break;
                    }
                    System.out.println("Select a Doctor:");
                    int idx = 1;
                    for(Doctor o : doctor) {
                        System.out.println(idx++ + ". " + o);
                    }
                    int sd = sc.nextInt();
                    sc.nextLine();
                    idx = 1;
                    for(Patient o : patients) {
                        System.out.println(idx++ + ". " + o);
                    }
                    int sp = sc.nextInt();
                    doctor.get(sd-1).examination(patients.get(sp-1));
                    break;
                case 4:
                    breakCon = true;
                    break;
                default:
                    System.out.println("Please input Valid Number.\n");
                    break;
            }

            if(breakCon) break;
        }
    }
}
