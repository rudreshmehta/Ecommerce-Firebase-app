package com.example.sweven;

public class AddressesModel {

    private String fullName;
    private String address;
    private String pincode;

    public AddressesModel(String fullName, String address, String pincode) {
        this.fullName = fullName;
        this.address = address;
        this.pincode = pincode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
