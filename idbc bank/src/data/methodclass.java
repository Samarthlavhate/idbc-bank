package data;

import java.sql.*;

public class methodclass {


        Connection con;

        {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idbc_bank", "root", "samarthlavhate00@gmail.com");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void insertCustomer( customertable customertablee)
        {
            try{
                PreparedStatement p1 =  con.prepareStatement("insert into customertable values (?, ?, ?, ?,?,?,?,?)");

                p1.setInt(1,customertablee.cutomerid);
                p1.setString(2, customertablee.firstname);
                p1.setString(3, customertablee.lastname);
                p1.setInt(4,customertablee.age);
                p1.setString(5,customertablee.gender);
                p1.setString(6,customertablee.phno);
                p1.setString(7,customertablee.city);
                p1.setString(8,customertablee.street);

                int rowsAffected = p1.executeUpdate();

                if(rowsAffected > 0)
                    System.out.println("Customer Details added successfully.");
                else
                    System.out.println("Failed To Add Customer Details");

            } catch (SQLException e) {
                System.out.println("SQLException " + e);
                e.printStackTrace();
            }
        }


        public void createAccount(accountinfo accounts,transaction trans) {

            try {

                PreparedStatement p2=con.prepareStatement("insert into accountinfo values(?,?,?,?,?)");

              p2.setInt(1,accounts.accno);
                p2.setInt(2,accounts.customerid);
              p2.setInt(3,accounts.amount);
              p2.setString(4,accounts.accounttype);
              p2.setInt(5,accounts.intrest);



               p2.executeUpdate();

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            PreparedStatement p7 = null;
            try {
                p7 = con.prepareStatement("insert into transactions values(?,?,?,?)");
                p7.setInt(1,trans.transactionid);
                p7.setString(2,trans.transactiontype);
                p7.setInt(3,trans.balance);
                p7.setInt(4,trans.accno);

                p7.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


    public void deposit(transaction trans, int accno)
    {
        try{
            PreparedStatement pd = con.prepareStatement("update accountinfo join transactions on accountinfo.accno=transactions.accno set accountinfo.amount =(accountinfo.amount)+(transactions.balance) where accountinfo.accno=?");
            PreparedStatement p3 = con.prepareStatement("insert into transactions values (?,?,?,?)");


            pd.setInt(1,trans.accno);

            p3.setInt(1,trans.transactionid);
            p3.setString(2,trans.transactiontype);
            p3.setInt(3,trans.balance);
            p3.setInt(4,trans.accno);

            pd.setInt(1,trans.accno);
       int rowsAffected= p3.executeUpdate();
            pd.executeUpdate();

            if(rowsAffected > 0) {
                System.out.println("Deposit successful.");

            }
            else
                System.out.println("Not able to deposit.");


        }
        catch (SQLException e)
        {
            System.out.println("SQLException " + e);

        }


    }
    public void withdraw(transaction trans, int accno){

        try {
            PreparedStatement pw = con.prepareStatement("update accountinfo join transactions on accountinfo.accno=transactions.accno set accountinfo.amount =(accountinfo.amount)-(transactions.balance) where accountinfo.accno=?");
            PreparedStatement p3 = con.prepareStatement("insert into transactions values (?,?,?,?)");
            PreparedStatement p4= con.prepareStatement("select amount from accountinfo where accno=?");
            int amount22=0;
            p4.setInt(1,accno);

            ResultSet tt= p4.executeQuery();
            while(tt.next()){
                amount22=tt.getInt(1);
            }
            if(amount22>trans.balance){


            p3.setInt(1,trans.transactionid);
            p3.setString(2,trans.transactiontype);
            p3.setInt(3,trans.balance);
            p3.setInt(4,trans.accno);
         pw.setInt(1,accno);
            pw.executeUpdate();
            p3.executeUpdate();
            }else{
                System.out.println("not possible");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void displaytrans(int accno){
        try {
            PreparedStatement PT=con.prepareStatement("select*from transactions where accno=?" );


            PT.setInt(1,accno);
            PT.executeQuery();
            ResultSet TTC= PT.executeQuery();
            while(TTC.next()){
                System.out.println(TTC.getInt(1)+"\t"+TTC.getString(2)+"\t"+ TTC.getInt(3)+"\t"+ TTC.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }


