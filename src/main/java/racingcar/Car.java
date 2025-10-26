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
        // System.out.println("자동차 이름 : " + name + " 무작위 값 : " + randomNum + " 현재 위치 : " + position); //테스트 출력
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
