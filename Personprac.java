class person8{
	
	String name;
	private int mobile;
	private String office;
	private String email;
	
	public person8(String n, int m, String o, String e) { name=n; mobile=m; office=o; email=e;}
	
	public String toString() { return "전화번호를 문자열로 변환하면 "+mobile;}
	//name은 private이 아닌데도 접근자와 생성자가 필요할까?
	public void setName(String name) {this.name=name;}
	public String getName() {return name;}
	
	public void setOffice(String office) {this.office=office;}
	public String getOffice() {return office;}
	
	public void setEmail(String email) {this.email=email;}
	public String getEmail() {return email;}

	public void setMobile(int mobile) { this.mobile=mobile;}
	public int getMobile() {return mobile;}
}
	
public class Personprac {
	public static void main(String[] args) {
		person8 msj = new person8("조민서", 11112222, "덕성여자대학교", "amy2002@naver.com");
		System.out.print("이 사람의 이름은 "+msj.getName()+", 이 사람의 전화번호는 "+msj.getMobile()+", 이 사람의 직장은 "+msj.getOffice()+
				", 이 사람의 이메일은 "+msj.getEmail()+"\n");
		System.out.print(msj.toString());
	}
}