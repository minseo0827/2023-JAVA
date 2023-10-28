//package Generic;

class Container<T> {
	private T t;
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t=t;
	}
}


public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container<String> c1=new Container<String>();
		c1.set("홍길동");
		String str=c1.get();
		
		Container<Integer> c2=new Container<Integer>();
		c2.set(6);
		int val=c2.get();

	}

}
