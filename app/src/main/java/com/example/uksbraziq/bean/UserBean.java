package com.example.uksbraziq.bean;


import java.util.Date;
import java.util.UUID;

public class UserBean {
    private int id;
    private String username;
    private String password;
    private String status;
    private String deviceToken;
    private int runningNoPickup;
    private int runningNoAddress;
    private int runningNoCreditCard;
    private String createdBy;
    private Date createdDt;
    private String modifiedBy;
    private Date modifiedDt;
    private String email;
    private String fullName;
    private String nationality;
    private String originCountry;
    private String appFirstName;
    private String appLastName;
    private String appFullname;
    private String appNumber;
    private String appDocNumber;

    public UserBean() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public int getRunningNoPickup() {
        return runningNoPickup;
    }

    public void setRunningNoPickup(int runningNoPickup) {
        this.runningNoPickup = runningNoPickup;
    }

    public int getRunningNoAddress() {
        return runningNoAddress;
    }

    public void setRunningNoAddress(int runningNoAddress) {
        this.runningNoAddress = runningNoAddress;
    }

    public int getRunningNoCreditCard() {
        return runningNoCreditCard;
    }

    public void setRunningNoCreditCard(int runningNoCreditCard) {
        this.runningNoCreditCard = runningNoCreditCard;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public void createSessionID() {
        UUID id = UUID.randomUUID();
        this.status = id.toString();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status
                + ", deviceToken=" + deviceToken + ", runningNoPickup=" + runningNoPickup + ", runningNoAddress="
                + runningNoAddress + ", runningNoCreditCard=" + runningNoCreditCard + ", createdBy=" + createdBy
                + ", createdDt=" + createdDt + ", modifiedBy=" + modifiedBy + ", modifiedDt=" + modifiedDt + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }


    public String getAppFullname() {
        return appFullname;
    }

    public void setAppFullname(String appFullname) {
        this.appFullname = appFullname;
    }

    public String getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(String appNumber) {
        this.appNumber = appNumber;
    }

    public String getAppDocNumber() {
        return appDocNumber;
    }

    public void setAppDocNumber(String appDocNumber) {
        this.appDocNumber = appDocNumber;
    }

    public String getAppFirstName() {
        return appFirstName;
    }

    public void setAppFirstName(String appFirstName) {
        this.appFirstName = appFirstName;
    }

    public String getAppLastName() {
        return appLastName;
    }

    public void setAppLastName(String appLastName) {
        this.appLastName = appLastName;
    }
}
