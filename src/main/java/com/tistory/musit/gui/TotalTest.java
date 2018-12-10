package com.tistory.musit.gui;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TotalTest extends JFrame implements ActionListener
{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();

	JLabel id, password, name, gender, hobby, hp, intro, etc1, etc2, bar1, bar2;
	JTextField tf_id, tf_pw, tf_name, tf_hp1, tf_hp2, tf_intro;
	JRadioButton male, female;
	ButtonGroup bg;
	JCheckBox trip, reading;
	JComboBox<String> hp_cb;
	String hp_num[] = {"010","011","016","019"};
	JButton send, cancel;

	String url = "jdbc:mysql://104.155.151.3/test";
	String c_id = "root";
	String c_password = "root";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public TotalTest()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);

		GridLayout grid = new GridLayout(6, 1);
		setLayout(grid);

		id = new JLabel("���̵�");
		tf_id = new JTextField(8);
		etc1 = new JLabel("*8�� �̳�");
		panel1.add(id);
		panel1.add(tf_id);
		panel1.add(etc1);

		password = new JLabel("��й�ȣ");
		tf_pw = new JTextField(8);
		name = new JLabel("����");
		tf_name = new JTextField(8);
		panel2.add(password);
		panel2.add(tf_pw);
		panel2.add(name); 
		panel2.add(tf_name);

		gender = new JLabel("����");
		male = new JRadioButton("��");
		female = new JRadioButton("��");
		bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		hobby = new JLabel("���");
		trip = new JCheckBox("����");
		reading = new JCheckBox("����");
		panel3.add(gender);
		panel3.add(male);
		panel3.add(female);
		panel3.add(hobby);
		panel3.add(trip);
		panel3.add(reading);

		hp = new JLabel("H.P");
		hp_cb = new JComboBox<>(hp_num);
		tf_hp1 = new JTextField(3);
		tf_hp2 = new JTextField(3);
		bar1 = new JLabel("-");
		bar2 = new JLabel("-");
		etc2 = new JLabel("*�ʼ��Է�");
		panel4.add(hp);
		panel4.add(hp_cb);
		panel4.add(bar1);
		panel4.add(tf_hp1);
		panel4.add(bar2);
		panel4.add(tf_hp2);
		panel4.add(etc2);

		intro = new JLabel("�ڱ�Ұ�");
		tf_intro = new JTextField(20);
		panel5.add(intro);
		panel5.add(tf_intro);

		send = new JButton("����");
		cancel = new JButton("���");
		send.addActionListener(this);
		cancel.addActionListener(this);
		panel6.add(send);
		panel6.add(cancel);


		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();

		if(source==send)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, c_id, c_password);

				System.out.println("���� �Ϸ�");

				String sql = "INSERT into testtable values(?,?,?,?,?,?,?)";

				ps = con.prepareStatement(sql);

				ps.setString(1, tf_id.getText());
				ps.setString(2, tf_pw.getText());
				ps.setString(3, tf_name.getText());
				if(male.isSelected())
					ps.setInt(4, 1);
				else if(female.isSelected())
					ps.setInt(4, 2);

				if(trip.isSelected() && reading.isSelected())
					ps.setString(5, "trip, reading");
				else if(trip.isSelected() && !reading.isSelected())
					ps.setString(5, "trip");
				else if(!trip.isSelected() && reading.isSelected())
					ps.setString(5, "reading");

				ps.setString(6, hp_cb.getItemAt(hp_cb.getSelectedIndex())
						+tf_hp1.getText()+tf_hp2.getText());
				ps.setString(7, tf_intro.getText());

				ps.executeUpdate();

				ps.close();
				con.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		if(source==cancel)
		{
			tf_id.setText("");
			tf_pw.setText("");
			tf_name.setText("");
			tf_hp1.setText("");
			tf_hp2.setText("");
			tf_intro.setText("");
			male.setSelected(true);
			trip.setSelected(false);
			reading.setSelected(false);   
		}
	}

	public static void main(String[] args)
	{
		new TotalTest();
	}
}