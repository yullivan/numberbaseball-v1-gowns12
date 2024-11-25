package numberbaseball;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다!");
        System.out.println("1부터 9까지의 서로 다른 숫자 3개를 맞춰보세요.");

        int[] answer = new int[3];
        Random r = new Random();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = r.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                }
            }
        }


        while (true) {
            // 사용자 입력 받기 (이 부분은 완성되어 있음)
            System.out.print("\n첫 번째 숫자를 입력하세요: ");
            int user1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int user2 = scanner.nextInt();
            System.out.print("세 번째 숫자를 입력하세요: ");
            int user3 = scanner.nextInt();

            // TODO: strike 개수를 계산하세요
            int strikes = 0;
            for (int i : answer) {
                if (user1 == i) {
                    strikes++;
                }
            }
            for (int i : answer) {
                if (user2 == i) {
                    strikes++;
                }
            }
            for (int i : answer) {
                if (user3 == i) {
                    strikes++;
                }
            }

            // TODO: 결과를 출력하세요 (예: "1 스트라이크")
            System.out.println(strikes + " 스트라이크");

            // TODO: 3 스트라이크인 경우 게임을 끝내세요
            if (strikes==3){
                break;
            }

        }

         System.out.println("축하합니다! 정답을 맞추셨습니다.");
    }

}
