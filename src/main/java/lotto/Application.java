package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.readPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.createLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        List<Rank> ranks = lottos.stream()
                .map(lotto -> Rank.valueOf(winningLotto.countMatches(lotto), winningLotto.hasBonusMatch(lotto)))
                .toList();

        LottoResult result = new LottoResult(ranks);
        OutputView.printResult(result, purchaseAmount);
    }
}
