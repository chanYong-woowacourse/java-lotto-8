package lotto;

import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("금액이_1000원_단위가_아닐_경우_예외")
    @Test
    void 금액이_1000원_단위가_아니면_예외(){
        assertThatThrownBy(()-> Validator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("음수_금액_입력_시_예외")
    @Test
    void 금액이_음수면_예외(){
        assertThatThrownBy(()->Validator.validatePurchaseAmount("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("금액이_정수가_아니면_예외")
    @Test
    void 금액이_정수가_아니면_예외(){
        assertThatThrownBy(()->Validator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("금액이_정상적으로_입력되면_예외발생하지_않음")
    @Test
    void 금액이_정상적으로_입력되면_예외발생하지_않음() {
        assertThatCode(() -> Validator.validatePurchaseAmount("3000"))
                .doesNotThrowAnyException();
    }

}
