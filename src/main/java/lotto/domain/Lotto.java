package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (numbers == null) {
            throw new IllegalArgumentException("로또 번호는 null일 수 없습니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers); //중복 허용하지 않는 자료구조
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호에 중복이 있으면 안 됩니다.");
        }

        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("로또 번호는 1~45 범위여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
