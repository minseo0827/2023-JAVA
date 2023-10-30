import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Food {
	String name;
	boolean Vege;
	int calories;
	Type type;

	public Food(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.Vege = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVege() {
		return Vege;
	}

	public void setVege(boolean vege) {
		Vege = vege;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}
}

enum Type {
	MEAT, FISH, OTHER
}

public class FoodStreamTest {
	
	public static void main(String[] args) {
		//일단 리스트이름만만들고 추후추가하는것은 어레이리스트를사용해야한다! Arrays.asList는 고정크기인기봐
		//Arrays.asList() 메소드로 생성된 리스트는 고정 크기 리스트이므로 원소를 추가하거나 제거할 수 없습니다. 
		List<Food> buffet=new ArrayList<Food>();
		buffet.add(new Food("pizza", false, 400, Type.MEAT));
		buffet.add(new Food("Salad", true, 200, Type.OTHER));
		buffet.add(new Food("noodle", true, 350, Type.FISH));
		buffet.add(new Food("cchim", true, 290, Type.OTHER));
		buffet.add(new Food("spagetti", false, 450, Type.OTHER));
		List<String> result=buffet.stream()
				.filter(f->f.calories<=300)
				.map(f->f.name)
				.collect(Collectors.toList());
		
		System.out.print(result);
		
		
//간단하지. 리스트에 푸드객체를넣을거니까 그 푸드클래스만들어서 그걸로 객체만들고 어레이리스트에다가 집어넣고. 스트림써서 걸러낸다.
	}
}