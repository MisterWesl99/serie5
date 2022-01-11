package serie5;

import java.util.List;

public class Verschluesselung {
    static void tauscheZeilen(List<String> zeichenketten) {
        int len = zeichenketten.size();
        for (int i = 0; i + 2 <= len; i += 2) {
            String temp = zeichenketten.get(i);
            zeichenketten.set(i, zeichenketten.get(i + 1));
            zeichenketten.set(i + 1, temp);

        }
    }

    static String tauscheZeichen(String zeichenkette, char A, char B) {
        StringBuilder zeichentausch = new StringBuilder(zeichenkette);
        int len = zeichenkette.length();

        for (int i = 0; i < len; i++) {
            char temp = zeichentausch.charAt(i);
            if (zeichentausch.charAt(i) == A) {

                zeichentausch.setCharAt(i, B);

            }
            if (temp == B) {

                zeichentausch.setCharAt(i, A);

            }
        }

        return zeichentausch.toString();

    }

    public static String verschiebeBuchstaben(String zeichenkette, int wert) {
        int len = zeichenkette.length();
        StringBuilder g = new StringBuilder(zeichenkette);

        for (int i = 0; i < len; i++) {

            char ch1 = zeichenkette.charAt(i);

            int asciich1 = ch1;

            if (asciich1 >= 65 && asciich1 <= 90) {

                if ((asciich1 + wert) < 65) {
                    asciich1 += 26;
                }
                int asciich2 = (asciich1 + wert) % 65 + 65;
                char ch2 = (char) asciich2;

                g.setCharAt(i, ch2);

            } else if (asciich1 >= 97 && asciich1 <= 122) {

                if ((asciich1 + wert) < 97) {
                    asciich1 += 26;
                }
                int asciich2 = (asciich1 + wert) % 97 + 97;

                char ch2 = (char) asciich2;
                g.setCharAt(i, ch2);

            }
        }
        return g.toString();
    }
}
