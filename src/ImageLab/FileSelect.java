package ImageLab;
import java.io.File;

import javax.swing.JFileChooser;

public class FileSelect {
	private static File file;
	
	public void filePath(){
		JFileChooser jfc = new JFileChooser();
	    jfc.showDialog(null,"Select");
	    jfc.setVisible(true);
	    File filename = jfc.getSelectedFile();
	    file = filename;
	}
	
	public static File getFile(){
		return file;
	}
	
}
/*
 * This class holds the private variable file, it has the method filePath which
 * creates a JFilerChooser object and allows the user to select an image file to
 * edit. The method getFile() returns the file variable. 
*/
