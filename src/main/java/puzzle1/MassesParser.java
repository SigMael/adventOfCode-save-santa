package puzzle1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MassesParser {

	public ArrayList<Mass> parse(File inputFile) throws IOException {
		try {
			if (inputFile.exists()) {
				return readLines(inputFile);
			}
		} catch (IOException e) {
			throw e;
		}
		return null;
	}

	private ArrayList<Mass> readLines(File inputFile) throws IOException {
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(inputFile))) {
			return getLines(bufferReader);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private ArrayList<Mass> getLines(BufferedReader bufferReader) throws IOException {
		ArrayList<Mass> masses = new ArrayList<>();
		while (bufferReader.ready()) {
			masses.add(createNewMass(bufferReader));
		}
		return masses;
	}

	private Mass createNewMass(BufferedReader bufferReader) throws IOException {
		return new Mass(Integer.parseInt(bufferReader.readLine()));
	}
}
