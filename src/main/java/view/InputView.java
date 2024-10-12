package view;

import model.gamer.Name;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String GAME_START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String ASK_BETTING_AMOUNT = "%s의 배팅 금액은?";
    private static final String ANNOUNCE_GIVE_CARD = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String NAME_INPUT_ERROR = "이름 입력과정 중 에러가 발생했습니다. 재시작 해주세요";
    private static final String BETTING_INPUT_ERROR = "베팅금액 입력과정 중 에러가 발생했습니다.";

    private static final String NAME_SEPARATOR = ",";
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readPlayerName() {
        System.out.println(GAME_START_MESSAGE);
        try {
            return Arrays.stream(bufferedReader.readLine().split(NAME_SEPARATOR))
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e){
            throw new IllegalArgumentException(NAME_INPUT_ERROR);
        }

    }
    public int askBettingAmount(String name){
        System.out.println(String.format(ASK_BETTING_AMOUNT, name));

        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e){
            throw new IllegalArgumentException(BETTING_INPUT_ERROR);
        }
    }





}
