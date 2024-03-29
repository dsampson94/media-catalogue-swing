package za.co.sfy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class CenterCatalogueHome extends JPanel {

	private static final long serialVersionUID = -703374646384173633L;
	private ViewFrame viewFrame;
	String messageReturned;

	public CenterCatalogueHome(ViewFrame v, String message) {
		this.viewFrame = v;
		this.messageReturned = message;
		initComponents();
	}
	
	public CenterCatalogueHome(ViewFrame v) { 
		this.viewFrame = v;
		initComponents();
	}

	public void initComponents() {
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel topLabel = new JLabel("Catalogue");
		JSeparator js1 = new JSeparator();
		js1.setPreferredSize(new Dimension(400, 5));
		JSeparator js2 = new JSeparator();
		js2.setPreferredSize(new Dimension(400, 5));

		JRadioButton dvdRadio = new JRadioButton("DVD");
		dvdRadio.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	viewFrame.putPanel(new AddDVDPanel(viewFrame));
	        }
	    });
		JRadioButton cdRadio = new JRadioButton("CD");
		cdRadio.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	viewFrame.putPanel(new AddCDPanel(viewFrame));
	        }
	    });
		ButtonGroup bg = new ButtonGroup();
		bg.add(cdRadio);
		bg.add(dvdRadio);

		JPanel gridBox = new JPanel(new BorderLayout());
		JPanel grid = new JPanel(new GridLayout(2, 1));
		grid.setBackground(Color.white);
		grid.setPreferredSize(new Dimension(50, 50));
		JPanel top = new JPanel();
		JLabel jl = new JLabel("Add Item");
		top.setBackground(Color.gray.brighter());
		top.add(jl);
		gridBox.add(top, BorderLayout.NORTH);
		grid.add(cdRadio);
		grid.add(dvdRadio);
		gridBox.add(grid, BorderLayout.CENTER);

		JPanel addBox = new JPanel(new BorderLayout());
		JPanel addGrid = new JPanel(new BorderLayout());
		addGrid.setPreferredSize(new Dimension(50, 0));
		JPanel addTop = new JPanel();
		JLabel addjl = new JLabel("Add Item");
		addTop.setBackground(Color.gray.brighter());
		addGrid.setBackground(Color.white);
		addBox.setBackground(Color.white);
		addBox.setPreferredSize(new Dimension(300, 30));
		addTop.add(addjl);
		addBox.add(addTop, BorderLayout.NORTH);
		addBox.add(addGrid, BorderLayout.CENTER);
		if(getMessageReturned() != null) {
			JLabel res = new JLabel(getMessageReturned());
			addBox.add(res);
			res.setHorizontalAlignment(JLabel.CENTER);
		}

		JButton deleteBut = new JButton("Delete Item");
		deleteBut.setPreferredSize(new Dimension(100, 25));
		deleteBut.setForeground(Color.white);
		deleteBut.setBackground(Color.green.darker());
		deleteBut.setBorder(new LineBorder(Color.green.brighter()));
		deleteBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewFrame.putPanel(new DeletePanel(viewFrame));
			}
		});
		deleteBut.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	deleteBut.setBackground(Color.gray.brighter());
		    }

		    public void mouseExited(MouseEvent evt) {
		    	deleteBut.setBackground(Color.green.darker());
		    }
		});

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(topLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(js1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(gridBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty = 0.2;
		this.add(addBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(js2, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(deleteBut, gbc);

	}

	public String getMessageReturned() {
		return messageReturned;
	}

	public void setMessageReturned(String messageReturned) {
		this.messageReturned = messageReturned;
	}
}




//package za.co.sfy.view;
//
//import java.awt.Dimension;
//import java.awt.GridBagConstraints;
//
//import javax.swing.JPanel;
//
//public class CenterCatalogueHome extends AbstractCenterPanel {
//
//	private static final long serialVersionUID = 1L;
//	private String messageReturned;
//
//	public CenterCatalogueHome(ViewFrame viewFrame, String message) {
//		this.messageReturned = message;
//		initComponents(viewFrame, message);
//	}
//
//	public CenterCatalogueHome(ViewFrame viewFrame) {
//		initComponents(viewFrame);
//	}
//
//	public void initComponents(ViewFrame viewFrame) {
//		GridBagConstraints gridBagConstraints = initGridBag();
//		JPanel addBox = setAddBox("Add Item");
//		setAddGrid(addBox);
//		setConstraints(0, 0, GridBagConstraints.FIRST_LINE_START, setTitleJLabel("Catalogue"), gridBagConstraints);
//		setConstraints(0, 1, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, setTopSeparator(new Dimension(400, 5)), gridBagConstraints);
//		setConstraints(0, 2, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, setAddRadioGroup(viewFrame), gridBagConstraints);
//		setConstraints(0, 3, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 0.2, addBox, gridBagConstraints);
//		setConstraints(0, 4, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 0.0, setLowerSeparator(new Dimension(400, 5)), gridBagConstraints);
//		setConstraints(0, 5, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, setDeleteButton(viewFrame, new DeletePanel(viewFrame)), gridBagConstraints);
//	}
//	
//	public void initComponents(ViewFrame viewFrame, String message) {
//		GridBagConstraints gridBagConstraints = initGridBag(); 
//		JPanel addBox = setAddBox("Add Item", message);
//		setAddGrid(addBox);
//		setConstraints(0, 0, GridBagConstraints.FIRST_LINE_START, setTitleJLabel("Catalogue"), gridBagConstraints);
//		setConstraints(0, 1, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, setTopSeparator(new Dimension(400, 5)), gridBagConstraints);
//		setConstraints(0, 2, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, setAddRadioGroup(viewFrame), gridBagConstraints);
//		setConstraints(0, 3, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 0.2, addBox, gridBagConstraints);
//		setConstraints(0, 4, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 0.0, setLowerSeparator(new Dimension(400, 5)), gridBagConstraints);
//		setConstraints(0, 5, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, setDeleteButton(viewFrame, new DeletePanel(viewFrame)), gridBagConstraints);
//	}
//
//	public String getMessageReturned() {
//		return messageReturned;
//	}
//
//	public void setMessageReturned(String messageReturned) {
//		this.messageReturned = messageReturned;
//	}
//}
