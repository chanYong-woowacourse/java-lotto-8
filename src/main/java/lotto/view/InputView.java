package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                Validator.validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }

    public static int readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            }
        }
    }
}
