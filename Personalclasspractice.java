class JicgakSamdak {
	public int bottom;
	public int height;
	
	public double size() {
		return 0.5*bottom*height;
	}
}
public class Personalclasspractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JicgakSamdak semo=new JicgakSamdak();
		semo.bottom=10;
		semo.height=5;
//		double area = semo.size();
		System.out.print("이 직각삼각형의 면적: "+semo.size());
	}

}
