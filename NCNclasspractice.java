class NCN{
	
	int height; int kshlove; String school; String famousdialog;
	
	
	public int KSH() {
		return height+kshlove;
	}
}
class NCNclasspractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NCN JYJ = new NCN();
		JYJ.height=192;
		JYJ.kshlove=0;
		JYJ.school="원중고";
		JYJ.famousdialog="누계농";
		int love1=JYJ.KSH();
		System.out.println("기상호의 전영중을 향한 호감도는 "+love1+"입니다");
		
		
		NCN PPC = new NCN();
		PPC.height=185;
		PPC.kshlove=10000;
		PPC.school="조형고";
		PPC.famousdialog="형버단고";
		int love2=PPC.KSH();
		System.out.println("기상호의 박병찬을 향한 호감도는 "+love2+"입니다");
		

	}

}
