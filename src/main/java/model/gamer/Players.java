package model.gamer;

import model.card.CardDeck;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String NAME_DUPLICATED_MESSAGE = "플레이어의 이름이 중복되었습니다.";

    private List<Player> players;

    public Players(final List<Player> players){
        this.players = players;
    }

    public static Players of(final List<String> names){
        validateDuplicateNames(names);

        List<Player> playerList = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(playerList);
    }

    public void giveTwoCardEachPlayer(CardDeck cardDeck){
        players.stream()
                .forEach(player -> player.drawTowCard(cardDeck));
    }


    private static void validateDuplicateNames(List<String> names) {
        if(isNameDuplicate(names)){
            throw new IllegalArgumentException(NAME_DUPLICATED_MESSAGE);
        }
    }

    private static boolean isNameDuplicate(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
