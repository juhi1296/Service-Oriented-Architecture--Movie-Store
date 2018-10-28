package onlinemoviestore.omswebservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private String emailid;
	private String firstName;
	private String lastName;
	private String houseNo;
	private String society;
	private String area;
	private String city;
	private String state;
	private String password;
	private List<String> phoneNo;
	
	
	public Customer() {
		super();
	}
	public Customer(String emailid, String firstName, String lastName, String houseNo, String society, String area,
			String city, String state, String password) {
		super();
		this.emailid = emailid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNo = houseNo;
		this.society = society;
		this.area = area;
		this.city = city;
		this.state = state;
		this.password = password;
	}
	
	public Customer(String emailid, String firstName, String lastName, String houseNo, String society, String area,
			String city, String state, String password, List<String> phoneNo) {
		super();
		this.emailid = emailid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNo = houseNo;
		this.society = society;
		this.area = area;
		this.city = city;
		this.state = state;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(List<String> phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Customer [emailid=" + emailid + ", firstName=" + firstName + ", lastName=" + lastName + ", houseNo="
				+ houseNo + ", society=" + society + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	
}
