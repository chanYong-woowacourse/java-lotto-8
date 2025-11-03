package lotto.domain;

import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> createLottosFromNumbers(List<List<Integer>> inputNumbersList) {
        return inputNumbersList.stream()
                .map(Lotto::new)
                .toList();
    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
