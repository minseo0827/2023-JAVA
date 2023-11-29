class Person2 {
	String name;
	private String mobile;
	private String office;
	private String email;
	public Person2(String name, String mobile, String office, String email) {
		super();
		this.name=name;
		this.mobile=mobile;
		this.office=office;
		this.email=email;
	}
	
	public String toString() {
		return "Person [name=" +name+ ", mobile="+mobile+ ", office="+office+", email=" + email +"]";
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
		return office;
	}
	public void setOffice(String office) {
		this.office=office;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
}
public class PersonTest {
	public static void main(String[] args) {
		Person2 obj = new Person2 ("Kim", "01012345678", "0311234567", "abc@example.net");
		System.out.println(obj);
	}
}