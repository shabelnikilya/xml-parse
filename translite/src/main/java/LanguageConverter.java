import org.glassfish.jaxb.core.api.impl.NameConverter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LanguageConverter extends NameConverter.Standard {
    private final static Map<Character, String> CHARACTER = new HashMap<>();

    static {
        CHARACTER.put('а', "a");
        CHARACTER.put('б', "b");
        CHARACTER.put('в', "v");
        CHARACTER.put('г', "g");
        CHARACTER.put('д', "d");
        CHARACTER.put('е', "e");
        CHARACTER.put('ж', "j");
        CHARACTER.put('з', "z");
        CHARACTER.put('и', "i");
        CHARACTER.put('к', "k");
        CHARACTER.put('л', "l");
        CHARACTER.put('м', "m");
        CHARACTER.put('н', "n");
        CHARACTER.put('о', "o");
        CHARACTER.put('п', "p");
        CHARACTER.put('р', "r");
        CHARACTER.put('с', "s");
        CHARACTER.put('т', "t");
        CHARACTER.put('у', "u");
        CHARACTER.put('ф', "f");
        CHARACTER.put('х', "h");
        CHARACTER.put('ц', "c");
        CHARACTER.put('ч', "ch");
        CHARACTER.put('ш', "sh");
        CHARACTER.put('щ', "sh");
        CHARACTER.put('ъ', "");
        CHARACTER.put('ы', "u");
        CHARACTER.put('ь', "");
        CHARACTER.put('э', "ei");
        CHARACTER.put('ю', "you");
        CHARACTER.put('я', "ya");
    }

    @Override
    public String capitalize(String s) {
        return transliteration(s);
    }

    private String transliteration(String s) {
        StringBuilder str = new StringBuilder();
        String lowerS = s.toLowerCase(Locale.ROOT);
        for (int i = 1; i < lowerS.length(); i++) {
            char c = lowerS.charAt(i);
            String t = CHARACTER.get(c);
            if (t == null) {
                str.append(c);
            } else {
                str.append(t);
            }
        }
        if (!CHARACTER.containsKey(lowerS.charAt(0))) {
            str.insert(0, s.charAt(0));
        } else {
            str.insert(0, CHARACTER.get(lowerS.charAt(0)));
        }
        return str.toString();
    }
}
