/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.entity;

import java.sql.Date;

/**
 *
 * @author Dhanushka
 */
public class Attendant {
    
    private Long id;
    private Long membershipNumber;
    private Date date;
    private boolean status;
    private PackageDetails packageDetails;
    private Fianace finance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(Long membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PackageDetails getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(PackageDetails packageDetails) {
        this.packageDetails = packageDetails;
    }

    public Fianace getFinance() {
        return finance;
    }

    public void setFinance(Fianace finance) {
        this.finance = finance;
    }
    
    
    
    
}
