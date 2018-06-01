package Manager;

import Model.Train;
import SinglyLinkedList.IntSLList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrainList extends IntSLList<Train> {
    Menu menu = new Menu();

    
    public boolean isExistCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).gettCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
    
    public String inputCode(String notify) {
        String myCode;
        do {
            myCode = InputValid.inputString(notify);
            if (this.isExistCode(myCode)) {
                System.out.println("This code existed. ");
            }
        } while (this.isExistCode(myCode));
        return myCode;
    }
    
    public void printData() {
        System.out.println(menu.headerTrain());
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }
    public void readFromFile(String fileName) {
        boolean isReaded = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String detail;
            while ((detail = br.readLine()) != null) {
                isReaded = true;
                String arr[] = detail.split("[|]");
                String tCode = arr[0].trim();
                String tName = arr[1].trim();
                int seat = Integer.parseInt(arr[2].trim());
                int booked = Integer.parseInt(arr[3].trim());
                double DepartTime = Double.parseDouble(arr[4].trim());
                String DepartPlace = arr[5].trim();
                if (!this.isExistCode(tCode)) {
                    Train train = new Train(tCode, tName, DepartPlace, seat, booked, DepartTime);
                    this.addLast(train);
                }
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Can't read your file.");
        }
        if (isReaded) {
            menu.Success("Read file train");
        }

    }
    
    public void writeToFile() throws IOException {
        boolean isWrited = false;
        String fileName = InputValid.inputString("Enter file name you can press enter to use default data file: ");
        fileName = (fileName.equals("")) ? "Train.txt" : fileName;
        try (
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {

            for (int i = 0; i < this.size(); i++) {

                writer.write(this.get(i).gettCode()
                        + "|" + this.get(i).gettName()
                        + "|" + this.get(i).getSeat()
                        + "|" + this.get(i).getBooked()
                        + "|" + this.get(i).getDepartTime()
                        + "|" + this.get(i).getDepartPlace());
                isWrited = true;
                writer.newLine();
            }
            writer.close();
        }
        if (isWrited) {
            menu.Success("Write to file");
        }

    }
    
    public TrainList searchTrain(String tCode) {
        TrainList list = new TrainList();
        tCode = tCode.toLowerCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).gettCode().toLowerCase().contains(tCode)) {
                list.addLast(this.get(i));
            }
        }
        return list;
    }
    
    public Train findTrain(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).gettCode().equalsIgnoreCase(code)) {
                return this.get(i);
            }
        }
        return null;
    }
    
    public int getIndexByCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).gettCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }        
    
    
    public void sortByCode() {
        this.sort(Train.comByCode);
    }
}
