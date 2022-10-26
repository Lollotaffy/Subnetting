package utilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;

/**
 * Classe che implementa dei metodi statici per salvare i file di testo in locale
 * @author Lorenzo Tafuro
 * @version 1.2
 */
public class FileBuffered {

	/**
	 * metodo statico che scrive un file di testo in una directory scelta dall'utente, mediante un array di stringhe
	 * @param data
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void fileWriter(String[] data) throws FileNotFoundException, IOException {
		
		String fileName = "";
		String extCheck = "";
		JFileChooser chooser = new JFileChooser();
		int response = chooser.showSaveDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			fileName = chooser.getSelectedFile().toString();
		}
		
		for (int i = (fileName.length() - 4); i < fileName.length(); i++) {
			extCheck += fileName.charAt(i);
		}
		
		if (extCheck.equals(".txt") == false) {
			fileName += ".txt";
		}
		
		System.out.println(fileName);
		
		File file = new File(fileName);
		
		 FileOutputStream fos = new FileOutputStream(file); 
		 try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
			for(String s1 : data) {
				 bw.write(s1);
		}
	}
	}
}
