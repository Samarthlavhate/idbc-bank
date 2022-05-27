package data;

import java.util.Random;
import java.util.Scanner;

public class bankmain {

        public static void main(String[] args) {

            methodclass bankingOperations = new methodclass();

            Scanner scanner = new Scanner(System.in);
            Random RC=new Random();

            System.out.println("Enter 1 To Create a Bank Account");
            System.out.println("enter 2 for transaction");


            int choice = scanner.nextInt();


            switch (choice)
            {
                case 1:
                    System.out.println("Enter your Id(CustomerId) : ");
                    int cutomerId = scanner.nextInt();

                    System.out.println("Enter your Full Name : ");
                    String firstname = scanner.next();

                    System.out.println("Enter your lastname : ");
                    String lastname = scanner.next();

                    System.out.println("Enter your age: ");
                    int age = scanner.nextInt();

                    System.out.println("gender");
                    String gender=scanner.next();

                    System.out.println("phonenumber");
                    String phno= scanner.next();

                    System.out.println("city");
                    String city =scanner.next();


                    System.out.println("street");
                    String street =scanner.next();

                    customertable customer = new customertable(cutomerId, firstname, lastname, age,gender,phno,city,street);
                    bankingOperations.insertCustomer(customer);


                    System.out.println("account no");
                    int accno= scanner.nextInt();

                    System.out.println("Enter amount");
                    int amount = scanner.nextInt();
                    System.out.println("account type ");
                    String accounttype = scanner.next();

                    System.out.println("intrest");
                    int intrest = scanner.nextInt();



                    accountinfo account23 = new accountinfo(accno,amount,accounttype,intrest,cutomerId);
                    System.out.println("transactionid");
                    int transactionid= RC.nextInt();

                    System.out.println("transacction type");
                    String transactiontype = scanner.next();
                    int balance =amount;



                    transaction trans=new transaction(transactionid,transactiontype,balance,accno);

                    bankingOperations.createAccount(account23, trans);

            break;
                case 2:
                    String choice2= scanner.next();
                    if(choice2.equalsIgnoreCase("deposite")){
                        System.out.println("enter account number");
                        int accountnumber=scanner.nextInt();
                        System.out.println("transaction id");
                        int transid= RC.nextInt();

                        System.out.println("transacction type");
                        String transaction = scanner.next();
                        System.out.println("enter amount");
                        int amount1= scanner.nextInt();


                        transaction trans2=new transaction(transid,transaction,amount1,accountnumber);
                        bankingOperations.deposit(trans2,accountnumber);
                    }
                    else if (choice2.equalsIgnoreCase("withdraw")){
                        System.out.println("enter aaccountnumber");
                        int accountnumber=scanner.nextInt();
                        System.out.println("transaction id ");
                        int transid= RC.nextInt();

                        System.out.println("transacction type");
                        String transaction = scanner.next();
                        System.out.println("enter amount");
                        int amount1= scanner.nextInt();


                        transaction trans2=new transaction(transid,transaction,amount1,accountnumber);
                        bankingOperations.withdraw(trans2,accountnumber);
                    }
break;




        }
            System.out.println("do you wANT to see transaction details");

            String choice3= scanner.next();
            if(choice3.equalsIgnoreCase("yes")){
            System.out.println("enter your account number");
            int acc= scanner.nextInt();
            if(choice3.equalsIgnoreCase("yes")){
                bankingOperations.displaytrans(acc);
            }}
    }
}
