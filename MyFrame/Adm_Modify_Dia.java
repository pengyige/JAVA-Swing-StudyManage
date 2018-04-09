package MyFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Adm_Modify_Dia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textField_Cou_no;
	public JTextField textField_Tea_no;
	public JTextField textField_Sch_rs;
	public JTextField textField_yi_rs;


		public Adm_Modify_Dia() {
			setTitle("\u4FEE\u6539\u8BFE\u7A0B\u5B89\u6392");
		setBounds(100, 100, 355, 334);
		getContentPane().setLayout(null);
		
		JLabel label_Cou_no = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label_Cou_no.setBounds(91, 29, 54, 15);
		getContentPane().add(label_Cou_no);
		
		textField_Cou_no = new JTextField();
		textField_Cou_no.setBounds(173, 26, 66, 21);
		getContentPane().add(textField_Cou_no);
		textField_Cou_no.setColumns(10);
		
		JLabel label_Tea_no = new JLabel("\u6559\u5E08\u53F7\uFF1A");
		label_Tea_no.setBounds(91, 88, 54, 15);
		getContentPane().add(label_Tea_no);
		
		JLabel label_Sch_rs = new JLabel("\u9009\u8BFE\u4EBA\u6570\uFF1A");
		label_Sch_rs.setBounds(91, 146, 60, 21);
		getContentPane().add(label_Sch_rs);
		
		JLabel label_yi_rs = new JLabel("\u5DF2\u9009\u4EBA\u6570\uFF1A");
		label_yi_rs.setBounds(91, 201, 66, 15);
		getContentPane().add(label_yi_rs);
		
		textField_Tea_no = new JTextField();
		textField_Tea_no.setBounds(173, 85, 66, 21);
		getContentPane().add(textField_Tea_no);
		textField_Tea_no.setColumns(10);
		
		textField_Sch_rs = new JTextField();
		textField_Sch_rs.setBounds(173, 146, 66, 21);
		getContentPane().add(textField_Sch_rs);
		textField_Sch_rs.setColumns(10);
		
		textField_yi_rs = new JTextField();
		textField_yi_rs.setBounds(173, 198, 66, 21);
		getContentPane().add(textField_yi_rs);
		textField_yi_rs.setColumns(10);
		
		JButton button_OK = new JButton("\u4FDD\u5B58");
		button_OK.setBounds(45, 263, 93, 23);
		button_OK.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(Function.update_XK_Plan(textField_Cou_no.getText(),
						textField_Tea_no.getText(), Integer.valueOf(textField_Sch_rs.getText())
						,Integer.valueOf(textField_yi_rs.getText()))
					)
				{
							JOptionPane.showMessageDialog(null, "修改成功");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "修改失败！该课程安排已存在或网络连接失败");
				}
			}
			
		});
		getContentPane().add(button_OK);
		
		JButton button_Cancel = new JButton("\u53D6\u6D88");
		button_Cancel.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Main.a_Frame.get_Modify_Dia().dispose();
					}
				
				});
		button_Cancel.setBounds(191, 263, 93, 23);
		getContentPane().add(button_Cancel);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	}
}
