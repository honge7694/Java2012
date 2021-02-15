package comswcodingschool.array;

import java.util.ArrayList;

public class TestShopkeeper {
    private static int intival = 1000;
    int shopNo;
    String shopName;
    ArrayList<TestFruits> shopList;

    TestShopkeeper() {
    }

    TestShopkeeper(String shopName) {
        this.shopNo = intival++;
        this.shopName = shopName;

        shopList = new ArrayList<TestFruits>();
    }

    public void addFruits(String fruitName, int fruitSell) {
        TestFruits fruits = new TestFruits();

        fruits.setFruitName(fruitName);
        fruits.setFruitSell(fruitSell);

        shopList.add(fruits);
    }

    public void shopInfo() {
        int sum = 0;
        for (TestFruits fruit : shopList) {
            sum += fruit.getFruitSell();
            System.out.println("가게 이름 : " + shopName + "\t 판매 과일 : " + fruit.getFruitName() + "\t 판매 가격 : " + fruit.getFruitSell());
        }


        System.out.println("가게 과일 총 판매 가격 : " + sum);
    }


}
