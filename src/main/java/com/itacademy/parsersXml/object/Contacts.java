package com.itacademy.parsersXml.object;

public class Contacts {

    private String address;
    private String tel;
    private String email;
    private String url;

    public Contacts(String address, String tel, String email, String url) {
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.url = url;
    }

    public Contacts() {

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t\taddress = '" + address + '\'' +
                "\n\t\ttel = '" + tel + '\'' +
                "\n\t\temail = '" + email + '\'' +
                "\n\t\turl = '" + url + '\'' +
                '}';
    }
}