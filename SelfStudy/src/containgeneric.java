import java.util.Set;

class container<T> {
	T content; //변수형도미정.
	
	//생성자..필요없을것같은데?
	public void set(T content) {this.content=content;}
	//세팅하느거니까 리턴없고. 저 자료형의 컨텐트를받아서 설정한ㄷ
	public T get() {return content;}
	//겟이니까 리턴해주는애, 자료형필요.
	
}
public class containgeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		container<String> container1=new container(); //객체생성
		container1.set("세팅하기");
		String res=container1.get();
		System.out.print(res);
		
		container<Integer> container2=new container();
		container2.set(100);
		int result=container2.get();
		System.out.print(result);
		
	}

}
