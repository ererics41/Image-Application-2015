package ImageLab;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scaling extends Filters {
	private static JButton B1;
	private static JButton B2;
	private static JButton B3;
	private static JButton B4;
	private static JButton B5;
	private static JButton B6;
	private static JFrame frame;

	public Scaling(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame = new JFrame("Color Select");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			GridLayout grid = new GridLayout(6,1);
			
			B1 =  new JButton("Red");
			B1.addActionListener(new Handler());
			B2 =  new JButton("Green");
			B2.addActionListener(new Handler());
			B3 =  new JButton("Blue");
			B3.addActionListener(new Handler());
			B4 =  new JButton("Purple");
			B4.addActionListener(new Handler());
			B5 =  new JButton("Yellow");
			B5.addActionListener(new Handler());
			B6 =  new JButton("Cyan");
			B6.addActionListener(new Handler());
			
			
			JPanel pan = new JPanel(grid);
			pan.add(B1);
			pan.add(B2);
			pan.add(B3);
			pan.add(B4);
			pan.add(B5);
			pan.add(B6);
			
			JLabel L1 = new JLabel("Select the color you want your image to be scaled to");
			
			frame.setLayout(grid);
			frame.getContentPane().add(L1);
			frame.add(pan);
			frame.pack();
			frame.setVisible(true);
		}
	}
	public static void removeFrame(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	public static JButton getB1(){
		return B1;
	}
	public static JButton getB2(){
		return B2;
	}
	public static JButton getB3(){
		return B3;
	}
	public static JButton getB4(){
		return B4;
	}
	public static JButton getB5(){
		return B5;
	}
	public static JButton getB6(){
		return B6;
	}
}