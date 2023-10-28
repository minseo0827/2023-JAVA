import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.w3c.dom.ls.LSInput;

public class Test {
	public static void main(String[] args) {
		List<String> list=Arrays.asList("Kim", "Park", "Lee", "Choi","Chee");
		List<String> subList=list.stream()
				.filter(s->s.startsWith("C"))
				.sorted()
				.collect(Collectors.toList());
		System.out.println(subList);
	}
}
