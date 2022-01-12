package serie5;

import java.io.IOException;
import java.util.List;
import java.io.Writer;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Leser leser = new Leser("trag1igkel.txt.gz");

        if ("serie5 encryption".equals(leser.getHeader())) {

            List<String> inhalt = leser.liestInhalt();

            Verschluesselung.tauscheZeilen(inhalt);
            try (Writer fileWriter = new FileWriter("AuszuegeGG.txt")) {
                for (int i = 0; i < inhalt.size(); i++) {
                    inhalt.set(i, Verschluesselung.verschiebeBuchstaben(inhalt.get(i), -13));
                    inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), 'r', 'g'));
                    inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), 'a', 't'));
                    inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), ')', '('));
                    inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), ',', '.'));

                    fileWriter.write(inhalt.get(i));

                }

                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Fehler beim Erstellen der Datei 'AuszuegeGG'.");
                e.printStackTrace();
                System.exit(0);
            }
        } else {
            System.err.println("Header stimmt nicht mit Erwartungen überein.");

        }

    }

}
