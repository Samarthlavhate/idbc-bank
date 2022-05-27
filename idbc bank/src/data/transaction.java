package data;

public class transaction {
int transactionid;
String transactiontype;
int balance;
int accno;


    public transaction(int transactionid, String transactiontype, int balance, int accno) {
        this.transactionid = transactionid;
        this.transactiontype = transactiontype;
        this.balance = balance;
        this.accno = accno;
    }


    @Override
    public String toString() {
        return "transaction{" +
                "transactionid=" + transactionid +
                ", transactiontype='" + transactiontype + '\'' +
                ", balance=" + balance +
                ", accno=" + accno +
                '}';
    }
}
