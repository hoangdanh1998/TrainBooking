package Model;

import java.util.Comparator;

public class Train implements Comparable<Train> {

    private String tCode, tName, DepartPlace;
    private int seat, booked;
    private double DepartTime;

    public Train() {
    }

    public void setTrain(Train newTrain) {
        this.tCode = newTrain.tCode;
        this.tName = newTrain.tName;
        this.DepartPlace = newTrain.DepartPlace;
        this.seat = newTrain.seat;
        this.booked = newTrain.booked;
        this.DepartTime = newTrain.DepartTime;
    }

    public Train(String tCode, String tName, String DepartPlace, int seat, int booked, double DepartTime) {
        this.tCode = tCode;
        this.tName = tName;
        this.DepartPlace = DepartPlace;
        this.seat = seat;
        this.booked = booked;
        this.DepartTime = DepartTime;
    }

    @Override
    public String toString() {
        return String.format("%10s|%15s|%6s|%6s|%15s|%15s|%15s", tCode, tName, seat, booked, DepartPlace, DepartTime, seat - booked);
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getDepartPlace() {
        return DepartPlace;
    }

    public void setDepartPlace(String DepartPlace) {
        this.DepartPlace = DepartPlace;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepartTime() {
        return DepartTime;
    }

    public void setDepartTime(double DepartTime) {
        this.DepartTime = DepartTime;
    }

    @Override
    public int compareTo(Train o) {
        return ((Train) this).tCode.compareTo(((Train) o).tCode);
    }

    public static Comparator comByCode = (Comparator) (Object o1, Object o2) -> (((Train) o1).tCode.compareTo(((Train) o2).tCode));
}
