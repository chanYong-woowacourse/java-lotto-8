package lotto.util;

public class Validator {
    public static void validatePurchaseAmount(String string){
        int amount;

        try{
            amount = Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }

        if (amount < 0){
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 될 수 없습니다.");
        }

        if (amount % 1000 !=0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }
}
