package ImageLab;
//import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.*;

public class Filters extends JMenuItem {
	public static JMenuItem fil;
	protected static ImageIcon icon;
	
	public Filters(String str){
		super(str);
	}
	public static void setIcon(ImageIcon i){
		icon = i;
	}
	public static ImageIcon icon(){
		return icon;
	}
	public Filters(String str,String des)
	{
		fil = new JMenuItem(str);
		fil.getAccessibleContext().setAccessibleDescription(
				des);
		fil.getAccessibleContext().setAccessibleName(
				str);
		Menu.filters.add(fil);
	}
	
	public static int[][] getRGB(BufferedImage img){
		int [][] arr = new int[img.getWidth()][img.getHeight()];

		for(int i = 0; i < img.getWidth(); i++)
		    for(int j = 0; j < img.getHeight(); j++)
		        arr[i][j] = img.getRGB(i, j);
		return arr;
	}
	
	public static void makeImage(BufferedImage img){
		icon = new ImageIcon(img);
		JLabel L1 = new JLabel("",icon,JLabel.CENTER);
		JFrame frame1 = new JFrame("Image");
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.getContentPane().add(L1, BorderLayout.WEST);
		frame1.pack();
		frame1.setVisible(true);
	}
}
/*
 * All filter classes inherit this class and follow a pattern, so I will 
 * explain this class for all filter classes. A few special filter classes 
 * will create additional GUI windows to allow for user input. All filter classes
 * call the constructor of the Fitlers class which creates a JMenuItem in the 
 * Filters menu based on the two strings passed as parameters.  All constructors of 
 * subclasses of filter will then add a actionlistener and have a unique handler. The
 * handler of every filter will take the image, process it through for loops, iterating 
 * though every pixel and changing it according to some patter and then calls the
 * method makeImage() from this class.  This method takes the edited buffered image 
 * after it has been processed through a for loop and creates a frame with that a label
 * of that is the edited image.  The variable icon in this class is also set to the edited
 * image so for the case where a user wants to apply several filters on the same image.
 */
