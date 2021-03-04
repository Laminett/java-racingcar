package racingcar.view;

import racingcar.dto.RacingCarGameRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public RacingCarGameRequest getUserInput() throws IOException {
        int carNumber = getParticipatingCarNumber();
        int playCount = getPlayingCount();
        return new RacingCarGameRequest(playCount, carNumber);
    }

    private int getParticipatingCarNumber() throws IOException {
        while (true) {
            System.out.println(Message.INPUT_CAR_NUMBER.getDescription());
            String carNumberInString = SCANNER.nextLine();
            try {
                return Integer.parseInt(carNumberInString);
            } catch (NumberFormatException ex) {
                System.out.println(Message.WRONG_INPUT.getDescription());
            }
        }
    }

    private int getPlayingCount() throws IOException {
        while (true) {
            System.out.println(Message.INPUT_PLAY_COUNT.getDescription());
            String countInString = SCANNER.nextLine();
            try {
                return Integer.parseInt(countInString);
            } catch (NumberFormatException ex) {
                System.out.println(Message.WRONG_INPUT.getDescription());
            }
        }
    }
}
