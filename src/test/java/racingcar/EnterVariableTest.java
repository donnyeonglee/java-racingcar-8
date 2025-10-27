package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("변수 입력 클래스 단위테스트")
class EnterVariableTest {
    @Test
    @DisplayName("자동차 이름 입력 : 정상")
    void enterNames_이름_정상입력() {
        EnterVariable enterVariable = new EnterVariable();
        List<String> names = enterVariable.enterNames("pobi,woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun"); // 순서 포함 정확히 일치
    }

    @Test
    @DisplayName("자동차 이름 입력 : 한글 및 공백 포함 이름 정상")
    void enterNames_한글_및_공백포함_이름_정상입력() {
        EnterVariable enterVariable = new EnterVariable();
        List<String> names = enterVariable.enterNames(" pobi,wo ni,jun , a b ,이순신,김 유신");
        assertThat(names).containsExactly(" pobi", "wo ni", "jun ", " a b ", "이순신", "김 유신"); // 순서 포함 정확히 일치 여부 확인
    }

    @Test
    @DisplayName("자동차 이름 입력 : 마지막 쉼표는 정상")
    void enterNames_마지막_쉼표_정상입력() {
        EnterVariable enterVariable = new EnterVariable();
        List<String> names = enterVariable.enterNames("pobi,woni,jun,");
        assertThat(names).containsExactly("pobi", "woni", "jun"); // 순서 포함 정확히 일치 여부 확인
    }

    @Test
    @DisplayName("자동차 이름 입력 : 이름 5자 초과 예외처리")
    void enterNames_이름_5자_초과_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames("pobi,woniii,jun");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 : 맨 앞에 빈 이름 입력시 예외처리")
    void enterNames_맨_앞_빈_이름_입력_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames(",pobi,jun");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 : 중간에 빈 이름 입력시 예외처리")
    void enterNames_중간_빈_이름_입력_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames("pobi,,jun");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 : 맨 앞에 공백 이름 입력시 예외처리")
    void enterNames_맨_앞_공백_이름_입력_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames("   ,pobi,jun");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 : 중간에 공백 이름 입력시 예외처리")
    void enterNames_중간_공백_이름_입력_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames("pobi, ,jun");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 : 맨 뒤에 공백 이름 입력시 예외처리")
    void enterNames_맨_뒤_공백_이름_입력_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames("pobi,jun, ");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 : 중복 이름 입력시 예외처리")
    void enterNames_중복된_이름_입력_예외처리() {
        EnterVariable enterVariable = new EnterVariable();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterNames("pobi,pobi,jun");
        });
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 정상")
    void enterAttemptNum_횟수_정상입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = "5";
        int attemptNum = enterVariable.enterAttemptNum(inputAttemptNum);
        assertThat(attemptNum).isEqualTo(5);
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 최솟값 입력 정상")
    void enterAttemptNum_횟수_최솟값_정상입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = "1";
        int attemptNum = enterVariable.enterAttemptNum(inputAttemptNum);
        assertThat(attemptNum).isEqualTo(1);
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 정수 최댓값 입력 정상")
    void enterAttemptNum_횟수_최댓값_정상입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = Integer.toString(Integer.MAX_VALUE);
        int attemptNum = enterVariable.enterAttemptNum(inputAttemptNum);
        assertThat(attemptNum).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 0 입력시 예외처리")
    void enterAttemptNum_횟수_예외처리_0입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = "0";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterAttemptNum(inputAttemptNum);
        });
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 음수 입력시 예외처리")
    void enterAttemptNum_횟수_예외처리_음수입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = "-5";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterAttemptNum(inputAttemptNum);
        });
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 실수 입력시 예외처리")
    void enterAttemptNum_횟수_예외처리_실수입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = "5.1";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterAttemptNum(inputAttemptNum);
        });
    }

    @Test
    @DisplayName("시도할 횟수 입력 : 정수 범위를 초과하는 수 입력시 예외처리")
    void enterAttemptNum_횟수_예외처리_큰수입력() {
        EnterVariable enterVariable = new EnterVariable();
        String inputAttemptNum = "3147483647";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            enterVariable.enterAttemptNum(inputAttemptNum);
        });
    }
}
