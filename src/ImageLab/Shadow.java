package ImageLab;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Shadow extends Filters {
	private static JButton B1;
	private static JButton B2;
	private static JButton B3;
	private static JFrame frame;

	public Shadow(String str,String des)
	{
		super(str,des);
		fil.addActionListener(new handler());
	}
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==B1){
				removeFrame();
				RedShadow.act();
			}else if(e.getSource()==B2){
				removeFrame();
				GreenShadow.act();
			}else if(e.getSource() == B3){
				removeFrame();
				BlueShadow.act();
			}else{
				frame = new JFrame("Color Select");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				GridLayout grid = new GridLayout(3,1);
			
				B1 =  new JButton("Red Shadow");
				B1.addActionListener(new handler());
				B2 =  new JButton("Green Shadow");
				B2.addActionListener(new handler());
				B3 =  new JButton("Blue Shadow");
				B3.addActionListener(new handler());
			
			
				JPanel pan = new JPanel(grid);
				pan.add(B1);
				pan.add(B2);
				pan.add(B3);
			
			
				JLabel L1 = new JLabel("Select the color you want the shadow to be");
			
				frame.setLayout(grid);
				frame.getContentPane().add(L1);
				frame.add(pan);
				frame.pack();
				frame.setVisible(true);
			}
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
}