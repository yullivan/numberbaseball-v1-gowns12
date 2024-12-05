package numberbaseball;

public class Ball {
    int position;
    int number;

    public Ball(int position, int number) {

        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력!!!");
        }
        this.position = position;
        this.number = number;
    }

    public BallStatus matchStatus(Ball userBall) {
        if (userBall.position==position&&userBall.number==number){
            return BallStatus.STRIKE;
        }
        if (userBall.number==number) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
