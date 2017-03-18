 package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame
{
	/*
	 * Member variables
	 */
	private JPanel containingPanel;
	private JEditorPane spring2015Pane;
	private JEditorPane summer2015Pane;
	private JEditorPane fall2015Pane;
	private JEditorPane spring2016Pane;
	private JEditorPane summer2016Pane;
	private JEditorPane fall2016Pane;
	private JEditorPane spring2017Pane;
	private JEditorPane summer2017Pane;
	private JEditorPane fall2017Pane;
	private JEditorPane spring2018Pane;
	private JEditorPane summer2018Pane;
	private JEditorPane fall2018Pane;
	private JEditorPane spring2019Pane;
	private JEditorPane summer2019Pane;
	private JEditorPane fall2019Pane;
	private JEditorPane spring2020Pane;
	
	/*
	 * Colors used
	 */
	private Color lightBlueBackground = new Color(184, 225, 227);
	private Color lightGreen = new Color(107, 207, 111);
	private Color darkPurple = new Color(88, 33, 130);
	private Color lightPurple = new Color(171, 101, 224);
	
	/**
	 * Creates a new GUI object and sets it visible
	 * 
	 * @param args
	 */
	public static void main (String[] args)
	{
		GUI path = new GUI();
		path.setVisible(true);
	}
	
	/*
	 * Constructor
	 */
	public GUI()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Controller controller = new Controller(this);
		
		/*
		 * Creates main container; top-most level besides GUI JFrame.
		 */
		JPanel mainPanel = new JPanel();
		getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel);
		
		/*
		 * Creates north panel
		 */
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridBagLayout());
		JLabel northPanelLabel = new JLabel("CS PATH", SwingConstants.CENTER);
		northPanelLabel.setFont(new Font("Helvetica", Font.BOLD, 80));
		northPanelLabel.setForeground(Color.white);
		northPanel.add(northPanelLabel);
		northPanel.setBackground(darkPurple);
		northPanel.setPreferredSize(new Dimension(1000, 100));
		
		/*
		 * Creates center panel
		 */
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel centerPanelLabel = new JLabel("Courses I still have to take: ");
		centerPanelLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		centerPanelLabel.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(centerPanelLabel);
		
		/*
		 * Creates grid panel
		 */
		JPanel gridPanel = new JPanel();
		gridPanel.setBackground(lightGreen);
		gridPanel.setLayout(new GridLayout());
		centerPanel.add(gridPanel);
		boolean flag = false;
		for(int i=0; i < controller.getCoursesLeft().length; i++)
		{
			/*
			 * Creates containing panel
			 */
			containingPanel = new JPanel();
			containingPanel.setBackground(lightBlueBackground);
			while(flag == false)
			{
				for(Course c : controller.getCoursesLeft())
				{
					JPanel panel = new JPanel();
					panel.setBackground(lightGreen);
					panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
					panel.setPreferredSize(new Dimension(350, 55));
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					JLabel label = new JLabel(c.getFullCourseTitle());
					label.setFont(new Font("Helvetica", Font.BOLD, 15));
					label.setAlignmentX(CENTER_ALIGNMENT);
					panel.add(label);
					JComboBox<String> dropDownMenu = new JComboBox<String>(controller.getSemesterNames());
					dropDownMenu.addActionListener(controller);
					dropDownMenu.setName(c.getShortTitle());
					dropDownMenu.setActionCommand(c.getShortTitle());
					panel.add(dropDownMenu);
					containingPanel.add(panel);
					flag = true;
				}
				gridPanel.add(containingPanel);
			}
		centerPanel.add(gridPanel);
		}
		
		/*
		 * Creates a check schedule JButton
		 */
		JButton checkButton = new JButton("Check Schedule for Errors");
		checkButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		checkButton.setActionCommand("check");
		checkButton.addActionListener(controller);
		checkButton.setBackground(Color.green);
		checkButton.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(checkButton);
		
		//right hand side starts here
		
		/*
		 * Creates schedule panel
		 */
		JPanel schedulePanel = new JPanel();
		schedulePanel.setBackground(lightBlueBackground);
		gridPanel.add(schedulePanel);
		
		/*
		 * Creates columns
		 */
		JPanel scheduleColumn1 = new JPanel();
		schedulePanel.add(scheduleColumn1);
		scheduleColumn1.setBackground(lightGreen);
		scheduleColumn1.setPreferredSize(new Dimension(150, 675));
		scheduleColumn1.setLayout(new BoxLayout(scheduleColumn1, BoxLayout.Y_AXIS));
		
		JPanel scheduleColumn2 = new JPanel();
		schedulePanel.add(scheduleColumn2);
		scheduleColumn2.setBackground(lightGreen);
		scheduleColumn2.setPreferredSize(new Dimension(150, 675));
		scheduleColumn2.setLayout(new BoxLayout(scheduleColumn2, BoxLayout.Y_AXIS));
		
		JPanel scheduleColumn3 = new JPanel();
		schedulePanel.add(scheduleColumn3);
		scheduleColumn3.setBackground(lightGreen);
		scheduleColumn3.setPreferredSize(new Dimension(150, 675));
		scheduleColumn3.setLayout(new BoxLayout(scheduleColumn3, BoxLayout.Y_AXIS));
		
		JPanel scheduleColumn4 = new JPanel();
		schedulePanel.add(scheduleColumn4);
		scheduleColumn4.setBackground(lightGreen);
		scheduleColumn4.setPreferredSize(new Dimension(150, 675));
		scheduleColumn4.setLayout(new BoxLayout(scheduleColumn4, BoxLayout.Y_AXIS));
		
		/*
		 * 2015 column content
		 */
		JLabel spring2015Label = new JLabel("Spring 2015: ");
		spring2015Label.setAlignmentX(CENTER_ALIGNMENT);;
		spring2015Pane = new JEditorPane();
		spring2015Pane.setBackground(lightPurple);
		spring2015Pane.setForeground(Color.white);
		spring2015Pane.setEditable(false);
		scheduleColumn1.add(spring2015Label);
		scheduleColumn1.add(spring2015Pane);
		
		JLabel summer2015Label = new JLabel("Summer 2015: ");
		summer2015Label.setAlignmentX(CENTER_ALIGNMENT);;
		summer2015Pane = new JEditorPane();
		summer2015Pane.setBackground(lightPurple);
		summer2015Pane.setForeground(Color.white);
		summer2015Pane.setEditable(false);
		scheduleColumn1.add(summer2015Label);
		scheduleColumn1.add(summer2015Pane);
		
		JLabel fall2015Label = new JLabel("Fall 2015: ");
		fall2015Label.setAlignmentX(CENTER_ALIGNMENT);;
		fall2015Pane = new JEditorPane();
		fall2015Pane.setBackground(lightPurple);
		fall2015Pane.setForeground(Color.white);
		fall2015Pane.setEditable(false);
		scheduleColumn1.add(fall2015Label);
		scheduleColumn1.add(fall2015Pane);
		
		/*
		 * 2016 column content
		 */
		JLabel spring2016Label = new JLabel("Spring 2016: ");
		spring2016Label.setAlignmentX(CENTER_ALIGNMENT);;
		spring2016Pane = new JEditorPane();
		spring2016Pane.setBackground(Color.white);
		spring2016Pane.setEditable(false);
		scheduleColumn1.add(spring2016Label);
		scheduleColumn1.add(spring2016Pane);
		
		JLabel summer2016Label = new JLabel("Summer 2016: ");
		summer2016Label.setAlignmentX(CENTER_ALIGNMENT);;
		summer2016Pane = new JEditorPane();
		summer2016Pane.setBackground(Color.white);
		summer2016Pane.setEditable(false);
		scheduleColumn2.add(summer2016Label);
		scheduleColumn2.add(summer2016Pane);
		
		JLabel fall2016Label = new JLabel("Fall 2016: ");
		fall2016Label.setAlignmentX(CENTER_ALIGNMENT);;
		fall2016Pane = new JEditorPane();
		fall2016Pane.setBackground(Color.white);
		fall2016Pane.setEditable(false);
		scheduleColumn2.add(fall2016Label);
		scheduleColumn2.add(fall2016Pane);
		
		/*
		 * 2017 column content
		 */
		JLabel spring2017Label = new JLabel("Spring 2017: ");
		spring2017Label.setAlignmentX(CENTER_ALIGNMENT);;
		spring2017Pane = new JEditorPane();
		spring2017Pane.setBackground(lightPurple);
		spring2017Pane.setForeground(Color.white);
		spring2017Pane.setEditable(false);
		scheduleColumn2.add(spring2017Label);
		scheduleColumn2.add(spring2017Pane);
		
		JLabel summer2017Label = new JLabel("Summer 2017: ");
		summer2017Label.setAlignmentX(CENTER_ALIGNMENT);;
		summer2017Pane = new JEditorPane();
		summer2017Pane.setBackground(lightPurple);
		summer2017Pane.setForeground(Color.white);
		summer2017Pane.setEditable(false);
		scheduleColumn2.add(summer2017Label);
		scheduleColumn2.add(summer2017Pane);
		
		JLabel fall2017Label = new JLabel("Fall 2017: ");
		fall2017Label.setAlignmentX(CENTER_ALIGNMENT);;
		fall2017Pane = new JEditorPane();
		fall2017Pane.setBackground(lightPurple);
		fall2017Pane.setForeground(Color.white);
		fall2017Pane.setEditable(false);
		scheduleColumn3.add(fall2017Label);
		scheduleColumn3.add(fall2017Pane);
		
		/*
		 * 2018 column content
		 */
		JLabel spring2018Label = new JLabel("Spring 2018: ");
		spring2018Label.setAlignmentX(CENTER_ALIGNMENT);;
		spring2018Pane = new JEditorPane();
		spring2018Pane.setEditable(false);
		spring2018Pane.setBackground(Color.white);
		scheduleColumn3.add(spring2018Label);
		scheduleColumn3.add(spring2018Pane);
		
		JLabel summer2018Label = new JLabel("Summer 2018: ");
		summer2018Label.setAlignmentX(CENTER_ALIGNMENT);;
		summer2018Pane = new JEditorPane();
		summer2018Pane.setBackground(Color.white);
		summer2018Pane.setEditable(false);
		scheduleColumn3.add(summer2018Label);
		scheduleColumn3.add(summer2018Pane);
		
		JLabel fall2018Label = new JLabel("Fall 2018: ");
		fall2018Label.setAlignmentX(CENTER_ALIGNMENT);;
		fall2018Pane = new JEditorPane();
		fall2018Pane.setBackground(Color.white);
		fall2018Pane.setEditable(false);
		scheduleColumn3.add(fall2018Label);
		scheduleColumn3.add(fall2018Pane);
		
		/*
		 * 2019 column content
		 */
		JLabel spring2019Label = new JLabel("Spring 2019: ");
		spring2019Label.setAlignmentX(CENTER_ALIGNMENT);;
		spring2019Pane = new JEditorPane();
		spring2019Pane.setBackground(lightPurple);
		spring2019Pane.setForeground(Color.white);
		spring2018Pane.setEditable(false);
		scheduleColumn4.add(spring2019Label);
		scheduleColumn4.add(spring2019Pane);
		
		JLabel summer2019Label = new JLabel("Summer 2019: ");
		summer2019Label.setAlignmentX(CENTER_ALIGNMENT);;
		summer2019Pane = new JEditorPane();
		summer2019Pane.setBackground(lightPurple);
		summer2019Pane.setForeground(Color.white);
		summer2019Pane.setEditable(false);
		scheduleColumn4.add(summer2019Label);
		scheduleColumn4.add(summer2019Pane);
		
		JLabel fall2019Label = new JLabel("Fall 2019: ");
		fall2019Label.setAlignmentX(CENTER_ALIGNMENT);;
		fall2019Pane = new JEditorPane();
		fall2019Pane.setBackground(lightPurple);
		fall2019Pane.setForeground(Color.white);
		fall2019Pane.setEditable(false);
		scheduleColumn4.add(fall2019Label);
		scheduleColumn4.add(fall2019Pane);
		
		/*
		 * 2020 column content
		 */
		JLabel spring2020Label = new JLabel("Spring 2020: ");
		spring2020Label.setAlignmentX(CENTER_ALIGNMENT);;
		spring2020Pane = new JEditorPane();
		spring2020Pane.setBackground(Color.white);
		spring2020Pane.setEditable(false);
		scheduleColumn4.add(spring2020Label);
		scheduleColumn4.add(spring2020Pane);
		
		/*
		 * adds North, South, East, West, and Center Panels to mainPanel
		 */
		mainPanel.add(northPanel, BorderLayout.PAGE_START);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		/*
		 * display
		 */
		pack();
//		System.out.println(schedulePanel.getHeight());
	}
	
	public JEditorPane getJEditorPane(Semester s)
	{
		String name = s.getFormattedName();
		if(name.equals("Spring2015"))
		{
			return spring2015Pane;
		}
		else if(name.equals("Summer2015"))
		{
			return summer2015Pane;
		}
		else if(name.equals("Fall2015"))
		{
			return fall2015Pane;
		}
		else if(name.equals("Spring2016"))
		{
			return spring2016Pane;
		}
		else if(name.equals("Summer2016"))
		{
			return summer2016Pane;		}
		else if(name.equals("Fall2016"))
		{
			return fall2016Pane;
		}
		else if(name.equals("Spring2017"))
		{
			return spring2017Pane;
		}
		else if(name.equals("Summer2017"))
		{
			return summer2017Pane;
		}
		else if(name.equals("Fall2017"))
		{
			return fall2017Pane;
		}
		else if(name.equals("Spring2018"))
		{
			return spring2018Pane;
		}
		else if(name.equals("Summer2018"))
		{
			return summer2018Pane;
		}
		else if(name.equals("Fall2018"))
		{
			return fall2018Pane;
		}
		else if(name.equals("Spring2019"))
		{
			return spring2019Pane;
		}
		else if(name.equals("Summer2019"))
		{
			return summer2019Pane;
		}
		else if(name.equals("Fall2019"))
		{
			return fall2019Pane;
		}
		else if(name.equals("Spring2020"))
		{
			return spring2015Pane;
		}
		return null;
	}
}
