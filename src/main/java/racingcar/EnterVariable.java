package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class EnterVariable {

    public List<String> enterNames() { // 경주할 자동차 이름 입력
        String inputNames;
        List<String> nameList = new ArrayList <> ();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            inputNames = Console.readLine();
            nameList = Arrays.asList(inputNames.split(","));

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n에러 메세지 : " + e.getMessage());
        }
        for (String name : nameList) {
            checkBlankName(name);
            checkNameLength(name);
        }
        checkDuplicateName(nameList);
        return(nameList);
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
}
