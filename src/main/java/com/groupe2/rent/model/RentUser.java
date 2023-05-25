package com.groupe2.rent.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RentUser {
    @Id
    private int id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String licenceNumber;

    public RentUser(int id, String lastName, String firstName, Date birthDate, String licenceNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.licenceNumber = licenceNumber;
    }

    public RentUser() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", licenceNumber=" + licenceNumber +
                '}';
    }
}





