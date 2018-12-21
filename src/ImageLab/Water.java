 package ImageLab;
 import com.jhlabs.image.*;
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
import com.jhlabs.image.ChromeFilter;

public class Water extends Filters 
{
		public Water(String str,String des)
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
		    	    WaterFilter w = new WaterFilter();
		    	    BufferedImage dest = img; //copy constructor
		            w.filter(img, dest);
		            img=dest;
		        }
				makeImage(img);
			}
		}
	}     