package Model;

public class Guest
{
  private String fName;
  private String lName;
  private String email;
  private int phoneNr;

  Guest(String fName, String lName, String email, int phoneNr)
  {
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.phoneNr = phoneNr;
  }

  public String getfName()
  {
    return fName;
  }

  public String getlName()
  {
    return lName;
  }

  public String getEmail()
  {
    return email;
  }

  public int getPhoneNr()
  {
    return phoneNr;
  }

  @Override public String toString()
  {
    return "Guest: " + '\'' + "First Name: '" + fName + '\'' + "Last Name: " + lName + '\''
        + "Email address: " + email + '\'' + "Phone Nr: " + phoneNr;
  }
}
