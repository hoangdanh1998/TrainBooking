/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Model.Booking;
import Model.Customer;
import Model.Train;
import java.io.IOException;

/**
 *
 * @author hoang
 */
public class Execute {

    TrainList ListTrain = new TrainList();
    CustomerList ListCus = new CustomerList();
    BookingList ListBooking = new BookingList();
    Menu menu = new Menu();
    InputValid input = new InputValid();
    String fileTrain = "Train.txt", fileCus = "Customer.txt";

    
    public void Choice1Train() {
        boolean isKeepData = false;
        if (!ListTrain.isEmpty()) {
            isKeepData = input.Confirm("List have data do you want to keep and add more infor from file(Y/N):");
            if (!isKeepData) {
                ListTrain.removeAll();
            }
        }

        fileTrain = InputValid.inputString("Enter file name or Press ENTER to use default data file: ");
        fileTrain = (fileTrain.equals("")) ? "Train.txt" : fileTrain;
        ListTrain.readFromFile(fileTrain);
    }

    
    public void Choice2Train() {
        System.out.println("---Add train into list ---");
        String tCode = ListTrain.inputCode("Enter code of train: ");
        String tName = InputValid.inputString("Enter name of train: ");
        int Seat = input.inputInteger("Enter number of total seat: ");
        int Booked;
        do {
            Booked = input.inputInteger("Enter number seat booked: ");
            if (Booked > Seat) {
                System.out.println("Booked can't > seat");
            }
        } while (Booked > Seat);

        String Dplace = InputValid.inputString("Enter depart place: ");
        double time = input.inputDouble("Enter depart time: ");

        ListTrain.addFirst(new Train(tCode, tName, Dplace, Seat, Booked, time));
        menu.Success("Add");
    }


    public void Choice3Train() {
        ListTrain.printData();
    }

    public void Choice4Train() throws IOException {
        ListTrain.writeToFile();
    }

    public void Choice5Train() {
        String tCode = InputValid.inputString("Enter code to search: ");

        TrainList trainSearched = ListTrain.searchTrain(tCode);
        if (trainSearched != null) {
            trainSearched.printData();
        } else {
            System.out.println("NOT FOUND");
        }
    }

    public void Choice6Train() {
        String tCode = InputValid.inputString("Enter code to delete: ");

        int index = ListTrain.getIndexByCode(tCode);
        if (index != -1) {
            ListTrain.remove(index);
            index = ListBooking.getIndexByTCode(tCode);
            if (index != -1) {
                ListBooking.remove(index);
            }
            menu.Success("Delete");
        } else {
            System.out.println("Code not found");
        }

    }

    public void Choice7Train() {
        ListTrain.sortByCode();
        Choice3Train();
    }

    public void Choice8Train() {
        System.out.println("---Add train into list after postion ---");
        String tCode = ListTrain.inputCode("Enter code of train: ");
        String tName = InputValid.inputString("Enter name of train: ");
        int Seat = input.inputInteger("Enter number of total seat: ");
        int Booked;
        do {
            Booked = input.inputInteger("Enter number seat booked: ");
            if (Booked > Seat) {
                System.out.println("Booked can't > total seat");
            }
        } while (Booked > Seat);

        String Dplace = InputValid.inputString("Enter depart place: ");
        double time = input.inputDouble("Enter depart time: ");

        int position = input.inputInteger("Enter position");
        ListTrain.addPos(position + 1, new Train(tCode, tName, Dplace, Seat, Booked, time));
        menu.Success("Add position");

    }
    
    public void Chocie9Train() {
        String tCode = InputValid.inputString("Enter code to delete: ");

        int index = ListTrain.getIndexByCode(tCode);
        if (index == 0) {
            System.out.println("Have not train infor before code (" + tCode + " )");
        }
        if (index == -1) {
            System.out.println("Not found this code (" + tCode + ") in list");
        }
        if (index > 0) {
            ListTrain.remove(index - 1);
            menu.Success("Delete");
        }
    }
    
    public void Choice1Cus() {
        boolean isKeepData = false;
        if (!ListCus.isEmpty()) {
            isKeepData = input.Confirm("List have data do you want to keep and add more infor from file(Y/N):");
            if (!isKeepData) {
                ListTrain.removeAll();
            }
        }
        fileCus = InputValid.inputString("Enter file name you can press enter to use default data file: ");
        fileCus = (fileCus.equals("")) ? "Customer.txt" : fileCus;
        ListCus.LoadDataFromFile(fileCus);
    }

    public void Choice2Cus() {
        ListCus.inputAndAddEnd();
    }

    public void Choice3Cus() {
        ListCus.printData();
    }

    public void Choice4Cus() throws IOException {
        ListCus.saveToFile();
    }

    public void Choice5Cus() {
        String code = InputValid.inputString("Enter cus's code need find: ");
        CustomerList Cus = ListCus.searchByCode(code);
        if (Cus == null) {
            System.out.println("Code not found");
        } else {

            Cus.printData();
        }
    }

    public void Choice6Cus() {
        String code = InputValid.inputString("Enter code need delete: ");
        if (!ListCus.isExistCode(code)) {
            System.out.println("Code not found");
        } else {
            ListCus.remove(code);
            int index = ListBooking.getIndexByCCode(code);
            if (index != -1) {
                ListBooking.remove(index);
            }
            menu.Success("Delete");
        }
    }

    public void Choice1Booking() {
        String tCode, cCode;
        boolean ReEnter = false;
        int book;
        if (ListTrain.isEmpty()) {
            ListTrain.readFromFile(fileTrain);
        }
        if (ListCus.isEmpty()) {
            ListCus.LoadDataFromFile(fileCus);
        }
        System.out.println("----Input booking data----");
        System.out.println("...Train information...");
        ListTrain.printData();
        do {
            ReEnter = false;
            tCode = InputValid.inputString("*Enter train code: ");
            if (!ListTrain.isExistCode(tCode)) {
                System.out.println("-This code not found in Train List.");
                boolean confirm = InputValid.Confirm(" +Do you want to book another train(Y/N) ");
                if (confirm) {
                    ReEnter = true;
                } else {
                    return;
                }

            } else if (ListTrain.findTrain(tCode).getBooked() == ListTrain.findTrain(tCode).getSeat()) {
                boolean confirm = InputValid.Confirm("-This train is  exhausted."
                        + "\n +Do you want to book another train(Y/N) ");
                if (confirm) {
                    ReEnter = true;
                } else {
                    return;
                }
            }
        } while (ReEnter);
        System.out.println("...Customer information...");
        ListCus.printData();
        do {
            ReEnter = false;
            cCode = InputValid.inputString("*Enter customer code: ");
            if (!ListCus.isExistCode(cCode)) {
                System.out.println("-This code not found in Customer list.");
                boolean confirm = InputValid.Confirm(" +Do you want to book by another CCode(Y/N)");
                if (confirm) {
                    ReEnter = true;
                } else {
                    return;
                }
            } else if (ListBooking.isExistTCode(tCode) && ListBooking.isExistCCode(cCode)) {
                boolean confirm = InputValid.Confirm("This customer already booked on this train and you want to book for another one(Y/N)");
                if (confirm) {
                    ReEnter = true;
                } else {
                    return;
                }
            }
        } while (ReEnter);

        Train train = ListTrain.findTrain(tCode); // create train to check valid input book
        int ready = train.getSeat() - train.getBooked();
        System.out.println("-This train has " + ready + " seats available for you");
        do {
            ReEnter = false;

            book = input.inputInteger("*Enter the number of seats you want to book: ");

            if (ready < book) {
                System.out.println("-Sorry no longer enough seats for you");
                boolean confirm = InputValid.Confirm(" +Do you want to re-oder (Y/N): ");
                if (confirm) {
                    ReEnter = true;
                } else {
                    return;
                }
            }
        } while (ReEnter);
        for (int i = 0; i < ListTrain.size(); i++) { // Fix infor booked in Train List
            if (ListTrain.get(i).gettCode().equalsIgnoreCase(train.gettCode())) {
                ListTrain.get(i).setBooked(train.getBooked() + book);
            }
        }
        ListBooking.addLast(new Booking(tCode, cCode, book));
        menu.Success("Add to booking list");

    }

    public void Choice2Booking() {

        System.out.println(menu.headerBooking());
        ListBooking.printAll();
    }

    public void Choice3Booking() {
        menu.menuSort();
        int choice = input.inputInteger("Enter your choice: ");
        switch (choice) {
            case 1:
//                ListBooking.sort();
                ListBooking.sort(Booking.CompareByTCode);
                ListBooking.printAll();
                break;
            case 2:
                ListBooking.sort(Booking.CompareByCCode);
                ListBooking.printAll();
                break;
            case 3:
                return;
        }

    }

    public void FakeMain() throws IOException {
        int choice;
        do {
            menu.menuIndex();
            choice = input.inputInteger("Enter your choice: ");
            switch (choice) {
                case 1:
                    int choiceT;
                    do {
                        if (ListTrain.isEmpty()) {
                            menu.menuTrainDis();
                        } else {
                            menu.menuTrain();
                        }
                        choiceT = input.inputInteger("Enter your choice: ");
                        switch (choiceT) {
                            case 1:
                                Choice1Train();
                                break;
                            case 2:
                                Choice2Train();
                                break;
                            case 3:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice3Train();
                                }
                                break;
                            case 4:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice4Train();
                                }
                                break;
                            case 5:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice5Train();
                                }
                                break;
                            case 6:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice6Train();
                                }
                                break;
                            case 7:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice7Train();
                                }
                                break;
                            case 8:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice8Train();
                                }
                                break;
                            case 9:
                                if (ListTrain.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Chocie9Train();
                                }
                                break;
                            case 10:
                                System.out.println("Thank for using");

                        }
                    } while (choiceT != 10);
                    break;
                case 2:
                    int choiceC;
                    do {
                        if (ListCus.isEmpty()) {
                            menu.menuCustomerDis();
                        } else {
                            menu.menuCustomer();
                        }
                        choiceC = input.inputInteger("Enter your choice: ");
                        switch (choiceC) {
                            case 1:

                                Choice1Cus();
                                break;
                            case 2:
                                Choice2Cus();
                                break;
                            case 3:
                                if (ListCus.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice3Cus();
                                }
                                break;
                            case 4:
                                if (ListCus.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice4Cus();
                                }

                                break;
                            case 5:
                                if (ListCus.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice5Cus();
                                }
                                break;
                            case 6:
                                if (ListCus.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice6Cus();
                                }
                                break;
                            case 7:
                                System.out.println("Thank for using");
                                break;
                        }
                    } while (choiceC != 7);
                    break;
                case 3:
                    int choiceB;
                    do {
                        if (ListCus.isEmpty()) {
                            menu.menuBookingDis();
                        } else {
                            menu.menuBooking();
                        }
                        choiceB = input.inputInteger("Enter your choice: ");
                        switch (choiceB) {
                            case 1:
                                Choice1Booking();
                                break;
                            case 2:
                                if (ListBooking.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice2Booking();
                                }
                                break;
                            case 3:
                                if (ListBooking.isEmpty()) {
                                    System.out.println("This function is disable");
                                } else {
                                    Choice3Booking();
                                }
                                break;
                            case 4:
                                System.out.println("Thank for using");
                                break;
                        }
                    } while (choiceB != 4);
                    break;
            }
        } while (choice != 4);
    }

}
