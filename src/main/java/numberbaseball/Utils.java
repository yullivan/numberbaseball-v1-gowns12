package numberbaseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Utils {
    //숫자 리스트에서 랜덤 숫자를 뽑은뒤 중복 제거
    public static int randomNumber(ArrayList<Integer> numberList) {
        int number = 0;
        Collections.shuffle(numberList);
        number = numberList.get(0);
        numberList.remove(0);
        return number;
    }

    //정답 볼 생성
    public static Ball answerBall(int position, ArrayList<Integer> numberList) {
        return new Ball(position, Utils.randomNumber(numberList));
    }

    //스트라이크 카운트 계산
    public static int strikeCount(String ball1, String ball2, String ball3) {
        int strikes = 0;
        ArrayList<String> ballList = new ArrayList<>(List.of(ball1, ball2, ball3));
        for (String ball : ballList) {
            if (ball.equals("STRIKE")) strikes++;
        }
        return strikes;
    }

    //볼 카운트 계산
    public static int ballCount(String ball1, String ball2, String ball3) {
        int balls = 0;
        ArrayList<String> ballList = new ArrayList<>(List.of(ball1, ball2, ball3));
        for (String ball : ballList) {
            if (ball.equals("BALL")) balls++;
        }
        return balls;
    }

    //게임 결과 출력
    public static void gameResult(int strikes, int balls) {
        System.out.println(strikes + " 스트라이크 " + balls + " 볼");
    }

    //재시작 여부 질문
    public static void askToRestartGame() {
        System.out.println("게임 승리!");
        System.out.print("게임을 다시 시작하시겠습니까? : (y/n)");
    }

    //재시작 입력
    public static String askToRestartGameInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("y")&&!input.equals("n")){
            System.out.println("잘못 입력하셨습니다.");
            System.out.print("다시 입력해주세요 : (y/n)");
            input = scanner.nextLine();
        }
        return input;
    }

    //유저 정답 입력
    public static Ball userBallInput(int position){
        Scanner scanner = new Scanner(System.in);
        Ball userball = null;
        while (userball==null){
            try {
                userball = new Ball(position,scanner.nextInt());
            }catch (IllegalArgumentException e){
                System.out.println("잘못 입력하셨습니다. [1~9]");
            }
        }
        return userball;
    }

}
