class Person3 {
	String name;
	private String mobile;
	private String office;
	private String email;
	public Person3(String name, String mobile, String office, String email) {
		super();
		this.name=name;
		this.mobile=mobile;
		this.office=office;
		this.email=email;
	}
	
	public String toString() {
		return "Person [name="+name+ ", mobile="+mobile+ ", office="+office+", email" + email +"]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getMobile(String mobile) {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile=mobile;
	}
	public String getOffice() {
		return this.office=office;
	}
	
}
public class PersonTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
