
package Model;

public class Customer implements Comparable<Customer>{
    private String CCode, CusName, Phone;

    public Customer(String CCode, String CusName, String Phone) {
        this.CCode = CCode;
        this.CusName = CusName;
        this.Phone = Phone;
    }

    public Customer() {
    }

    public String getCCode() {
        return CCode;
    }

    public void setCCode(String CCode) {
        this.CCode = CCode;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return String.format("%10s|%15s|%15s", CCode, CusName, Phone);
    }

    @Override
    public int compareTo(Customer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
