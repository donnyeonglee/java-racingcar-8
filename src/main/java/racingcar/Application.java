package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 경주할 자동차 이름을 입력
        EnterVariable enterVariable = new EnterVariable();
        List<String> nameList = enterVariable.enterNames();
        System.out.println("경주할 자동차 이름 List : " + nameList); // 테스트 출력

        // 2. 시도할 횟수를 입력
        int attemptNum = enterVariable.enterAttemptNum();
        System.out.println("시도할 횟수 : " + attemptNum); // 테스트 출력
    }
}
