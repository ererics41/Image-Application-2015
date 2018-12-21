package ImageLab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.IndexColorModel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class PurpleScale extends Filters {

	public PurpleScale(String str,String des)
	{
		super(str,des);
	}
		
	public static void act(){
		BufferedImage img = new BufferedImage(
				   icon.getIconWidth(),
				   icon.getIconHeight(),
				   BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
			// paint the Icon to the BufferedImage.
		icon.paintIcon(null, g, 0,0);
		g.dispose();
			
		for(int i = 0; i <img.getWidth();i++){
			for(int j = 0;j < img.getHeight();j++){
				Color c = new Color(img.getRGB(i,j), true);
				int avg = (c.getRed()+c.getBlue())/2;
			    Color c1 = new Color(avg,0,avg);
			    img.setRGB(i,j,c1.getRGB());
			}
		}
		makeImage(img);
	}
}
	
	
	
	
	
	
	
	