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

    private BufferedReader leser;
    private String header;

    public Leser(String pfad) throws FileNotFoundException, IOException{
        String[] file = pfad.split(".");
        if (file.length == 3) {
            if (file[2] == "gz") {
                boolean zip = true;
                leser = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(pfad))));
                this.header = leser.readLine();
            }
        } else {
            leser = new BufferedReader(new FileReader(pfad));
        }

        this.header = leser.readLine();
    }
    
    public String getHeader(){
        return header;
        
    }

    public List<String> liesInhalt() throws IOException {
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
