import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class strem01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> myList=Arrays.asList("Apple", "Banana", "Cherry");
		List<String> resultList=myList.stream()
				.map(s->s.toLowerCase()) //괄호필요
				.collect(Collectors.toList()); //소문자대문자..지랄
		System.out.print(resultList);
	}

}
