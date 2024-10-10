package model.gamer;

import java.util.regex.Pattern;

public class Name {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$");
    private static final String NOT_ALLOWED_NAME_FORMAT = "이름은 한글과 영어만 허용합니다. 이름을 다시 입력해주세요";

    private String name;

    public Name(String name){
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(!NAME_PATTERN.matcher(name).matches()){
            throw new IllegalArgumentException(NOT_ALLOWED_NAME_FORMAT);
        }
    }

    public String getName() {
        return name;
    }
}
