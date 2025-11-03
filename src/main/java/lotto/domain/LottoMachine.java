package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> createLottos(int purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_SIZE);
        return new Lotto(numbers);
    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
