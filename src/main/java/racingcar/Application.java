package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 경주할 자동차 이름 입력
        EnterVariable enterVariable = new EnterVariable();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> nameList = enterVariable.enterNames(inputNames);
        //System.out.println("경주할 자동차 이름 List : " + nameList); // 테스트 출력

        // 2. 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttemptNum = Console.readLine();
        int attemptNum = enterVariable.enterAttemptNum(inputAttemptNum);
        // System.out.println("시도할 횟수 : " + attemptNum); // 테스트 출력

        // 3. 자동차 List 생성
        List<Car> carList = new ArrayList<Car>();
        for (String name : nameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        // 4. 입력한 횟수만큼 차수별 실행
        Race race = new Race(carList, attemptNum);
        race.run();
        // System.out.println(carList); // 테스트 출력


        // 5. 최종 우승자 출력
        race.printWinner(carList);
    }
}
