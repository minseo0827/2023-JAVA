
class Mymath {
	
	int add(int x, int y) { return x+y;	}
	int add(int x, int y, int z) {return x+y+z;}
	int add(int x, int y, int z, int w) {return x+y+z+w;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mymath obj;
		obj=new Mymath();
		System.out.print(obj.add(10, 20)+" ");
		System.out.print(obj.add(10, 20, 30)+" ");
		System.out.print(obj.add(10, 20, 30, 40)+" ");
		
		
		
		
	}

}
