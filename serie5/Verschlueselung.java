package serie5;

import java.util.List;

public class Verschlueselung {

    public void tauscheZeilen(List<String> zeichenketten){
        int len = zeichenketten.size();
        int i = 0;
        while (i + 2 < len) {
            String temp = zeichenketten.get(i);
            zeichenketten.set(i, zeichenketten.get(i + 1));
            zeichenketten.set(i + 1, temp);
            i+=2;
        }
    }

    public String tauscheZeichen (String zeichenkette, char A, char B) {
        int len = zeichenkette.length();
        StringBuilder zeichentausch = new StringBuilder(zeichenkette);
        for (int i = 0; i < len; i++) {
            if (zeichentausch.charAt(i) == A) {
                zeichentausch.setCharAt(i, B);
            } else if (zeichentausch.charAt(i) == B) {
                zeichentausch.setCharAt(i, A);
            }
        }
        return zeichenkette;
    }
    
    public String verschiebeBuchstaben (String zeichenkette, int wert) {
        int len = zeichenkette.length();

        StringBuilder g = new StringBuilder(zeichenkette);

        for (int i = 0; i < len; i++) {
                char ch1 = zeichenkette.charAt(i);
                int asciich1 = ch1;
                int asciich2 = asciich1 + wert;
                char ch2 = (char) asciich2;
                g.setCharAt(i, ch2);
        }
        return zeichenkette;
    }
}
