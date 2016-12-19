//asheq
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Frame extends JFrame 
{

	private static final long serialVersionUID = 1L;
	Container container; //THE container
	Panel panel;

    public Frame() 
    {
    	setTitle("Journal");
    	setResizable(false);
    	
    	setSize(new Dimension(800,400));
    	
    	//container holds each panel
    	container = getContentPane();
      panel = new Panel(this);
      container.add(panel, BorderLayout.NORTH);
    	
    	pack();
    	repaint();
    }
   
   	public void launch()
   	{

   	} 
	
}