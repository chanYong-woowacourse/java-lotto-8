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

        List<Integer> winningNumbers = readValidWinningNumbers();
        int bonusNumber = readValidBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        List<Rank> ranks = lottos.stream()
                .map(lotto -> Rank.valueOf(winningLotto.countMatches(lotto), winningLotto.hasBonusMatch(lotto)))
                .toList();

        LottoResult result = new LottoResult(ranks);
        OutputView.printResult(result, purchaseAmount);
    }

    private static List<Integer> readValidWinningNumbers() {
        while (true) {
            try {
                List<Integer> numbers = InputView.readWinningNumbers();
                new Lotto(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber(winningNumbers);
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                new Lotto(List.of(1, 2, 3, 4, 5, bonusNumber));  // 범위 검증
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
