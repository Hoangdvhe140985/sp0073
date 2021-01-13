/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp0073;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Expenses {

    private int id;
    private String date;
    private double amount;
    private String content;

    public Expenses() {
    }

    public Expenses(int id, String date, double amount, String content) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

        // add expense 
    static void addExpense(ArrayList<Expenses> le) {
        System.out.print("Enter Date: ");
        // input date of fomat
        String date = Validate.inputDate();
        System.out.print("Enter Amount: ");
        //input money allow fomat
        double amount = Validate.checkInputDouble();
        System.out.print("Enter Content: ");
        //input content is string not number
        String content = Validate.checkInputString();
        
        int length = le.size();
        //
        int id = le.get(length - 1).getId() + 1;
        //add array list
        le.add(new Expenses(id, date, amount, content));
    }

    static void displayExpense(ArrayList<Expenses> le) {
        // if array list = 0 list empty
        if (le.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        //loop from 0 - size array list -1
        for (int i = 0; i < le.size(); i++) {         
            //print detailed expense
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId(), le.get(i).getDate(),
                    le.get(i).getAmount(), le.get(i).getContent());
            // total = total + value Amount after each loop
            total += le.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    static void deleteExpense(ArrayList<Expenses> le) {
        System.out.print("Enter id: ");
        //input id is interger number
        int id = Validate.inputIntLimit(0, Integer.MAX_VALUE);
        //check id input 
        int checkIdExist = Validate.checkIdExist(le, id);
        //if id input != -1 remove id
        if (checkIdExist != -1) {
            le.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            //start from id remove - 1 to end size list                                                                                                                                                                            
            for (int i = id - 1; i < le.size(); i++) {               
                le.get(i).setId(le.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

}
