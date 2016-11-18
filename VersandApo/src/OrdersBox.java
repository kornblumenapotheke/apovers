import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OrdersBox extends JPanel{
	
	OrdersBox ()
	{
		this.setLayout(new GridLayout(0,2));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		add (new JButton ("<html><bold>Psilibum Bimbum</bold> x2</html>"));
		setVisible(true);
	}
	
	
	

}
