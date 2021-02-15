import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import acm.program.Program;

public class Diff extends Program {
	int X = 45;
	int Y = 50;

	File f = new File("files");
	File[] fA = f.listFiles();

	JPanel PANEL = new JPanel();

	JTextArea LEFT_TEXT = new JTextArea(X, Y);
	JTextArea RIGHT_TEXT = new JTextArea(X, Y);

	JScrollPane S_VERTIKAL = new JScrollPane(LEFT_TEXT);
	JScrollPane S_HORIZONTAL = new JScrollPane(RIGHT_TEXT);
	// Dateiauswahl
	JComboBox<String> COMBO = new JComboBox<String>(umformen());
	JComboBox<String> COMBO_2 = new JComboBox<String>(umformen());

	public void init() {
		setup();
		// JcomboBox Item Listener
		// lesenA("files/jessica.cpp", LEFT_TEXT);

		// Quelle: https://kodejava.org/how-do-i-add-an-action-listener-to-jcombobox/
		COMBO.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				JComboBox COMBO = (JComboBox) event.getSource();

				String selected = (String) COMBO.getSelectedItem();
				System.out.println("Selected: " + selected);

				// Rick Shaffer BME2
				for (int i = 0; i < fA.length; i++) {
					if (selected.equals(fA[i].toString())) {
						lesenA(fA[i].getName(), LEFT_TEXT);

					}

				}

			}

		});
		COMBO_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				JComboBox COMBO = (JComboBox) event.getSource();

				String selected = (String) COMBO.getSelectedItem();
				System.out.println("Selected: " + selected);

				// Rick Shaffer BME2
				for (int i = 0; i < fA.length; i++) {
					if (selected.equals(fA[i].toString())) {
						lesenA(fA[i].getName(), RIGHT_TEXT);

					}

				}

			}

		});

	}

	public void setup() {

		PANEL.setBackground(Color.DARK_GRAY);
		setSize(1280, 800);
		add(PANEL, CENTER);
		PANEL.add(S_VERTIKAL);
		PANEL.add(S_HORIZONTAL);
		add(COMBO, NORTH);
		add(COMBO_2, NORTH);
	}

	public void lesenA(String file, JTextArea area) {
		// Quellen: Q1, Q2, Q3, "ReadFromFile" aus Lab B: Preparation for Assignment A
		try {

			FileReader fr = new FileReader("files/" + file);
			BufferedReader rd = new BufferedReader(fr);
			String text = "";
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				text += line + "\n";

			}
			area.setText(text);
			// close file
			rd.close();
			fr.close();

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Rick Shaffer BME 2
	private String[] umformen() {
		String[] umform = new String[fA.length];

		for (int i = 0; i < fA.length; i++) {
			umform[i] = fA[i].toString();
		}
		return umform;
	}
}
