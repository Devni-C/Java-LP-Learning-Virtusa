import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriteFile {
	void fileWriter() throws IOException {
		FileWriter writeFile = new FileWriter("/home/devni/Desktop/Assignments/Java-LP-Learning-Virtusa/FileOperations/sample.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(writeFile);
		bufferedWriter.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cras sed felis eget velit. Id aliquet lectus proin nibh nisl condimentum id venenatis. Felis eget velit aliquet sagittis id. Proin sed libero enim sed. Sem viverra aliquet eget sit amet tellus cras adipiscing enim. Velit euismod in pellentesque massa placerat duis ultricies. Magnis dis parturient montes nascetur ridiculus mus mauris vitae. Nec dui nunc mattis enim ut tellus elementum sagittis. Viverra mauris in aliquam sem fringilla ut morbi. Sagittis aliquam malesuada bibendum arcu vitae elementum curabitur. Ac turpis egestas integer eget aliquet nibh praesent tristique magna.");
		bufferedWriter.close();
	}
}
