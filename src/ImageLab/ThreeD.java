package ImageLab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ThreeD extends Filters {

	public ThreeD(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
	
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//icon = new ImageIcon(""+FileSelect.getFile(),"");
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
			for(int i = 0; i <img.getWidth();i++){
				for(int j = 0;j < img.getHeight();j++){
					Color c = new Color(img.getRGB(i,j), true);
					Color cR= c;
					Color cB= c;
					if(i<img.getWidth()/20*19)
					{
						cB = new Color(img.getRGB(i+img.getWidth()/20, j),true);
						//System.out.println("B"+(i+img.getWidth()/20));
					}
					if(i>img.getWidth()/20)
					{

						cR = new Color(img.getRGB(i-img.getWidth()/20,j),true);
						//System.out.println("r"+(i-img.getWidth()/20));
					}
					Color c1 = new Color(cR.getRed(),c.getGreen(),cB.getBlue());
				   	im.setRGB(i,j,c1.getRGB());
				}
				/*
				System.out.print("*********  " + i + "    " + img.getWidth()/20);
				System.out.println("*********  " + (i-img.getWidth()/20));*/
			}
			makeImage(im);
		}
	}
}
