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

public class Double extends Filters {


	public Double(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
	
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//icon = new ImageIcon(""+FileSelect.getFile(),"");
			BufferedImage img = new BufferedImage(
				    icon.getIconWidth()*2,
				    icon.getIconHeight(),
				    BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			// paint the Icon to the BufferedImage.
			icon.paintIcon(null, g, 0,0);
			icon.paintIcon(null,g,icon.getIconWidth(),0);
			
			g.dispose();
			
			makeImage(img);
		}
	}
}
