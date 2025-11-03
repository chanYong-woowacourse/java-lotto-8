package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구매_금액에_맞춰_자동으로_로또를_생성한다")
    @Test
    void 구매_금액에_맞춰_자동으로_로또_생성() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoMachine lottoMachine = new LottoMachine();
                    List<Lotto> lottos = lottoMachine.createLottos(2000);

                    assertThat(lottos).hasSize(2);
                    assertThat(lottos.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
                    assertThat(lottos.get(1).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12)
        );
    }
}
