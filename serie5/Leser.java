package serie5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;

public class Leser {
    private String header;
    private BufferedReader leser;

    public Leser(String pfad) throws IOException {
        String[] file = pfad.split("\\.");
        String fullpath = System.getProperty("user.dir") + "/serie5/" + pfad;
        if (file.length == 3) {
            if ("gz".equals(file[2])) {
                this.leser = new BufferedReader(new InputStreamReader(
                        new GZIPInputStream(new FileInputStream(fullpath))));

            }

        } else {
            this.leser = new BufferedReader(new FileReader(fullpath));

        }

        this.header = leser.readLine();

    }

    public String getHeader() {
        return this.header;

    }

    public List<String> liestInhalt() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        boolean i = false;
        while (leser.ready()) {
            if (i == true) {
                result.add(leser.readLine());
            }
            i = true;
        }
        leser.close();
        return result;
    }
}
