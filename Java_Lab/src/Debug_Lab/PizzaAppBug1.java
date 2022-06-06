package Java_Lab.src.Debug_Lab;

import java.util.Scanner;
/*
    - Bug is in Line 43 -> break is replaced with continue;
    - BUG Description -> When user enters true credentials and logs in -> Programme continues to ask enter email again and again...
    - Delete this comment block before sharing with student...
 */
public class PizzaAppBug1 {

    public static void main(String[] args) {

        System.out.println("Welcome to Best Pizza in Town");
        System.out.println("Please log in before placing the order");
        login();
    }

    public static String login(){

        String email = "mike@gmail.com";
        String password = "password";

        Scanner scanner = new Scanner(System.in);

        for (int i = 3; i > 0; ) {

            //Enter your email
            System.out.println("Enter your email:");
            String givenEmail = scanner.next();

            if (!isInputValid(givenEmail)) {
                System.out.println("Invalid Email. Please try again...");
                continue;
            }

            //Enter your password
            System.out.println("Please enter your password:");
            String givenPassword = scanner.next();

            //Check if log in successful
            if ((email.equals(givenEmail) && password.equals(givenPassword))) {
                System.out.println("Successfully logged in with email");
                continue;
                //break;

            } else { //invalid checking

                if (i != 1) {  //ask again

                    System.out.println("Invalid credentials !! left " + (i - 1) + " chances to try");
                    i--;

                } else {
                    System.out.println("Your account is locked - try again tomorrow");
                    System.exit(0); //close the execution of jvm
                }
            }
        }
        return email;

    }

    public static boolean isInputValid(String givenEmail) {

        //Check if the email address is valid:  //if @ . available, and @ is before . mikegmail.com
        int firstSignOfIndex = givenEmail.indexOf('@');  // -1
        int secondSignOfIndex = givenEmail.indexOf('.');

        boolean checkEmail = secondSignOfIndex < firstSignOfIndex || firstSignOfIndex < 0 || secondSignOfIndex < 0; //invalid

        if(checkEmail){
            return false;
        }

        return isEmailDomainValid(givenEmail);
    }

    public static boolean isEmailDomainValid(String givenEmail) {


        //Check if domain is valid  //gmail and hotmail domain - > mike@gmail.com
        String domain = givenEmail.substring(givenEmail.indexOf('@') + 1, givenEmail.indexOf('.'));        //gmail

        return domain.equalsIgnoreCase("gmail") || domain.equalsIgnoreCase("hotmail");

    }








}
