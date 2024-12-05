package numberbaseball;

import java.util.ArrayList;

public class Balls {
    ArrayList<Ball> Balls;


    public Balls(ArrayList<Ball> balls) {
        if (balls.size() != 3) {
            throw new IllegalArgumentException();
        }
        Balls = balls;

    }

    //스트라이크, 볼 판정
    public String matchStatus(Ball userBall) {
        if (Balls.get(userBall.position-1).number == userBall.number) {
            return "STRIKE";
        } else{
            for (Ball ball : Balls) {
                if (ball.number== userBall.number){
                    return "BALL";
                }
            }
        }
        return "NOTHING";
    }
}
