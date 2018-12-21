package ImageLab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Stretch extends Filters {


	public Stretch (String str,String des)
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
				    icon.getIconWidth()*2,
				    icon.getIconHeight(),
				    BufferedImage.TYPE_INT_RGB);
			for(int i = 0; i <img.getWidth()*2;i++){
				for(int j = 0;j < img.getHeight();j++){
					Color c = new Color(img.getRGB(i/2,j), true);
				    Color c1 = new Color(c.getRed(),c.getGreen(),c.getBlue());
				    im.setRGB(i,j,c1.getRGB());
				    im.setRGB(i+1,j,c1.getRGB());
				}
				i++;
			}
			
			makeImage(im);
		}
	}
	
}
