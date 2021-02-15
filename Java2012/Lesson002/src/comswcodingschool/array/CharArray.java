package comswcodingschool.array;

/*
 * 배열 길이의 유효한 요소 값, 즉 배열의 크기를 벗어나지 않도록 인덱스를 사용하기.
 */
public class CharArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] alphabets = new char[26];
        char ch = 'A';

        for (int i = 0; i < alphabets.length; i++, ch++) {
            alphabets[i] = ch;
        }

        for (int i = 0; i < alphabets.length; i++) {
            System.out.println(alphabets[i] + ", " + (int) alphabets[i]);
        }
    }// end of main
}// end of class
