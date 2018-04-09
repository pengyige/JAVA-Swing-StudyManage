package MyFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyListener.Adm_Frame_Listener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Adm_Up_Dia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public Adm_Up_Dia() {
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B\u5B89\u6392");
		setBounds(10, -39, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(-10, 1, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lbll = new JLabel("\u8BFE\u7A0B\u53F7:");
			lbll.setBounds(137, 45, 48, 15);
			contentPanel.add(lbll);
		}
		
		textField = new JTextField();
		textField.setBounds(207, 42, 93, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u6559\u5E08\u53F7:");
		label.setBounds(137, 104, 54, 15);
		contentPanel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 101, 93, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("人数：");
		label_1.setBounds(137, 164, 54, 15);
		contentPanel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 161, 93, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		Adm_Frame_Listener Adm_Lis = new Adm_Frame_Listener();
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						String Cou_no = null;
						String Tea_no = null;
						int All_Number = 0;
						// TODO Auto-generated method stub
						if(textField.getText() == "")
						{
							JOptionPane.showMessageDialog(null, "课程号不能为空");
							return;
						}
						if(textField_1.getText() == "")
						{
							JOptionPane.showMessageDialog(null, "教师号不能为空");
							return;
						}
						Cou_no = textField.getText();
						Tea_no = textField_1.getText();
						All_Number = Integer.valueOf(textField_2.getText());
					if(Function.insert_XK_Plan( Cou_no, Tea_no, All_Number))
					{
						JOptionPane.showMessageDialog(null, "添加成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "添加失败");
					}
					}
			
			
				});

		button.setBounds(108, 211, 93, 23);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(Adm_Lis);
		button_1.setActionCommand("取消添加");
		button_1.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Main.a_Frame.get_Insert_Dia().dispose();
					}
			
				});
		button_1.setBounds(224, 211, 93, 23);
		contentPanel.add(button_1);
	}

}
