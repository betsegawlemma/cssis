package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;


@Getter
@Setter
@Embeddable
public class Address {

    private String phone;
    private String email;
    private String subCity;
    private String houseNumber;
    private String street;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (phone != null ? !phone.equals(address.phone) : address.phone != null) return false;
        if (email != null ? !email.equals(address.email) : address.email != null) return false;
        if (subCity != null ? !subCity.equals(address.subCity) : address.subCity != null) return false;
        if (houseNumber != null ? !houseNumber.equals(address.houseNumber) : address.houseNumber != null) return false;
        return street != null ? street.equals(address.street) : address.street == null;
    }

    @Override
    public int hashCode() {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (subCity != null ? subCity.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }



}
