package Manager;

import Model.Customer;
import SinglyLinkedList.IntSLList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CustomerList extends IntSLList<Customer> {

    Menu menu = new Menu();

    public boolean isExistCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    
    public void LoadDataFromFile(String fileName) {
        boolean isLoaded = false;
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String detail;
            while ((detail = br.readLine()) != null) {
                isLoaded = true;
                String arr[] = detail.split("[|]");
                String cCode = arr[0].trim();
                String cName = arr[1].trim();
                String phone = arr[2].trim();
                if (!this.isExistCode(cCode)) {
                    this.addLast(new Customer(cCode, cName, phone));
                }
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Can't read your file.");
        }
        if (isLoaded) {
            menu.Success("Read file customer");
        }

    }

    
    public String inputCode(String notify) {
        String cCode;
        do {
            cCode = InputValid.inputString(notify);
        } while (isExistCode(cCode));
        return cCode;
    }

    public void inputAndAddEnd() {
        String cCode = inputCode("Enter customer code: ");
        String name = InputValid.inputString("Enter customer name: ");
        String phone = InputValid.inputPhone("Enter phone number: ");

        this.addLast(new Customer(cCode, name, phone));
        menu.Success("Add customer");
    }

    public void printData() {
        System.out.println(menu.headerCustomer());;
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

    public void saveToFile() throws IOException {
        String fileName = InputValid.inputString("Enter file name you can press enter to use default data file: ");
        fileName = (fileName.equals("")) ? "Customer.txt" : fileName;
        try (
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {

            for (int i = 0; i < 10; i++) {
                writer.write(this.get(i).getCCode()
                        + "|" + this.get(i).getCusName()
                        + "|" + this.get(i).getPhone());

                writer.newLine();
            }
            writer.close();
        }
    }

    public CustomerList searchByCode(String code) {
        CustomerList list = new CustomerList();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCCode().toLowerCase().contains(code.toLowerCase())) {
                list.addLast(this.get(i));
            }
        }
        return list;
    }
    
    public Customer searchCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCCode().toLowerCase().contains(code.toLowerCase())) {
                return this.get(i);
            }
        }
        return null;
    }

    public Customer remove(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCCode().equals(code)) {
                return this.remove(i);
            }
        }
        return null;
    }

}
