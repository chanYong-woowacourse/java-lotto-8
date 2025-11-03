package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("6개 일치하면 1등")
    @Test
    void 일등_판정() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getPrizeMoney()).isEqualTo(2_000_000_000);
    }

    @DisplayName("5개 일치 + 보너스 일치하면 2등")
    @Test
    void 이등_판정() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getPrizeMoney()).isEqualTo(30_000_000);
    }

    @DisplayName("5개 일치하면 3등")
    @Test
    void 삼등_판정() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getPrizeMoney()).isEqualTo(1_500_000);
    }

    @DisplayName("4개 일치하면 4등")
    @Test
    void 사등_판정() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getPrizeMoney()).isEqualTo(50_000);
    }

    @DisplayName("3개 일치하면 5등")
    @Test
    void 오등_판정() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getPrizeMoney()).isEqualTo(5_000);
    }

    @DisplayName("3개 미만 일치하면 낙첨")
    @Test
    void 낙첨_판정() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getPrizeMoney()).isEqualTo(0);
    }
}