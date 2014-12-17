package ChecklistProject;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;
public class Checklist extends JFrame {

	public static void main(String[] args)
	{
		new Checklist();
	}
	public static JPanel screen=new JPanel();
	public static JButton addNew=new JButton("Add new Item");
	public static JButton reset=new JButton("Reset");
	public static JCheckBox j=new JCheckBox("Do this");
	public static JCheckBox k=new JCheckBox("Do this");
	public static JCheckBox l=new JCheckBox("Do this");
	public static JCheckBox m=new JCheckBox("Do this");
	public static JCheckBox n=new JCheckBox("Do this");
	public static JCheckBox o=new JCheckBox("Do this");
	public static JCheckBox p=new JCheckBox("Do this");
	public static JCheckBox q=new JCheckBox("Do this");
	ArrayList<JCheckBox> tasks=new ArrayList<JCheckBox>();	
	int pos=0;
	public Checklist()
	{
		addTasks();
		setNonVis();
		this.setSize(300,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Checklist");
		screen.setLayout(new GridBagLayout());
		addItem(screen, addNew,0,0,1,1,GridBagConstraints.WEST);
		addItem(screen,reset,5,0,1,1,GridBagConstraints.EAST);
		addItem(screen,j,0,1,1,1,GridBagConstraints.WEST);
		addBoxes();
		addNew.addActionListener(e -> addNewItem());
		this.add(screen);
		//this.pack();
		this.setVisible(true);
	}
	public void addItem(JPanel p, JComponent c, int x, int y, int width, 
			int height,int align)
	{
		GridBagConstraints gc=new GridBagConstraints();
		gc.gridx=x;
		gc.gridy=y;
		gc.gridwidth=width;
		gc.gridheight=height;
		gc.weightx=100.0;
		gc.weighty=100.0;
		gc.insets=new Insets(4,4,4,4);
		gc.anchor=align;
		gc.fill=GridBagConstraints.NONE;
		p.add(c,gc);
	}
	public void addNewItem(){
		String x=JOptionPane.showInputDialog(null,"What is the task","Enter Task Here");
		System.out.println(x);
		if(x.length()==0)
			return;
		tasks.get(pos).setText(x);
		tasks.get(pos).setVisible(true);
		pos++;
	}
	public void addTasks(){
		tasks.add(j);
		tasks.add(k);
		tasks.add(l);
		tasks.add(m);
		tasks.add(n);
		tasks.add(o);
		tasks.add(p);
		tasks.add(q);
	}
	public void setNonVis(){
		for(JCheckBox x: tasks)
			x.setVisible(false);
	}
	public void addBoxes(){
		int y=1;
		for(JCheckBox x: tasks){
			addItem(screen, x, 0, y, 1, 1, GridBagConstraints.WEST);
			y++;
		}
	}
}
