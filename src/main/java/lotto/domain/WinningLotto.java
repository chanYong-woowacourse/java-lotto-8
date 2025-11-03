package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


    public int countMatches(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return (int) lottoNumbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
    public boolean hasBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

}
