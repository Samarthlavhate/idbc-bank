package data;

public class accountinfo {

    int accno;
    int amount;
    String accounttype;
    int intrest;
    int customerid;

    public accountinfo(int accno, int amount, String accounttype, int intrest, int customerid) {
        this.accno = accno;
        this.amount = amount;
        this.accounttype = accounttype;
        this.intrest = intrest;
        this.customerid = customerid;
    }

    @Override
    public String toString() {
        return "accountinfo{" +
                "accno=" + accno +
                ", amount=" + amount +
                ", accounttype='" + accounttype + '\'' +
                ", intrest=" + intrest +
                ", customerid=" + customerid +
                '}';
    }
}
