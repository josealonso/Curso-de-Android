package es.cice.clienteslv;

/**
 * Created by cice on 23/3/17.
 */

public class Customer {

    private String sex;
    private String name;
    private String phoneNumber;

    public Customer(String sex, String name, String phoneNumber) {
        this.sex = sex;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
