package core.fundamentals.models;

import java.util.Date;
import java.util.GregorianCalendar;

import core.fundamentals.utilities.GenderType;

public class Customer {
  private String title;
  private String firstName;
  private String surename;
  private String address;
  private String phone;
  private String email;
  private int customerNumber;
  private GenderType gender;
  private boolean isValid;
  private Date expiryDate;

  public Customer(String title, String firstName, String surename,
    String address, String phone, String email, int customerNumber, GenderType gender) {
    setName(title, firstName, surename);

    this.address = address;
    this.phone = phone;
    this.customerNumber = customerNumber;
    this.gender = gender;
    this.isValid = true;

    GregorianCalendar gCal = new GregorianCalendar();
    gCal.add(GregorianCalendar.YEAR, 1);
    this.expiryDate = gCal.getTime();
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getSurename() {
    return this.surename;
  }

  public void setName(String title, String firstName, String surename) {
    this.title = title;
    this.firstName = firstName;
    this.surename = surename;
  }

  public String getMailingName() {
    //String mailingName = title + " " + firstName + " " + surename;
    StringBuilder sb = new StringBuilder(title);
    sb.append(" ");
    sb.append(firstName.substring(0, 1));
    sb.append(" ");
    sb.append(surename);
    return sb.toString();
  }

  public GenderType getGender() {
    return this.gender;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

	@Override
	public String toString() {
		return "Customer [getMailingName()=" + getMailingName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerNumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isValid ? 1231 : 1237);
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((surename == null) ? 0 : surename.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerNumber != other.customerNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (isValid != other.isValid)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (surename == null) {
			if (other.surename != null)
				return false;
		} else if (!surename.equals(other.surename))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
  
  

}
