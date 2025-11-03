package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @DisplayName("로또 한 장이 당첨 번호와 일치하는 개수를 계산한다")
    @Test
    void matchCount() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // 6개 일치
        assertThat(winningLotto.countMatches(lotto1)).isEqualTo(6);

        // 5개 + 보너스 일치 (특정 등수용 체크 가능)
        assertThat(winningLotto.countMatches(lotto2)).isEqualTo(5);
        assertThat(winningLotto.hasBonusMatch(lotto2)).isTrue();

        // 3개 일치
        assertThat(winningLotto.countMatches(lotto3)).isEqualTo(3);
        assertThat(winningLotto.hasBonusMatch(lotto3)).isFalse();
    }
}
