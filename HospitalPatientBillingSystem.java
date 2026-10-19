/* Requirements: Create a class Patient with instance variables patientId (int), patientName (String), 
consultationFee (double), testCount (int), and roomCharge (double). Create a class BillCalculator with methods 
calculateSubtotal(Patient p), calculateDiscount(double subtotal), calculateTax(double taxableAmount), and 
generateBill(Patient p). Apply a 10% discount when the subtotal is at least ₹5,000 and a 5% discount when it is 
at least ₹2,500 but below ₹5,000. Apply 5% tax after discount. In main(), read details for at least three patients 
using Scanner, create Patient objects, and print an itemized bill showing subtotal, discount, tax, and final 
amount. Reject negative fees, charges, or test counts. */

import java.util.Scanner;
class Patient{
int patientId, testCount;
String patientName;
double consultationFee, roomCharge;
    Patient(int patientId, String patientName, int testCount, double consultationFee, double roomCharge){
        this.patientId = patientId;
        this.patientName = patientName;
        this.testCount = testCount;
        this.consultationFee = consultationFee;
        this.roomCharge = roomCharge;
    }
}

class BillCalculator{
    public static final double testFee = 500.0;
    double calculateSubtotal(Patient p){
        return ((p.testCount*testFee)+p.consultationFee+p.roomCharge);
    }
    double calculateDiscount(double subtotal){
        if(subtotal>=5000){
            return subtotal*0.10;
        }else if(subtotal>=2500){
            return subtotal*0.05;
        }else{
            return 0.0;
        }
    }
    double calculateTax(double taxableAmount){
        return taxableAmount*0.05;
    }
    void generateBill(Patient p){
        double subTotal = calculateSubtotal(p);
        double discount = calculateDiscount(subTotal);
        double taxableAmount = subTotal-discount;
        double tax = calculateTax(taxableAmount);
        double finalAmount = taxableAmount+tax;


        System.out.println("====================================================================");
        System.out.println("                 Patient "+p.patientId+" Details                       ");
        System.out.println("====================================================================");
        System.out.println("Patient Id: "+p.patientId);
        System.out.println("Patient Name: "+p.patientName);
        System.out.println("Test Count: "+p.testCount);
        System.out.println("COnsultation Fee: "+ p.consultationFee);
        System.out.println("Room Charge: "+p.roomCharge);
        System.out.println("SubTotal:"+subTotal);
        System.out.printf("Discount:%.2f%n",discount);
        System.out.printf("TaxableAmount: %.2f%n",taxableAmount);
        System.out.printf("Tax: %.2f%n",tax);
        System.out.printf("Final Bill Amount:%.2f%n ",finalAmount);
        System.out.println();
        System.out.println();
    }
}
class HospitalPatientBillingSystem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BillCalculator b = new BillCalculator();

        System.out.println("Enter the number of patients: ");
        int n = sc.nextInt();

        while(n<3){
            System.out.println("Enter minimum 3 patient details");
            n=sc.nextInt();
        }

        for(int i=0;i<n; i++){
            System.out.println("Enter the details of Patient "+(i+1));
            System.out.println("Enter Patient Id: ");
            int patientId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Patient Name: ");
            String patientName = sc.nextLine().trim();

            System.out.println("Enter No.of Tests: ");
            int testCount =sc.nextInt();
            while(testCount<0)
            {
                System.out.println("Test Count Cannot be Negative!, PLease Enter again: ");
                testCount = sc.nextInt();
            }

            System.out.println("Enter Counsultation Fee: ");
                double consultationFee =sc.nextInt();
            while(consultationFee<0)
            {
                System.out.println("Consultation Fee Cannot be Negative!, PLease Enter again: ");
                consultationFee = sc.nextInt();
            }
            System.out.println("Enter Room Fee: ");
                double roomCharge =sc.nextInt();
            while(roomCharge<0)
            {
                System.out.println("Room Charge Cannot be Negative!, PLease Enter again: ");
                roomCharge = sc.nextInt();
            }
            Patient p = new Patient(patientId,patientName,testCount,consultationFee,roomCharge);
            b.generateBill(p);
        }

        
    sc.close();
    }
    
}
