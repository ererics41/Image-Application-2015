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

import com.jhlabs.image.BoxBlurFilter;
import com.jhlabs.image.FlipFilter;

public class Flip extends Filters 
{

	public Flip(String str,String des)
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
			if (img != null)
	        {
	    	    FlipFilter ff = new FlipFilter();
	    	    ff.setOperation(FlipFilter.FLIP_HV);
	    	    BufferedImage dest = new BufferedImage(img.getHeight(), img.getWidth(), BufferedImage.TYPE_INT_RGB);
	            ff.filter(img, dest);
	            img=dest;
	        }
			makeImage(img);
		}
	}
}