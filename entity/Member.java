/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.entity;

/**
 *
 * @author Dhanushka
 */
public class Member {
    private Long id;
    private Long membership_number;
    private String first_name;
    private String last_name;
    private String gender;
    private String birthday;
    private String nic;
    private String home_telephone;
    private String mobile;
    private String home_address;
    private String office_address;
    private String emerg_name;
    private String emerg_relation;
    private String emerg_contact;
    private byte[] proImage;

    private Fianace finance;
    private Options options;
    private PackageDetails pack;
    
    public byte[] getProImage() {
        return proImage;
    }

    public void setProImage(byte[] proImage) {
        this.proImage = proImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembership_number() {
        return membership_number;
    }

    public void setMembership_number(Long membership_number) {
        this.membership_number = membership_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getHome_telephone() {
        return home_telephone;
    }

    public void setHome_telephone(String home_telephone) {
        this.home_telephone = home_telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getOffice_address() {
        return office_address;
    }

    public void setOffice_address(String office_address) {
        this.office_address = office_address;
    }

    public String getEmerg_name() {
        return emerg_name;
    }

    public void setEmerg_name(String emerg_name) {
        this.emerg_name = emerg_name;
    }

    
    public String getEmerg_contact() {
        return emerg_contact;
    }

    public void setEmerg_contact(String emerg_contact) {
        this.emerg_contact = emerg_contact;
    }

    public String getEmerg_relation() {
        return emerg_relation;
    }

    public void setEmerg_relation(String emerg_relation) {
        this.emerg_relation = emerg_relation;
    }

    public Fianace getFinance() {
        return finance;
    }

    public void setFinance(Fianace finance) {
        this.finance = finance;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public PackageDetails getPack() {
        return pack;
    }

    public void setPack(PackageDetails pack) {
        this.pack = pack;
    }
    
    
    
    
}
