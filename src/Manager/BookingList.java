package Manager;

import Model.Booking;
import SinglyLinkedList.IntSLList;

/**
 *
 * @author hoang
 */
public class BookingList extends IntSLList<Booking> {

    InputValid input = new InputValid();
    Menu menu = new Menu();

    public boolean isExistTCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getTCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistCCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByTCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getTCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }
    public int getIndexByCCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }
    
    public void print() {
        menu.headerBooking();
        this.printAll();
    }

    public void sortByTCode() {

    }
}
