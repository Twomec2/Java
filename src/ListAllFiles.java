
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;

public class ListAllFiles extends ConsoleProgram {
	// die Daten werden in einem Array gespeichert
	File f = new File("files");
	File[] fA = f.listFiles();

	public void run() {
		setSize(800, 800);
		setFont("Times New Roman-bold-18");

		ordnerZeigen();
		println("|" + "\n" + "|" + "\n" + "|");
		lesenA();

	}

	// Q: https://www.geeksforgeeks.org/file-getname-method-in-java-with-examples/
	public void ordnerZeigen() {

		if (fA != null) {
			for (int i = 0; i < fA.length; i++) {
				println(i + ": " + fA[i].getName());
				/*
				 * if (fA[i].isDirectory()) { println(fA); } else { println(fA); }
				 */
			}
		}
	}

// Q : https://www.guru99.com/buffered-reader-in-java.html
// Q : https://wiki.byte-welt.net/wiki/Verzeichnisse_durchsuchen/bearbeiten/auslesen_(Java)
// Q : Variationen zum Thema Algorithmen
	public void lesenA() {

		try {

			for (int i = 0; i < fA.length; i++) {
				// open file
				FileReader fr = new FileReader(fA[i]);
				BufferedReader rd = new BufferedReader(new FileReader(fA[i]));

				// read from file, line by line
				while (true) {
					String line = rd.readLine();
					if (line == null)
						break;
					println(line);
				}

				// close file
				rd.close();
				fr.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
