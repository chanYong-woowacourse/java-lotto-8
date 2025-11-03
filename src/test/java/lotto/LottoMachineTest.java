package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("입력된 번호 리스트로 로또들을 생성한다")
    @Test
    void 입력된_번호_리스트로_로또들_생성() {
        // given
        List<List<Integer>> inputNumbersList = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12)
        );
        LottoMachine lottoMachine = new LottoMachine();

        // when
        List<Lotto> lottos = lottoMachine.createLottosFromNumbers(inputNumbersList);

        // then
        assertThat(lottos).hasSize(2);
        assertThat(lottos.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottos.get(1).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
    }
}
