class Box {
	
	//애네 텔레비전티스트나 똑같은오류문구가나오네. The public type Television must be defined in its own file
	int width, height, depth;
}
public class BoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box b=new Box();
		System.out.println("상자의 크기: ("+ b.width + ","+ b.height + ","+ b.depth + ")");

	}

}
