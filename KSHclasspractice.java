class Nongsun {
	public int wingspen;
	public int height;
	
	public int KSHScouter() {
		return wingspen+height;
	}
}
public class  KSHclasspractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Nongsun SJS=new Nongsun();
		SJS.wingspen=180;
		SJS.height=188;
		int Nongguryeok=SJS.KSHScouter();
		System.out.print("이 선수의 농구력: "+SJS.KSHScouter());
	}

}

