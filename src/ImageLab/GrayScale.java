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

public class GrayScale extends Filters {

	public GrayScale(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
	
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
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
					int num = average(c.getRed(),c.getGreen(),c.getBlue());
				    Color c1 = new Color(num,num,num);
				    img.setRGB(i,j,c1.getRGB());
				}
			}
			makeImage(img);
		}
	}
	private int max(int i,int j, int k){
		int max = 1;
		if(j>i)
			max=j;
		if(k>max)
			max=k;
		return max;
	}
	private int average(int i,int j, int k){
		
		return (i+j+k)/3;
	}
	private int min(int i,int j, int k){
		int min = 1;
		if(j<i)
			min=j;
		if(k<min)
			min=k;
		return min;
	}
}
