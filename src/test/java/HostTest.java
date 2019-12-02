import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HostTest {

    private Host host = new Host();

    private boolean checkNumberBetweenOneAndNine(List<Integer> numbers) {
        boolean allBetweenOneAndNine = true;
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 9)) {
                allBetweenOneAndNine = false;
                break;
            }
        }
        return allBetweenOneAndNine;
    }

    private boolean checkNoDuplication(List<Integer> numbers) {
        boolean NoDuplication = true;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    NoDuplication = false;
                }
            }
        }
        return NoDuplication;
    }

    @Test
    void generate_baseball_numbers() {

        /* when: host의 generateNumbers 메서드를 실행하면 */
        host.generateNumbers();
        List<Integer> numbers = host.getNumbers();

        /* then: numbers에 중복되지 않은 1에서 9까지의 숫자가 생성된다 */
        assertTrue(checkNumberBetweenOneAndNine(numbers));
        assertTrue(checkNoDuplication(numbers));
        assertTrue(numbers.size() == Host.baseballGameSize);

    }

    @Test
    void make_result_statement() {
        /* given: host의 numbers로 5, 1, 7이 생성되었다 */
        List<Integer> generatedNumbers = new ArrayList<>();
        generatedNumbers.add(5);
        generatedNumbers.add(1);
        generatedNumbers.add(7);

        host.setNumbers(generatedNumbers);

        /* when: 입력받은 number가 5, 6, 1이면 */
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(1);

        String resultStatement = host.makeResultStatement(numbers);

        /* then: 결과는 "1스트라이크 1볼" */
        assertTrue(resultStatement.equals("1스트라이크 1볼"));

    }

    @Test
    void check_numOfStrikes_fromInput() {

        /* given: host의 numbers로 5, 1, 7이 생성되었다. */
        List<Integer> generatedNumbers = new ArrayList<>();
        generatedNumbers.add(5);
        generatedNumbers.add(1);
        generatedNumbers.add(7);

        host.setNumbers(generatedNumbers);

        /* when: 입력 받은 숫자가 3, 1, 7이다. */
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(3);
        inputNumbers.add(1);
        inputNumbers.add(7);

        /* then: host.countNumOfStrikes의 결과는 2 */
        assertTrue(host.countNumOfStrikes(inputNumbers) == 2);
    }

    @Test
    void check_numOfBall_fromInput() {

        /* given: host의 numbers로 5, 1, 7이 생성되었다. */
        List<Integer> generatedNumbers = new ArrayList<>();
        generatedNumbers.add(5);
        generatedNumbers.add(1);
        generatedNumbers.add(7);

        host.setNumbers(generatedNumbers);

        /* when: 입력받은 number는 1, 7, 5이다. */
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(1);
        inputNumbers.add(7);
        inputNumbers.add(5);

        /* then: host.countNumOfBalls의 결과는 3 */
        assertTrue(host.countNumOfBalls(inputNumbers) == 3);
    }
}