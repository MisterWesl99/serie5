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
        // System.out.println(zeichenkette);
        for (int i = 0; i < len; i++) {
            char temp = zeichentausch.charAt(i);
            if (zeichentausch.charAt(i) == A) {
                // System.out.println(i);
                // System.out.println(zeichentausch.charAt(i));
                zeichentausch.setCharAt(i, B);
                // System.out.println(zeichentausch.charAt(i));
            }
            if (temp == B) {
                // System.out.println(i);
                // System.out.println(zeichentausch.charAt(i));
                zeichentausch.setCharAt(i, A);
                // System.out.println(zeichentausch.charAt(i));
            }
        }

        return zeichentausch.toString();

    }

    public static String verschiebeBuchstaben(String zeichenkette, int wert) {
        int len = zeichenkette.length();
        StringBuilder g = new StringBuilder(zeichenkette);

        for (int i = 0; i < len; i++) {

            char ch1 = zeichenkette.charAt(i);
            System.out.println(ch1);
            int asciich1 = ch1;
            // System.out.println(asciich1);
            // System.out.println(asciich1);

            if (asciich1 >= 65 && asciich1 <= 90) {
                System.out.println(asciich1);
                if ((asciich1 + wert) < 65) {
                    asciich1 += 26;
                }
                int asciich2 = (asciich1 + wert) % 65 + 65;
                if (asciich2 < 65) {
                    asciich2 += 64;
                }
                char ch2 = (char) asciich2;
                // System.out.println(asciich2);

                g.setCharAt(i, ch2);
                System.out.println(g.charAt(i));
                System.out.println(asciich2);
            }
            if (asciich1 >= 97 && asciich1 <= 122) {
                // System.out.println(g.charAt(i));
                if ((asciich1 + wert) < 97) {
                    asciich1 += 26;
                }
                int asciich2 = (asciich1 + wert) % 97 + 97;
                char ch2 = (char) asciich2;
                g.setCharAt(i, ch2);
                System.out.println(g.charAt(i));
                System.out.println(asciich2);
            }
        }
        return g.toString();
    }
}
