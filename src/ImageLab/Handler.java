package ImageLab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Handler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		Scaling.removeFrame();
		if(e.getSource() == Scaling.getB1())
			Reds.act();
		else if(e.getSource()==Scaling.getB2())
			Greens.act();
		else if(e.getSource() == Scaling.getB3())
			Blues.act();
		else if(e.getSource() == Scaling.getB4())
			PurpleScale.act();
		else if(e.getSource() == Scaling.getB5())
			Yellow.act();
		else if(e.getSource() == Scaling.getB6())
			Cyan.act();
	}
}
/*
 * this class is a random handler for a filter. It corresponds the the scaling class
 * because the scaling filter first creates a frame with several buttons to allow the 
 * user to select a color.  This class handles the button selection so that the appropiate
 * color is used.
 */