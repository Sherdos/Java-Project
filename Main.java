import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String... args) {
        Scanner text = new Scanner(System.in);
	System.out.println("1 - Caesar, 2 - Vigener");
	System.out.print("Choose the cipher for enscrypt/descrypt text - ");
	int mode = text.nextInt();
	text.nextLine();
        try (
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String line = null;
	    if (mode == 1){
		System.out.print("Enter shifting for enscrypt/descrypt - ");
        	int shift = text.nextInt();
        	text.nextLine();
		System.out.println("Programm starting ...");
        	while ((line = br.readLine()) != null) {
		        bw.write(ceasarEncrypt(shift, line));
			bw.newLine();
            	}
	    }else if (mode == 2){
		System.out.print("Enter key for enscrypt/descrypt - ");
                String key = text.nextLine();
                System.out.print("Choose the mode 1 - encrypt, 2 - decrypt - ");
                int mode2 = text.nextInt();
                text.nextLine();
		System.out.println("Programm starting ...");
		while ((line = br.readLine()) != null) {
		        bw.write(vigenerEncrypt(key, line,mode2));
			bw.newLine();
            	}
    	    }
    	    else {
    	    	System.out.println("Bad choose")
    	    }
	    System.out.println("Programm finished all result safe on output.txt");
	    br.close();
	    bw.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public static String vigenerEncrypt(String key, String text, int mode){
    	StringBuilder result = new StringBuilder();
	for (int i = 0; i < text.length(); i++){
		char ch = text.charAt(i);
		char kch = key.charAt(i%key.length());
		if (Character.isLetter(ch)){
			char base = Character.isLowerCase(ch) ? 'a':'A';
			if (mode == 1) {
				ch = (char) (((ch - base)+(kch-base)) % 26 + base);
			}else if (mode == 2) {
				ch = (char) (((ch - base)-(kch-base)+26) % 26 + base);
			}
			else {
    	    			System.out.println("Bad choose")
    	    		}
		}
		result.append(ch);
	}
	return result.toString();
    }
    public static String ceasarEncrypt(int shift, String text){
	StringBuilder result = new StringBuilder();
	for (int i = 0; i < text.length(); i++){
		char ch = text.charAt(i);
		if (Character.isLetter(ch)){
			char base = Character.isLowerCase(ch) ? 'a':'A';
			ch = (char) ((ch - base + shift) % 26 + base);
		}
		result.append(ch);
	}
	return result.toString();
    }
}

