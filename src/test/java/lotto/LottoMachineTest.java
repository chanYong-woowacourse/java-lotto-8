package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("구매 금액에 맞게 로또 장 수를 생성한다")
    @Test
    void generateLottosByPurchaseAmount() {
        int purchaseAmount = 5000; // 5000원이면 5장
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);

        // 장 수 검증
        assertThat(lottos).hasSize(purchaseAmount/1000);

        // 각 로또 번호 검증
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

}
