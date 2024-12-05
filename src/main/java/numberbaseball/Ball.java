package numberbaseball;

public class Ball {
    int position;
    int number;

    public Ball(int position, int number) {

        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
        this.position = position;
        this.number = number;
    }

    public String matchStatus(Ball answerBall) {
        if (answerBall.position==this.position&&answerBall.number==this.number){
            return "STRIKE";
        } else if (answerBall.position!=this.position&&answerBall.number==this.number) {
            return "BALL";
        }
        else return "NOTHING";
    }
}
