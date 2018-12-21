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
import javax.swing.JOptionPane;

public class RedShadow extends Filters {

	public RedShadow(String str,String des)
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
		BufferedImage im = new BufferedImage(
				   icon.getIconWidth(),
				   icon.getIconHeight(),
				   BufferedImage.TYPE_INT_RGB);
		int num = userInput();
			
		for(int i = 0; i <img.getWidth();i++){
			for(int j = 0;j < img.getHeight();j++){
				Color c = new Color(img.getRGB(i,j), true);
				Color cR = c;
				if((num<=0 && i>(-img.getWidth()/100*num))||(num>0 && i<(img.getWidth()*(100-num)/100)))
					cR = new Color(img.getRGB(i+(img.getWidth()/100*num),j),true);
			    Color c1 = new Color(cR.getRed(),c.getGreen(),c.getBlue());
			    im.setRGB(i,j,c1.getRGB());
			}
		}
		makeImage(im);
	}
	public static int userInput(){
		int num = 50;
		try{
			String answer = JOptionPane.showInputDialog("Enter shadow length");
			num = Integer.parseInt(answer);
		}catch(NumberFormatException e){
			userInput();
		}
		if(num>5)
			num = 5;
		if(num<-5)
			num = -5;
		return num;
	}
}