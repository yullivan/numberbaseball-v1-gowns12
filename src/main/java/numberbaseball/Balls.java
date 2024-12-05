package numberbaseball;

import java.util.ArrayList;

public class Balls {
    ArrayList<Ball> balls;


    public Balls(ArrayList<Ball> ballList) {
        if (ballList.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 볼의 개수는 3개여야 합니다!!");
        }
        balls = ballList;

    }

    //스트라이크, 볼 판정
    public BallStatus matchStatus(Ball userBall) {

        BallStatus ballStatus = BallStatus.NOTHING;

        for (Ball ball : balls) {
            ballStatus = ball.matchStatus(userBall);

            if (ballStatus.equals(BallStatus.STRIKE)) {
                return ballStatus;
            }
            if (ballStatus.equals(BallStatus.BALL)) {
                return ballStatus;
            }
        }
        return ballStatus;
    }

    public void ballsReset(ArrayList<Integer> numberList){
        balls.set(0,Utils.answerBall(1, numberList));
        balls.set(1,Utils.answerBall(2, numberList));
        balls.set(2,Utils.answerBall(3, numberList));
    }
}
