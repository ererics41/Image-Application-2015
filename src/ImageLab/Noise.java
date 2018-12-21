package ImageLab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

import javax.swing.JOptionPane;


public class Noise extends Filters {

	public Noise(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
		
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		int num = userInput();
		SecureRandom ran = new SecureRandom();
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
				int random = ran.nextInt(101);
				if(random<=num){
					Color col = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
					img.setRGB(i,j,col.getRGB());
				}else{
					Color c = new Color(img.getRGB(i,j), true);
					Color c1 = new Color(c.getRed(),c.getGreen(),c.getBlue());
					img.setRGB(i,j,c1.getRGB());
				}
			}
		}
		makeImage(img);
	}
	}
	
	public static int userInput(){
		int num = 50;
		try{
			String answer = JOptionPane.showInputDialog("Enter desired amount of noise");
			num = Integer.parseInt(answer);
		}catch(NumberFormatException e){
			userInput();
		}
		return num;
	}
}