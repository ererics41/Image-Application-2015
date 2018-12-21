package ImageLab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

import javax.swing.JOptionPane;


public class Skew extends Filters {

	public Skew(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
		
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		int num = userInput();
		double rad = num*Math.PI/180;
		BufferedImage img = new BufferedImage(
				   icon.getIconWidth(),
				   icon.getIconHeight(),
				   BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
			// paint the Icon to the BufferedImage.
		icon.paintIcon(null, g, 0,0);
		g.dispose();
		double scale = Math.tan(rad);
		BufferedImage im = new BufferedImage(
				   icon.getIconWidth()+(int)(icon.getIconHeight()*scale)+1,
				   icon.getIconHeight(),
				   BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i <img.getWidth();i++){
			for(int j = 0;j < img.getHeight();j++){
				Color c = new Color(img.getRGB(i,j), true);
				Color c1 = new Color(c.getRed(),c.getGreen(),c.getBlue());
				im.setRGB(i+(int)((img.getHeight()-j)*scale),j,c1.getRGB());
			}
		}
		makeImage(im);
	}
	}
	
	public static int userInput(){
		int num = 0;
		try{
			String answer = JOptionPane.showInputDialog("Enter angle of bottom left corner");
			num = Integer.parseInt(answer);
		}catch(NumberFormatException e){
			userInput();
		}
		if(num>85)
			num = 85;
		if(num<5)
			num = 5;
		return num;
	}
}