import java.io.*;

public class ReadFile extends BufferedReader{
	void writeToUppercaseFile(char ch) throws IOException {
		char upperCh = ch;
		try {
			FileWriter writeFile = new FileWriter("/home/devni/Desktop/Assignments/Java-LP-Learning-Virtusa/FileOperations/uppercasedFile.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writeFile);
			bufferedWriter.write(upperCh);
		} catch (IOException e) {
			e.getMessage();
		}

		
	}

	public ReadFile(Reader in) {
		super(in);
	}

	public int read() throws IOException {
		int i = super.read();
		if(i >= 65 || i <= 97) {
			i = i-32;	
			writeToUppercaseFile((char)i);		
		} else {
			writeToUppercaseFile((char)i);
		}
		return i;
	}
}
