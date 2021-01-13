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
public class Main {

    public static void main(String[] args) {
        ArrayList<Expenses> le = new ArrayList<>();
        le.add(new Expenses(1, "11-Apr-2009", 100,"Tuitionfee"));  
        le.add(new Expenses(2, "20-Apr-2009", 250,"Rent house"));
        le.add(new Expenses(3, "30-Apr-2009", 300,"Food"));
        le.add(new Expenses(4, "30-Apr-2009", 300,"Food"));
        Expenses.displayExpense(le);
        int id = 0;
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = Validate.inputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    Expenses.addExpense(le);
                    break;
                case 2:
                    Expenses.displayExpense(le);
                    break;
                case 3:
                    Expenses.deleteExpense(le);
                    id--;
                    break;
                case 4:
                    return;
            }
        }
    }
}
