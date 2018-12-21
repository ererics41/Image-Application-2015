package ImageLab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu{
	JFrame frame;
	static JMenu filters;
	private JMenuItem open; 
	private JMenuItem save;
	public Menu() {
		frame = new JFrame("Image Processor");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel whiteLabel = new JLabel();
		whiteLabel.setOpaque(true);
		whiteLabel.setBackground(new Color(255, 255, 255));
		whiteLabel.setPreferredSize(new Dimension(200, 180));
		
		JMenuBar MenuBar = new JMenuBar();
        MenuBar.setOpaque(false);
        MenuBar.setPreferredSize(new Dimension(200, 20));
		
		frame.getContentPane().add(whiteLabel, BorderLayout.CENTER);
		frame.setJMenuBar(MenuBar);
		
		// creates the file menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_A);
		file.getAccessibleContext().setAccessibleDescription(
		        "Open an image to edit");
		MenuBar.add(file);
		
		// creates the open menu item in the file menu
		open = new JMenuItem("Open",
                KeyEvent.VK_T);
		open.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		open.getAccessibleContext().setAccessibleDescription(
"This opens an image");
		open.addActionListener(new handler());
		file.add(open);
		
		save = new JMenuItem("Save",
                KeyEvent.VK_2);
		save.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		save.getAccessibleContext().setAccessibleDescription(
"This saves an image");
		save.addActionListener(new handler());
		file.add(save);
		
		// creates the filters menu
		filters = new JMenu("Filters");
		filters.getAccessibleContext().setAccessibleDescription(
		        "Apply a filter to your image");
		MenuBar.add(filters);
		
		//Size the frame.
		frame.pack();

		//Show it.
		frame.setVisible(true);
	}
	
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==save){
				save(Filters.icon(),"JPG");
			}else if(e.getSource()==open){
				FileSelect file = new FileSelect();
				file.filePath();
				Filters.setIcon(new ImageIcon(""+file.getFile(),""));
				JLabel whiteLabel = new JLabel("",Filters.icon(),JLabel.CENTER);
				
				JFrame frame1 = new JFrame("Image");
				frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame1.getContentPane().add(whiteLabel, BorderLayout.CENTER);
				frame1.pack();
				frame1.setVisible(true);
				if(whiteLabel.getHeight()==0)
					frame1.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		}
	}
	private static void save(ImageIcon image, String ext) {
        String fileName = "Edited Image";
        BufferedImage img = new BufferedImage(
			    image.getIconWidth(),
			    image.getIconHeight(),
			    BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
		// paint the Icon to the BufferedImage.
		image.paintIcon(null, g, 0,0);
		g.dispose();
        File file = new File(fileName + "." + ext);
        try {
            ImageIO.write(img, ext, file);  // ignore returned boolean
        } catch(IOException e) {
            System.out.println("Write error for " + file.getPath() +
                               ": " + e.getMessage());
        }
    }
	public void addFilters(){
		/*Double d = new Double("Double","This filter doubles the image");
		GrayScale gs = new GrayScale("Gray Scale","This filter converts an image to black and white");
		Scaling c = new Scaling("Color Scale","This filter scales the image to an user defined color");
		ThreeD three = new ThreeD("3D","Adds a 3D effect");
		Noise n = new Noise("Add Noise","This adds a user defined amount of noise");
		Stretch s = new Stretch("Stretch","This stretches the image");
		Skew sk = new Skew("Skew","Skews an image a user definied amount");
		Shadow shadow = new Shadow("Shadow","Adds shadows to the image");
		Glare g = new Glare("Glare","This adds glare to an image");*/
		Blur blr = new Blur("Blur","This filter blurs the image");
	    GrayScale gs = new GrayScale("Gray Scale","This filter converts an image to black and white");
	    Flip f = new Flip ("Flip","This filter will flip the image");
	    Noise n = new Noise("Add Noise","This adds a user defined amount of noise");
	    Noise1 n1 = new Noise1("Noise","This filter will add noise to the image");
	    Chrome cf = new Chrome ("Chrome", " This filter simulate colors");
	    Mirror m = new Mirror ("Mirror", " This filter mirrors an image");
	    Water w = new Water ("Water", " This filter produces a water ripple effects on an image");
		Double d = new Double("Double","This filter doubles the image");
		Scaling c = new Scaling("Color Scale","This filter scales the image to an user defined color");
		ThreeD three = new ThreeD("3D","Adds a 3D effect");
		Stretch s = new Stretch("Stretch","This stretches the image");
		Shadow shadow = new Shadow("Shadow","Adds shadows to the image");
		Glare g = new Glare("Glare","This adds glare to an image");
		Skew sk = new Skew("Skew","Skews an image a user definied amount");
	}
}
/*
 * This class is the heart of the program.  It creates the UI of the program 
 * using by creating GUI objects and displaying them on a frame.  A JMenuBar object 
 * is created and the JMenu items file and filters are created.  These are then added 
 * to the menu bar.  JMenuItems are added to these menus, Menu's constructor adds the 
 * Menu items open and save and adds handlers to respond to actions performed on these items.
 * Save will write a file called EditedImage.JPG and open will call the fileselect method 
 * filepath which gets the filepath of the user selected image using JFileChooser.
 * The addFilters method calls creates an object of every filter and thus calls the constructor.
*/
