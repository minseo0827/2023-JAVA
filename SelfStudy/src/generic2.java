class container2<K, V> { //제네릭은하나만허용...인줄알앗느데 꺽쇠안에여러개는가능!
	
	 private K key; //아하...결국 니네도 형태미정이라는거구나
	 private V value; //두개도 가능..인거네

	    public container2(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    public K getKey() { return key; }
	    public V getValue() {  return value;}
	}
	

public class generic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		container2<String, Integer> container1 = new container2<>("age", 30);
		container2<String, String> container2 = new container2<>("홍길동", "도적");

        String key = container1.getKey();
        Integer value = container1.getValue();

        System.out.println("Key: " + key);
        System.out.println("Value: " + value);

	}

}
