package serie5;

import java.io.IOException;
import java.util.List;
import java.io.Writer;
import java.io.FileWriter;

//known error: verschiebe Buchstaben evtl. Fehler mit negativ Wert und tausche Zeichen hat kein Einlfuss auf Output
public class Main {
    public static void main(String[] args) throws IOException {
        Leser leser = new Leser("trag1igkel.txt.gz");

        if ("serie5 encryption".equals(leser.getHeader())) {

            List<String> inhalt = leser.liestInhalt();

            Verschluesselung.tauscheZeilen(inhalt);
            Writer fileWriter = new FileWriter("AuszuegeGG.txt");
            for (int i = 0; i < inhalt.size(); i++) {
                inhalt.set(i, Verschluesselung.verschiebeBuchstaben(inhalt.get(i), -13));
                inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), 'r', 'g'));
                inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), 'a', 't'));
                inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), ')', '('));
                inhalt.set(i, Verschluesselung.tauscheZeichen(inhalt.get(i), ',', '.'));

                fileWriter.write(inhalt.get(i));

                // System.out.println(inhalt.get(i));
            }

            fileWriter.close();
        } else {
            System.out.println('f');
            // add system.err

        }
        System.out.println("done");
    }

}
