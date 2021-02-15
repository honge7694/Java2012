package comswcodingschool.array;

/*
 * 배열의 선언과 활용
 * 배열의 선언 :
 * 1. 타입[] 배열이름 = new 타입[크기];
 * 2. 타입 배열이름[] = new 타입[크기];
 * 3. 타입[] 배열이름 = { 초기화 };
 * 4. 타입[] 배열이름;
 *    배열이름 = new int[] { 초기화 };
 */
public class ArrayTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] number = new int[10];

        for (int i = 0; i < number.length; i++) {
            number[i] = i + 1;
            System.out.println(number[i]);
        }
    }
}
