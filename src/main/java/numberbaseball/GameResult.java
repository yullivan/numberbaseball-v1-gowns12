package numberbaseball;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    int strikeCount;
    int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    void setStrikeCount(BallStatus userBall1, BallStatus userBall2, BallStatus userBall3) {
        strikeCount = 0;
        ArrayList<BallStatus> ballList = new ArrayList<>(List.of(userBall1, userBall2, userBall3));
        for (BallStatus ball : ballList) {
            if (ball.equals(BallStatus.STRIKE)) strikeCount++;
        }
    }

    void setBallCount(BallStatus userBall1, BallStatus userBall2, BallStatus userBall3) {
        ballCount = 0;
        ArrayList<BallStatus> ballList = new ArrayList<>(List.of(userBall1, userBall2, userBall3));
        for (BallStatus ball : ballList) {
            if (ball.equals(BallStatus.BALL)) ballCount++;
        }
    }

    void outPutResult() {
        System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
    }

    void resetCount() {
        strikeCount = 0;
    }
}
