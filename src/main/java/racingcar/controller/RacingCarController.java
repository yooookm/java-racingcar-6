package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.GameView;

public class RacingCarController {
    private GameView view;


    public void start() {
        String carNames = getUserInputForCarNames();
        int rounds = getUserInputForRounds();
    }

    private String getUserInputForCarNames() {
        view.printCarNameInput();
        String input = Console.readLine();
        validateCarNamesInput(input);
        return input;
    }

    private int getUserInputForRounds() {
        view.printCountInput();
        String input = Console.readLine();
        return validateAndParseRoundsInput(input);
    }

    private void validateCarNamesInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("첫번째 입력이 비어있습니다.");
        }
        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException("첫번째 입력은 영어와 ','만 포함해야 합니다.");
        }
        if (input.contains(",,") || input.endsWith(",") || input.startsWith(",")) {
            throw new IllegalArgumentException("','는 연속해서 나오거나 시작/끝에 위치할 수 없습니다.");
        }
    }

    private int validateAndParseRoundsInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("회차는 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }
}