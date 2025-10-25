package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    List<Car> carList = new ArrayList<Car>();
    int attemptNum;
    int num;

    public Race(List<Car> carList, int attemptNum) {
        this.carList = carList;
        this.attemptNum = attemptNum;
    }

    // 차수별 실행 결과 출력
    public void run() {
        System.out.println();
        System.out.println("실행 결과");
        for (num = 1; num <= attemptNum; num++) {
            attemptAllCars(carList);
            printCarPosition(carList);
            System.out.println();
        }
    }

    // 최종 우승자 출력
    public void printWinner(List<Car> carList) { //
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition(carList);
        for (Car car : carList) {
            if (car.position == maxPosition) {
                winnerList.add(car.name);
            }
        }
        String winner = String.join(",", winnerList);
        System.out.println("최종 우승자 : " + winner);
    }

    private void attemptAllCars(List<Car> carList) { // 자동차 리스트 내 모든 자동차에 대해 1회 시도
        for (Car car : carList) {
            car.attempt();
        }
    }

    private void printCarPosition(List<Car> carList) { // 현재 자동차 위치 시각화
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    private int getMaxPosition(List<Car> carList) { // 최종 우승자의 현재 위치 저장
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.position >= maxPosition) {
                maxPosition = car.position;
            }
        }
        System.out.println("가장 멀리 간 위치 : " + maxPosition); // 테스트 출력
        return maxPosition;
    }
}
