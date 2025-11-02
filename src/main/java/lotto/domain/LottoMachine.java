package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(List<List<Integer>> inputNumbersList) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> numbers : inputNumbersList) {
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
