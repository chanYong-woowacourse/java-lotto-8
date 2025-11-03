package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String SIZE_ERROR = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR = ERROR_PREFIX + "로또 번호에 중복이 있습니다.";
    private static final String RANGE_ERROR = ERROR_PREFIX + "로또 번호는 1~45 사이여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException(RANGE_ERROR);
            }
        }
    }


}
