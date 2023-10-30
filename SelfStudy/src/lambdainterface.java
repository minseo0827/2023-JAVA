interface ArrayProcessing {
	double apply(double[] array);
	//추상메소드이름이 어플라잉인거. 이걸 우리가 구현해야한다는거고.
//배열(double[] array)을 입력으로 받아서 double 값을 반환하는 apply 메서드를 정의.주어진 배열에 대한 특정 연산 또는 처리를 수행.
//인터페이스를 구현한 클래스를 만들어서 apply 메서드를 사용, 주어진 배열에 대한 다양한 연산을 수행가능. 인터페이스를 구현하는 클래스는 apply 메서드를 정의하고 원하는 작업을 수행하게 됩니다.
}
public class lambdainterface {
	
	public static final ArrayProcessing Maxer=array-> { 
	//어레이를받아서최대값을반환.....? 뭐..어케하느데 스트림? 포문? 어라 똑같네 앞에거를일단 최대로둔다음더큰거나타나면바뀍
		double max= array[0];
		for(int i=0; i<array.length; i++)
			if(array[i]>max) max=array[i];
		return max;		
		
	}; //여기에도세미콜론이필요하다네
	
	public static final ArrayProcessing miner=array-> { 
		//어레이를받아서최대값을반환.....? 뭐..어케하느데 스트림? 포문? 어라 똑같네 앞에거를일단 최대로둔다음더큰거나타나면바뀍
			double min= array[0];
			for(int i=0; i<array.length; i++)
				if(array[i]<min) min=array[i];
			return min;		
			
		}; //여기에도세미콜론이필요하다네
		
		public static final ArrayProcessing sumer=array-> { 
			//평균계산..다 더하고 카운트로 나누기.겟지
			double sum=0; int count=0;
				for(int i=0; i<array.length; i++)
				{
					sum=sum+array[i];
					count++;
				}	
				return sum/count;		
				
			}; //여기에도세미콜론이필요하다네

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] list= {1,2,3,4,5,6,7,8,9,10};
		System.out.print("최대값: "+Maxer.apply(list));
		System.out.print("최소값: "+miner.apply(list));
		System.out.print("평균값: "+sumer.apply(list));
//		메소드명.apply(리스트이름)
		

	}

}
