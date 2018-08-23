package org.java2.lesson3;

public class Contact {
    private static String surname;
    private static String phone;
    private static String email;

    Contact(String surname, String phone, String email){
        setSurname(surname);
        setEmail(email);
        setPhone(phone);
    }
    public static void getInfo(){
        System.out.println(getSurname() + " " + getPhone() + " " + getEmail());
    }

    public static String getPhone() {
        return phone;
    }
    public static void setPhone(String phone) {
        Contact.phone = phone;
    }
    public static String getEmail() {
        return email;
    }
    public static void setEmail(String email) {
        Contact.email = email;
    }
    public static String getSurname() {
        return surname;
    }
    public static void setSurname(String surname) {
        Contact.surname = surname;
    }
}
