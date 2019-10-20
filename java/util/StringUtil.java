package util;

public class StringUtil {
    public static Character[] toCharacterArray(String str) {
        if (str == null) {
            return null;
        }

        Character[] chars = new Character[str.length()];

        for (int index = 0; index < str.length(); index++) {
            chars[index] = str.charAt(index);
        }
        return chars;
    }
}