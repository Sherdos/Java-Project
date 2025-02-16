import java.io.*;

public class Main {
    public static void main(String... args) {
        encrypt(12);
    }

    public static String encrypt(int shift) {
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        return line;
    }
}

