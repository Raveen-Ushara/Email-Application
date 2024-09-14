package emailApp;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String dep;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 12;
    private String alternateEmail;
    private String CompanySuffix = "uovt.ac.com";
     
    
    // Constructor to receive the first name and last name
     public Email (String firstName, String lastName) {
         this.firstName = firstName;
         this.lastName = lastName;
         
         // Call a method asking for the department & return the department
         this.department = setDepartment();
         
         // Call a method that returns a random password
         this.password = randomPassword(defaultPasswordLength);
         
         // Combine elements to generate email
         email = firstName.toLowerCase()+ "." + lastName.toLowerCase()+ "@" + dep + "." + CompanySuffix;
         
     }
    
     
     // Ask for the department
     private String setDepartment() {
    Scanner obj = new Scanner(System.in);
    
    while (true) { // Loop until valid input is received
        System.out.print("New Employee " + firstName + ", Department Codes\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for None\n Enter Department Code : ");

        try {
            int depCode = obj.nextInt();

            switch (depCode) {
                case 1:
                    department = "Sales"; dep = "sal";
                    break;
                case 2:
                    department = "Development"; dep = "dev";
                    break;
                case 3:
                    department = "Accounting"; dep = "acc";
                    break;
                case 0:
                    department = ""; dep = "";
                    break;
                default:
                    System.out.println("Invalid department code. Please enter 1, 2, 3, or 0.");
            }

            if (depCode < 4 && depCode >= 0 ) {  // Exit loop if valid department found
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number (1, 2, 3, or 0).");
            obj.nextLine(); // Clear the Scanner buffer to avoid infinite loop
        }
    }

    return department;
   
}
     
     
    // Generate a random password
     private String randomPassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
     

    // Set the mailbox capacity
     public void setMailboxCapacity (int Capacity) {
         this.mailboxCapacity = Capacity;
     }
     
    // Set the alternate email
    public void  setAlternateEmail (String altEmail) {
        this.alternateEmail = altEmail;
    }
    
    // Change the password
    public void changePassword (String password) {
        this.password = password;
    }
    
    /*public int getMailboxCapacity() {return mailboxCapacity; }
    public String getAlternateEmail() {return alternateEmail; }
    public String getPassword() {return password; }*/
    
    public String ShowInfo() {
        return "Name : " + firstName +" "+ lastName +
                "\nDepartment : "+ department +
                "\nCompany Email : "+ email +
                "\nPassword : " + password +
                "\nMailbox Capacity : "+ mailboxCapacity + "MB";
                }
}
