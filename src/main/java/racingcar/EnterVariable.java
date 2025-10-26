package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class EnterVariable {
    String inputNames;
    String consoleInputNum;

    public List<String> enterNames(String inputNames) { // 경주할 자동차 이름 입력
        this.inputNames = inputNames;
        List<String> nameList = new ArrayList<>();

        try {
            //inputNames = Console.readLine(); // 삭제 예정
            nameList = Arrays.asList(inputNames.split(","));

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : " + e.getMessage());
        }
        for (String name : nameList) {
            checkBlankName(name);
            checkNameLength(name);
        }
        checkDuplicateName(nameList);
        return (nameList);
    }

    private void checkNameLength(String name) { // 이름이 5자 이하인지 확인
        if (name.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : 이름은 5자 이하만 가능합니다.");
        }
    }

    private void checkBlankName(String name) { // 경주할 자동차 이름이 공백, 혹은 빈 이름을 포함하는지 확인
        if (name.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : 이름은 공백이거나 빈 값일 수 없습니다.");
        }
    }

    private void checkDuplicateName(List<String> nameList) { // 경주할 자동차 이름이 중복되는지 확인
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : 이름은 중복될 수 없습니다.");
        }
    }

    public int enterAttemptNum(String consoleInputNum) { // 시도할 횟수 입력
        this.consoleInputNum = consoleInputNum;
        int inputNum;
        try {
            inputNum = Integer.parseInt(consoleInputNum);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : " + e.getMessage());
        }
        // 입력 받은 시도 횟수가 자연수인지 확인
        if (inputNum <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : 시도할 횟수는 자연수여야 합니다.");
        }
        return inputNum;
    }
}
