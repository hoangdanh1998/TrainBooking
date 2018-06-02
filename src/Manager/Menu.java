/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import SinglyLinkedList.IntSLList;

/**
 *
 * @author hoang
 */
public class Menu extends IntSLList<String> {
    
    public  String headerTrain() {
        return String.format("%10s|%15s|%6s|%6s|%15s|%15s|%15s", "Train Code", "Train Name", "Seat", "Booked", "Depart Place", "Depart Time", "Available Seat");
    }
    
    public  void Success(String action) {
        System.out.println(action + " successfully!");
    }
    
    public  String headerBooking() {
        return String.format("%10s|%15s|%10s", "Train Code", "Customer code", "Seat");
    }
    
    public  String headerCustomer() {
        return String.format("%10s|%15s|%15s", "Cus Code", "Cus Name", "Phone");
    }

    public void menuIndex() {
        this.addLast("############ Train booking system ############");
        this.addLast("1.      Train list ");
        this.addLast("2.      Customer list ");
        this.addLast("3.      Booking list ");
        this.addLast("4.      Exit");
        this.printAll();
        this.removeAll();
    }

    public void menuTrain() {
        this.addLast("========== Train list manager ==========");
        this.addLast("1.      Load data from file");
        this.addLast("2.      Input & add to the head");
        this.addLast("3.      Display data");
        this.addLast("4.      Save train list to file");
        this.addLast("5.      Search by tcode");
        this.addLast("6.      Delete by tcode");
        this.addLast("7.      Sort by tcode");
        this.addLast("8.      Add after position  k");
        this.addLast("9.      Delete the node before the node having tcode = xCode");
        this.addLast("10.     Exit");
        this.printAll();
        this.removeAll();        
    }
    public void menuTrainDis() {
        this.addLast("========== Train list manager ==========");
        this.addLast("1.      Load data from file");
        this.addLast("2.      Input & add to the head");
        this.addLast("3.      Display data(Disable)");
        this.addLast("4.      Save train list to file(Disable)");
        this.addLast("5.      Search by tcode(Disable)");
        this.addLast("6.      Delete by tcode(Disable)");
        this.addLast("7.      Sort by tcode(Disable)");
        this.addLast("8.      Add after position k(Disable)");
        this.addLast("9.      Delete the node before the node having tcode = xCode(Disable)");
        this.addLast("10.     Exit");
        this.printAll();
        this.removeAll();        
    }
    
    public void menuCustomerDis() {
        this.addLast("========== Customer list manager ==========");
        this.addLast("1.      Load data from file");
        this.addLast("2.      Input & add to the end");
        this.addLast("3.      Display data(Disable)");
        this.addLast("4.      Save customer list to file(Disable)");
        this.addLast("5.      Search by ccode(Disable)");
        this.addLast("6.      Delete by ccode(Disable)");
        this.addLast("7.      Exit");
        this.printAll();
        this.removeAll();
    }
    public void menuCustomer() {
        this.addLast("========== Customer list manager ==========");
        this.addLast("1.      Load data from file");
        this.addLast("2.      Input & add to the end");
        this.addLast("3.      Display data");
        this.addLast("4.      Save customer list to file");
        this.addLast("5.      Search by ccode");
        this.addLast("6.      Delete by ccode");
        this.addLast("7.      Exit");
        this.printAll();
        this.removeAll();
    }
    
    public void menuBooking() {
        this.addLast("========== Booking list manager ==========");
        this.addLast("1.      Input data");
        this.addLast("2.      Display data width available seats");
        this.addLast("3.      Sort  by tcode + ccode");
        this.addLast("4.      Exit");
        this.printAll();
        this.removeAll();
    }
    public void menuBookingDis() {
        this.addLast("========== Booking list manager ==========");
        this.addLast("1.      Input data");
        this.addLast("2.      Display data width available seats(Disable)");
        this.addLast("3.      Sort by tcode + ccode (Disable)");
        this.addLast("4.      Exit");
        this.printAll();
        this.removeAll();
    }
    
    public void menuSort() {
        this.addLast("---Select type to sort---");
        this.addLast("1.    Sort by tCode.");
        this.addLast("2.    Sort by CCode.");
        this.addLast("3.    Exit");
        this.printAll();
        this.removeAll();
    }
    
    
}
