package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Race 클래스 단위테스트")
class RaceTest {

    List<Car> carList = new ArrayList<Car>();

    @BeforeEach
    void generateCarList() { // 테스트용 carList 생성
        List<String> nameList = Arrays.asList("pobi,woni,jun,Kim,Lee".split(","));
        for (String name : nameList) {
            Car car = new Car(name);
            carList.add(car);
        }
    }

    @Test
    @DisplayName("Race 인스턴스 생성")
    void Race_인스턴스_생성() {
        Race race = new Race(carList, 5);
        assertThat(race).isNotNull();
    }

    @Test
    @DisplayName("최종 우승자 출력 : 우승자가 한 명인 경우")
    void printWinner_우승자_한명() {
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(3);
        intList.add(2);
        intList.add(1);
        intList.add(2);
        int num;
        for (num = 0; num < carList.size(); num++) {
            Car car = carList.get(num);
            car.position = intList.get(num);
        }
        Race race = new Race(carList, 5);
        assertThat(race.printWinner(carList)).isEqualTo("최종 우승자 : woni");
    }

    @Test
    @DisplayName("최종 우승자 출력 : 우승자가 여러 명인 경우")
    void printWinner_우승자_여러명() {
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(3);
        intList.add(2);
        intList.add(3);
        intList.add(2);
        int num;
        for (num = 0; num < carList.size(); num++) {
            Car car = carList.get(num);
            car.position = intList.get(num);
        }
        Race race = new Race(carList, 5);
        assertThat(race.printWinner(carList)).isEqualTo("최종 우승자 : woni, Kim");
    }
}
