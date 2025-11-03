package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
        // 객체 생성 방지
    }

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> statistics = result.getStatistics();
        printRankStatistics(statistics);

        double profitRate = result.calculateProfitRate(purchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    private static void printRankStatistics(Map<Rank, Integer> statistics) {
        printRank(Rank.FIFTH, statistics);
        printRank(Rank.FOURTH, statistics);
        printRank(Rank.THIRD, statistics);
        printRank(Rank.SECOND, statistics);
        printRank(Rank.FIRST, statistics);
    }

    private static void printRank(Rank rank, Map<Rank, Integer> statistics) {
        if (rank == Rank.NONE) {
            return;
        }
        String description = getRankDescription(rank);
        int count = statistics.get(rank);
        System.out.println(description + " - " + count + "개");
    }

    private static String getRankDescription(Rank rank) {
        int prizeMoney = rank.getPrizeMoney();
        String formattedPrize = DECIMAL_FORMAT.format(prizeMoney);

        return switch (rank) {
            case FIFTH -> "3개 일치 (" + formattedPrize + "원)";
            case FOURTH -> "4개 일치 (" + formattedPrize + "원)";
            case THIRD -> "5개 일치 (" + formattedPrize + "원)";
            case SECOND -> "5개 일치, 보너스 볼 일치 (" + formattedPrize + "원)";
            case FIRST -> "6개 일치 (" + formattedPrize + "원)";
            default -> "";
        };
    }
}