package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends NsTest {

    @Test
    @DisplayName("구매 금액 입력 프롬프트가 출력된다")
    void 구매금액_입력_프롬프트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("구입금액을 입력해 주세요.");
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 프롬프트가 출력된다")
    void 당첨번호_입력_프롬프트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("당첨 번호를 입력해 주세요.");
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 프롬프트가 출력된다")
    void 보너스번호_입력_프롬프트() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("보너스 번호를 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}