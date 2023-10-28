import java.util.ArrayList;
import java.util.List;

enum Type {
    MEAT, FISH, OTHER
}

//food 클래스를 하나로 합쳐도 됨

public class Test1 {
    public static void main(String[] args) {
        List<Food> buffetMenu = new ArrayList<>();
        // 여기에 뷔페 식당의 메뉴로 Food 객체를 추가해야 합니다.
        buffetMenu.add(new Food("Salad", true, 250, Type.OTHER));
        buffetMenu.add(new Food("Steak", false, 700, Type.MEAT));
        buffetMenu.add(new Food("Veggie Soup", true, 150, Type.OTHER));
        buffetMenu.add(new Food("Grilled Salmon", false, 350, Type.FISH));

        // 칼로리가 300 이하이고 채식인 음식의 이름을 추출하여 리스트로 만듭니다.
        List<String> healthyVegeFoods = new ArrayList<>();
        for (Food food : buffetMenu) {
            if (food.isVege() && food.getCalories() <= 300) {
                healthyVegeFoods.add(food.getName());
            }
        }

        // 결과 출력
        System.out.println("칼로리 300 이하이고 채식인 음식: " + healthyVegeFoods);
    }
}
