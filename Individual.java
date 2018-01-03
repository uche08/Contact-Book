public class Individual
{
	private String fName,lName,address, email;
	private int phone, visible;
	public Individual(String fName, String lName, String addy, int phone, String email, int visible )
	{
		this.fName= fName;
		this.lName= lName;
		setAddress(addy);
		this.phone= phone;
		setEmail(email);
		this.visible= visible;
	}
	public void setfName(String fN){this.fName= fN;}
	public String getfName(){return fName;}
	public void setlName(String lN){this.lName= lN;}
	public String getlName(){return lName;}
	public void setAddress(String addy){this.address= addy;}
	public String getAddress(){return address;}
	public void setEmail(String email){	this.email= email;}
	public String getEmail(){return email;}
	public void setPhone(int pN){	this.phone= pN;}
	public int getPhone(){return phone;}
	public void setVisible(int a){ this.visible= a;}
	public int getVisible(){return visible;}
}