import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamprac {

	public static void main(String[] args) {
	List<Integer> mylist=Arrays.asList(1,2,3,4,5,6,7,8); //이..이랟되나? 이래도된다
	List<Integer> result=mylist.stream()
			.filter(s-> s%2==0) //세미콜론도 리턴도없어도된다. 리턴을줄거면 중괄호로감싸고 세미콜론붙이기
			.map(s->s*s)
			//.forEach(System.out::println);
//forEach 메서드는 스트림의 각 요소를 처리하고 스트림을 종료.결과를 새로운 컬렉션으로 수집하거나 반환하지 않음
//스트림을 이용해 작업하는 동안 요소를 처리하려면 forEach를 사용할 수 있습니다.
			.collect(Collectors.toList());
	System.out.print(result);
	}

}
