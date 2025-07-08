import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registrador {

    private static final String FILENAME = "registro.txt";
    private static final SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void log(String message) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(FILENAME, true);
            pw = new PrintWriter(fw);

            String timestamp = dtf.format(new Date());
            pw.println(timestamp + " - " + message);

        } catch (IOException e) {
            System.out.println("Error: No se pudo escribir en el archivo de registro.");
        } finally {
            try {
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
            }
        }
    }
}