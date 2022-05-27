package data;

public class customertable {

    int cutomerid;
    String firstname;
    String lastname;
    int age;
    String gender;
    String phno;
    String city;
    String street;

    public customertable(int cutomerid, String firstname, String lastname, int age, String gender, String phno, String city, String street) {
        this.cutomerid = cutomerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.phno = phno;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "customertable{" +
                "cutomerid=" + cutomerid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phno='" + phno + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}