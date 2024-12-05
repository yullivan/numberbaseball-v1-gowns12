package numberbaseball;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        //숫자 리스트 생성[1~9]
        ArrayList<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        //숫자 리스트에서 랜덤한 숫자를 골라 정답지 생성
        Ball ball1 = Utils.answerBall(1, numberList);
        Ball ball2 = Utils.answerBall(2, numberList);
        Ball ball3 = Utils.answerBall(3, numberList);
        Balls balls = new Balls(new ArrayList<>(List.of(ball1, ball2, ball3)));

        //스트라이크와 볼 카운트 생성
        int strikeCount = 0;
        int ballCount = 0;

        System.out.println("게임 시작");

        //스트라이크가 3이 될때 까지 반복
        while (strikeCount < 3) {
            System.out.println("숫자를 입력하세요. [1~9]");

            //유저의 정답 입력(1~9 이외의 값을 입력하면 다시 입력)
            Ball userBall1 = Utils.userBallInput(1);
            Ball userBall2 = Utils.userBallInput(2);
            Ball userBall3 = Utils.userBallInput(3);

            //스트라이크와 볼 판정
            BallStatus ball1MatchStatus = balls.matchStatus(userBall1);
            BallStatus ball2MatchStatus = balls.matchStatus(userBall2);
            BallStatus ball3MatchStatus = balls.matchStatus(userBall3);

            //스트라이크와 볼 카운트 계산
            strikeCount = Utils.strikeCount(ball1MatchStatus, ball2MatchStatus, ball3MatchStatus);
            ballCount = Utils.ballCount(ball1MatchStatus, ball2MatchStatus, ball3MatchStatus);

            //결과 출력
            Utils.gameResult(strikeCount, ballCount);

            //정답을 맞추면 게임을 다시 할지 물어보고 리셋
            if (strikeCount == 3) {
                Utils.askToRestartGame();
                if (Utils.askToRestartGameInput().equals("y")) {
                    strikeCount = 0;
                    numberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
                    ball1 = Utils.answerBall(1, numberList);
                    ball2 = Utils.answerBall(2, numberList);
                    ball3 = Utils.answerBall(3, numberList);

                    balls = new Balls(new ArrayList<>(List.of(ball1, ball2, ball3)));
                }
            }
        }
        System.out.println("게임 종료");
    }
}
