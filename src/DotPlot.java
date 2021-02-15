
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

public class DotPlot extends GraphicsProgram {
	private final int BLOCK_SIZE = 1;

	private List<ArrayList<String>> programme = new ArrayList<ArrayList<String>>();

	public void run() {
		setSize(800, 800);

		IODialog dialog = new IODialog();

		String input1 = dialog.readLine("Enter name of First file: ");
		String input2 = dialog.readLine("Enter name of Second file: ");
		String file1 = "";
		String file2 = "";

		File f = new File("files");
		File[] fA = f.listFiles();

		for (int i = 0; i < fA.length; i++) {
			programme.add(new ArrayList<String>());
			inListeSpeichern(fA[i], programme.get(i));
			if (input1.equals(fA[i].toString())) {
				file1 += programme.get(i).toString();
			}
			if (input2.equals(fA[i].toString())) {
				file2 += programme.get(i).toString();
			}
		}
		showSimilarity(removeWhiteSpace(file1), removeWhiteSpace(file2));
	}

	// Quelle Ralph Lano
	private void showSimilarity(String file1, String file2) {
		for (int i = 0; i < file1.length(); i++) {
			for (int j = 0; j < file2.length(); j++) {
				if (file1.charAt(i) == file2.charAt(j)) {
					GRect pixel = new GRect(BLOCK_SIZE, BLOCK_SIZE);
					pixel.setFilled(true);
					add(pixel, i * BLOCK_SIZE, j * BLOCK_SIZE);
				}
			}
		}

	}

	// Quelle Ralph Lano
	private String removeWhiteSpace(String s) {
		s = s.replaceAll(" ", "");
		s = s.replaceAll("\n", "");
		s = s.replaceAll("\t", "");
		return s;
	}

	public void inListeSpeichern(File file, List<String> list) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}

		} catch (IOException e) {
			println("File not found!");
			e.printStackTrace();
		}
	}

}