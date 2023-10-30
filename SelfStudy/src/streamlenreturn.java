import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class machine {
	String name;
	int price;
	
	public machine(String name, int price){
		this.name=name;
		this.price=price;
	}
	
	
}
public class streamlenreturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> myList=Arrays.asList("Java", "Stream", "Library");
//		List<Integer> result=myList.stream()
//				.map(s->s.length())
//				.collect(Collectors.toList()); //항상...어떤결과를리스트에담아줘야하는듯 내가 리스트인 리절트에 에담겟다고 위에썼으니깡
//		
//		System.out.print(result);
				
		//가격이 300만원이상인 애들의 이름 출력. 이름과 가격을 다 가져야하니 그런 객체를 만들어서 리스트에 담아줘야함.
		//얘는또어레이리스트네..
		List<machine> myList=new ArrayList<machine>();
		myList.add(new machine("TV", 400));
		myList.add(new machine("Vacum", 200));
		myList.add(new machine("Air conditioner", 450));
		myList.add(new machine("heater", 290));
		
		List<String> result=myList.stream()
				.filter(s->s.price>300)
				.map(p->p.name) //지금은 저 모든객체가 담겨있으니까 바로 콜렉트못해. 이름만 가져와서 콜렉트해야지. 이름만 매핑해서 갖고옴!
				.collect(Collectors.toList());
		
				
				

	}

}
