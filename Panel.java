//asheq
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

class Panel extends JPanel
{
	Frame frame;
	
	public Panel(Frame f)
	{
		frame = f;	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(new Color(40,40,40));
		g.fillRect(10, 10, 200, 390);
		
		
	}
}
