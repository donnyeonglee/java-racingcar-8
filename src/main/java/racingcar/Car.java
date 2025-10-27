package racingcar;

public class Car {
    String name;
    int position = 0;
    int randomNum;

    public Car(String name) {
        this.name = name;
    }

    public void attempt(int randomNum) {
        this.randomNum = randomNum;
        if (randomNum >= 4) {
            this.position += 1;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
