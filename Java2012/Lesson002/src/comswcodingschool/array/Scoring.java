package comswcodingschool.array;

import java.util.Scanner;

/*
 * 2차원 배열 예제, 학생 3명의 국, 영, 수 과목의 총점과 평균을 구하여 출력하는 프로그램을 구성하시오.
 * 접근순서 -:> Pseudo Code
 * 1. 배열 double [3][5]score선언
 * 2. 학생성적은 어떤 방법? 사용자로부터 입력
 * 		for loop 행 {
 * 			for loop 열 {
 * 				각 학생의 국/영/수 과목을 입력 받는다.
 * 			}
 * 		}
 * 3. for loop 행{
 * 	  	for loop 열{
 * 	  		개인별 총점과 평균을 계산한다.
 * 	  		총점 score[i][3], 평균 총점 / 3
 * 	  	}
 * 	  }
 * 4. 다중 for loop 이용, 배열 전체를 출력한다.
 */
public class Scoring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] score = new double[3][5];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length - 2; j++) {
                score[i][j] = sc.nextDouble();
                score[i][3] += score[i][j];
            }
            score[i][4] = score[i][3] / 3;
        } // end of for

        System.out.println("국어" + "\t" + "수학" + "\t" + "영어" + "\t" + "총점" + "\t" + "평균");

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + "\t");
            }
            System.out.println(" ");
        } // end of for

    } // end of main

} // end of class
