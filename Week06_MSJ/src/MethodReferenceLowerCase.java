import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {

    public static void main(String[] args) {
        List<String> listOfNames = Arrays.asList(new String[] { "Apple", "Banana", "Cherry" });

        // 소문자로 변환한 후 새로운 리스트로 반환
        List<String> lowerCaseList = listOfNames.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println(listOfNames); // 원래 리스트 출력
        System.out.println(lowerCaseList); // 소문자로 변환된 새로운 리스트 출력
    }
}
