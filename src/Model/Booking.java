package Model;

import java.util.Comparator;

public class Booking implements Comparable<Booking>{
    private String TCode, CCode;
    private int seat;

    public Booking() {
    }

    public Booking(String TCode, String CCode, int seat) {
        this.TCode = TCode;
        this.CCode = CCode;
        this.seat = seat;
    }

    public String getTCode() {
        return TCode;
    }

    public void setTCode(String TCode) {
        this.TCode = TCode;
    }

    public String getCCode() {
        return CCode;
    }

    public void setCCode(String CCode) {
        this.CCode = CCode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return String.format("%10s|%15s|%10s", TCode, CCode, seat);
    }

    @Override
    public int compareTo(Booking o) {
        return this.TCode.compareTo(o.TCode);
    }
    public static Comparator CompareByTCode = (Comparator) (Object o1, Object o2) -> ((Booking)o1).TCode.compareTo(((Booking)o2).TCode);
    public static Comparator CompareByCCode = (Comparator) (Object o1, Object o2) -> ((Booking)o1).CCode.compareTo(((Booking)o2).CCode);
        
}
