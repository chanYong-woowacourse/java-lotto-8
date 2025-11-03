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
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
        ranks.forEach(rank -> statistics.put(rank, statistics.get(rank) + 1));
        return statistics;
    }

    public int getTotalPrize() {
        return ranks.stream()
                .mapToInt(Rank::getPrizeMoney)
                .sum();
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (double) getTotalPrize() / purchaseAmount * 100;
    }
}
