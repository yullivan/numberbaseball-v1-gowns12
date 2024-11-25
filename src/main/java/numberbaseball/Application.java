package numberbaseball;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다!");
        System.out.println("1부터 9까지의 서로 다른 숫자 3개를 맞춰보세요.");

        //중복되지 않는 랜덤한 숫자 3개 생성
        int[] answer = answer();

        while (true) {
            // 사용자 입력 받기 (이 부분은 완성되어 있음)
            System.out.print("\n첫 번째 숫자를 입력하세요: ");
            int user1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int user2 = scanner.nextInt();
            System.out.print("세 번째 숫자를 입력하세요: ");
            int user3 = scanner.nextInt();

            //유저 입력을 배열로 변환
            int[] userInput = {user1, user2, user3};


            // TODO: strike 개수를 계산하세요

            //스트라이크의 개수 = strikes
            int strikes = strikes(userInput, answer);

            //볼의 개수 = balls
            int balls = balls(userInput, answer);

            // TODO: 결과를 출력하세요 (예: "1 스트라이크")
            System.out.println(strikes + " 스트라이크, " + balls + " 볼");

            // TODO: 3 스트라이크인 경우 게임을 끝내세요
            if (strikes == 3) {
                break;
            }

        }

        System.out.println("축하합니다! 정답을 맞추셨습니다.");
    }

    //길이가 n인 중복되지 않는 랜덤 숫자 배열 생성
    static int[] answer() {
        List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numberList);
        return new int[]{numberList.get(0), numberList.get(1), numberList.get(2)};
    }

    //스트라이크의 개수를 구하는 함수
    static int strikes(int[] user, int[] answer) {
        int strikes = 0;
        for (int i : answer) {
            if (user[0] == i) {
                if (i == answer[0]) {
                    strikes++;
                }
            }
        }
        for (int i : answer) {
            if (user[1] == i) {
                if (i == answer[1]) {
                    strikes++;
                }
            }
        }
        for (int i : answer) {
            if (user[2] == i) {
                if (i == answer[2]) {
                    strikes++;
                }
            }
        }

        return strikes;
    }

    //볼의 개수를 구하는 함수
    static int balls(int[] user, int[] answer) {
        int balls = 0;
        for (int i : answer) {
            if (user[0] == i) {
                if (i != answer[0]) {
                    balls++;
                }
            }
        }
        for (int i : answer) {
            if (user[1] == i) {
                if (i != answer[1]) {
                    balls++;
                }
            }
        }
        for (int i : answer) {
            if (user[2] == i) {
                if (i != answer[2]) {
                    balls++;
                }
            }
        }

        return balls;
    }
}
