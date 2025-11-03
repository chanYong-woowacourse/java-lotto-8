package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Map<Rank, Integer> getStatistics() {
        return new HashMap<>(); // TODO: 구현 예정
    }

    public int getTotalPrize() {
        return 0; // TODO: 구현 예정
    }

    public double calculateProfitRate(int purchaseAmount) {
        return 0.0; // TODO: 구현 예정
    }
}
