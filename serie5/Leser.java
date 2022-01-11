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

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }

        } else {
            try {
                this.leser = new BufferedReader(new FileReader(fullpath));
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }

        }

        try {
            this.header = leser.readLine();
        } catch (IOException e) {

            e.printStackTrace();
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
                if (i == true) {
                    result.add(leser.readLine());
                }
                i = true;
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            leser.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return result;
    }
}
