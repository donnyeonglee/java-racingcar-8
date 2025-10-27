package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차 클래스 단위테스트")
class CarTest {
    @Test
    @DisplayName("Car 인스턴스 생성")
    void Car_인스턴스_생성() {
        Car car = new Car("test");
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("무작위 값이 4 이상일 경우 전진")
    void attempt_무작위값_4이상_전진() {
        int num;
        Car car = new Car("test");
        List<String> positionList = new ArrayList<String>();
        for (num = 4; num <= 9; num++) {
            car.attempt(num);
            positionList.add(Integer.toString(car.position));
        }
        assertThat(positionList).containsExactly("1", "2", "3", "4", "5", "6"); // 순서 포함 정확히 일치
    }

    @Test
    @DisplayName("무작위 값이 4 미만일 경우 전진하지 않음")
    void attempt_무작위값_4미만_정지() {
        int num;
        Car car = new Car("test");
        List<String> positionList = new ArrayList<String>();
        for (num = 0; num <= 3; num++) {
            car.attempt(num);
            positionList.add(Integer.toString(car.position));
        }
        assertThat(positionList).containsExactly("0", "0", "0", "0"); // 순서 포함 정확히 일치
    }

    @Test
    @DisplayName("Car 인스턴스 출력시 현재 위치 시각화")
    void Car_toString_테스트() {
        Car car = new Car("test");
        car.position = 5;
        assertThat(car.toString()).isEqualTo("test : -----");
    }
}
