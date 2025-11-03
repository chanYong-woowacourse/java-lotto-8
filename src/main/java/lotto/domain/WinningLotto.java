package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


    public int countMatches(Lotto lotto) {
        return 0; // stub 반환
    }
    public boolean hasBonusMatch(Lotto lotto) {
        return false; // stub 반환
    }

}
