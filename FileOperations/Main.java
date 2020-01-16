import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			WriteFile writeFile = new WriteFile();
			writeFile.fileWriter();

			ReadFile readFile = new ReadFile();
			readFile.writeToUppercaseFile();
		} catch (IOException e) {
			e.getMessage();
		}

		
	}
}
