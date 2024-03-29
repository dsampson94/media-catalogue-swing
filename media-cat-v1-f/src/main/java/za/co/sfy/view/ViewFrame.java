package za.co.sfy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel framePanel;
	
	public static void main(String[] args) {
		new ViewFrame().createAndShowGUI();
	}

    public void createAndShowGUI() {
        this.setTitle("Media Catalogue");
        framePanel = new JPanel();
        framePanel.setBackground(Color.WHITE);
        framePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        framePanel.setLayout(new BorderLayout());
        this.add(framePanel);
        putPanel(new HomePanel(this));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setSize(1000, 600);
        this.setVisible(true);
    }
    
    public void putPanel(Component component) {
        Component[] components = framePanel.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                framePanel.removeAll();
            }
        }
        framePanel.add(component, BorderLayout.CENTER);
        framePanel.validate();
        framePanel.repaint();
    }
}
