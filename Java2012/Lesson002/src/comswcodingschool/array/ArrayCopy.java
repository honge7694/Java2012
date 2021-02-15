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
public class ArrayCopy {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array1 = {10, 20, 30, 40, 50};
        int[] array2 = {1, 2, 3, 4, 5};

        System.arraycopy(array1, 0, array2, 1, 4);

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
