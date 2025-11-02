package lotto.util;

public class Validator {

    private Validator() {
        // 객체 생성 방지
    }

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_NUMBER = ERROR_PREFIX + "금액은 숫자여야 합니다.";
    private static final String NEGATIVE_AMOUNT = ERROR_PREFIX + "금액은 음수가 될 수 없습니다.";
    private static final String INVALID_UNIT = ERROR_PREFIX + "금액은 1000원 단위여야 합니다.";

    public static void validatePurchaseAmount(String string) {
        int amount = parseAmount(string);
        validateNonNegative(amount);
        validateThousandUnit(amount);
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private static void validateNonNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT);
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_UNIT);
        }
    }
}
