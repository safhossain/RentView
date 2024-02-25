package com.ryerson.rentview.Helper;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MemberInfo {
    private int memberID;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String dateOfBirthString;
    private String memberType;
    private LocalDate dateOfBirth;
    private int age;

    public MemberInfo(int memberId, String emailAddress, String firstName, String lastName, String dateOfBirthString, String memberType) {
        this.memberID = memberId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirthString = dateOfBirthString;
        this.dateOfBirth = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ISO_LOCAL_DATE);
        this.age = getAge();
        this.memberType = memberType;
    }

    // Getters
    public int getMemberID() {
        return this.memberID;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public String getDateOfBirth() {
        return this.dateOfBirthString;
    }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
    
    public String getMemberType(){
        return this.memberType;
    }
    
    @Override
    public String toString() {
        return "MemberInfo{" +
                "memberId=" + memberID +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirthString + '\'' +
                ", age=" + age +
                ", memberType=" + memberType +
                '}';
    }

    // Setters
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirthString = dateOfBirth;
    }
}