package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("등수별 당첨 개수를 집계한다")
    @Test
    void 등수별_당첨_개수_집계() {
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.FIFTH, Rank.NONE);
        LottoResult result = new LottoResult(ranks);

        Map<Rank, Integer> statistics = result.getStatistics();
        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(2);
        assertThat(statistics.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(0);
    }

    @DisplayName("총 상금을 계산한다")
    @Test
    void 총_상금_계산() {
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.FIFTH);
        LottoResult result = new LottoResult(ranks);

        int totalPrize = result.getTotalPrize();
        assertThat(totalPrize).isEqualTo(60_000); // 5000 + 50000 + 5000
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void 수익률_계산() {
        List<Rank> ranks = List.of(Rank.FIFTH);
        LottoResult result = new LottoResult(ranks);

        double profitRate = result.calculateProfitRate(8000);
        assertThat(profitRate).isEqualTo(62.5); // 5000 / 8000 * 100
    }
}