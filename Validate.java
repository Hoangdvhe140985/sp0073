/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp0073;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);
    //allows entering strings from a to z with many characters
    private static final String STRING = "[A-Za-z]*";

//input interger limit
    static int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                // if n < min and > max throw exception
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }
//input date

    public static String inputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                //date format according to pattern
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                //convert string to fomat date
                Date date = format.parse(result);
                Calendar today = Calendar.getInstance();
                //result equals with format date throw exception
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                }else {
                    System.out.println("Date does not exist ");
                }
            } catch (Exception ex) {
                System.out.println("Please reenteer date (dd-MMM-yyyy)");
            }
        }
    }
    
//check input is double
    static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                // result < 0 throw exception
                if (result < 0) {
                    throw new NumberFormatException();
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }

        }
    }

    //check input is string
    static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            //checks whether the input value matches a given regular expression or not
            if (result.matches(STRING)) {
                return result;
            } else {
                System.err.println("Re-input");
            }

        }
    }

    //check id remove 
    static int checkIdExist(ArrayList<Expenses> le, int id) {
        //loop from 1 to size list 
        for (int i = 0; i < le.size(); i++) {
            // if id input == id in list
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
