package comswcodingschool.array;

public class TestFruitsTest {
	public static void main(String[] args) {
		TestShopkeeper spChungju = new TestShopkeeper("청주과일가게");
		TestShopkeeper spChunan = new TestShopkeeper("천안과일가게");
		
		spChungju.addFruits("사과", 500);
		spChungju.addFruits("복숭아", 1500);
		spChungju.addFruits("레몬", 1000);
		
		spChungju.shopInfo();
		
		System.out.println("-----------------------------------------");
		
		spChunan.addFruits("바나나", 1200);
		spChunan.addFruits("키위", 800);
		spChunan.addFruits("파인애플", 2100);
		
		spChunan.shopInfo();
	}
}
