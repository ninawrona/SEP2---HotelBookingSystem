package model;

/**
 * A class creating a Guest object
 *
 * @author Group 5
 * @version 04/05/2022
 */
public class Guest
{
  private String fName;
  private String lName;
  private String email;
  private int phoneNr;

  /**
   * Constructor to initialize instance variables
   * @param fName first name of the guest
   * @param lName last name of the guest
   * @param email email address of the guest
   * @param phoneNr phone number of the guest
   */
  public Guest(String fName, String lName, String email, int phoneNr)
  {
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.phoneNr = phoneNr;
  }

  /**
   * A method that returns first name of the guest.
   *
   * @return fName
   */
  public String getfName()
  {
    return fName;
  }

  /**
   * A method that returns last name of the guest.
   *
   * @return lName
   */
  public String getlName()
  {
    return lName;
  }

  /**
   * A method that returns email address of the guest.
   *
   * @return email
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * A method that returns phone number of the guest.
   *
   * @return phoneNr
   */
  public int getPhoneNr()
  {
    return phoneNr;
  }

  /**
   * A method that return the guest information in an organized way.
   *
   * @return Guest information
   */
  @Override public String toString()
  {
    return "Guest: " + '\'' + "First Name: '" + fName + '\'' + "Last Name: " + lName + '\''
        + "Email address: " + email + '\'' + "Phone Nr: " + phoneNr;
  }

  /**
   * Amethod meant to take a copy of an object.
   *
   * @return a copy of Guest object.
   */
  public Guest copy()
  {
    Guest other = new Guest(fName, lName, email, phoneNr);
    return other;
  }
}
