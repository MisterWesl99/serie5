package serie5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Leser {
    private String header;
    private BufferedReader leser;

    public Leser(String pfad) {
        String[] file = pfad.split("\\.");
        String fullpath = System.getProperty("user.dir") + "/serie5/" + pfad;
        if (file.length == 3) {
            if ("gz".equals(file[2])) {
                try {
                    this.leser = new BufferedReader(new InputStreamReader(
                            new GZIPInputStream(new FileInputStream(fullpath))));
                } catch (FileNotFoundException e) {
                    System.out.println("Fehler beim Laden der Datei.");
                    e.printStackTrace();
                    System.exit(0);
                } catch (IOException e) {
                    System.out.println("Fehler beim Laden der Datei.");
                    e.printStackTrace();
                    System.exit(0);
                }

            }

        } else {
            try {
                this.leser = new BufferedReader(new FileReader(fullpath));
            } catch (FileNotFoundException e) {
                System.out.println("Fehler beim Laden der Datei.");
                e.printStackTrace();
                System.exit(0);
            }

        }

        try {
            this.header = leser.readLine();
        } catch (IOException e) {
            System.out.println("Fehler beim Laden des Headers.");
            e.printStackTrace();
            System.exit(0);
        }

    }

    public String getHeader() {
        return this.header;

    }

    public List<String> liestInhalt() {
        ArrayList<String> result = new ArrayList<>();
        boolean i = false;
        try {
            while (leser.ready()) {
                if (i) {
                    result.add(leser.readLine());
                }
                i = true;
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei.");
            e.printStackTrace();
            System.exit(0);
        }
        try {
            leser.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Schlie??en der Datei.");
            e.printStackTrace();
            System.exit(0);
        }
        return result;
    }
}
