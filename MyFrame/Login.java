package MyFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame{

	/**
	 * @param args
	 */
	private JPanel Panel_Main;
	private JPanel Panel_Center;
	private JPanel Panel_South;
	private JLabel Label_Title;
	private JLabel Label_User;
	private JLabel Label_Password;
	private JLabel Label_LoginWay;
	private JTextField TF_User;
	private JPasswordField PField_PW;
	private JComboBox CBox_Way;
	
	private JButton Button_Login;
	private JButton Button_Cancel;
	public MyListener.Login_Listener Login_Listener;
	public Login()
	{
		/*初始化界面*/
		this.setTitle("登入界面");
		this.setSize(400,250);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension di = kit.getScreenSize();
		int x = (int) ((di.getWidth() - 400)/2);
		int y = (int) ((di.getHeight() - 250)/2);
		this.setLocation(x, y);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		/*监听对象*/
		Login_Listener = new  MyListener.Login_Listener();
		
		
		/*容器*/
		Panel_Main = new JPanel(new BorderLayout());
		Panel_Main.setBorder(new EmptyBorder(20,20,20,20));
		this.add(Panel_Main);
		Label_Title = new JLabel("学生选课成绩管理系统",JLabel.CENTER);
		Panel_Main.add(Label_Title,BorderLayout.NORTH);
		
		Panel_Center = new JPanel(new GridLayout(3,2));
		Panel_Main.add(Panel_Center,BorderLayout.CENTER);
		Label_User = new JLabel("用户名：",JLabel.CENTER);
		Label_Password = new JLabel("密    码：",JLabel.CENTER);
		TF_User = new JTextField(15);
		TF_User.addKeyListener(Login_Listener);
		


	
		PField_PW = new JPasswordField(15);
		PField_PW.addKeyListener(Login_Listener);
		Label_LoginWay = new JLabel("登入类型: ",JLabel.CENTER);
		String[] list_Way = {"学生","教师","管理员"};
		CBox_Way = new JComboBox(list_Way);
		
		Panel_Center.add(Label_User);
		Panel_Center.add(TF_User);
		Panel_Center.add(Label_Password);
		Panel_Center.add(PField_PW);
		Panel_Center.add(Label_LoginWay);
		Panel_Center.add(CBox_Way);
		
		Panel_South = new JPanel();
		Panel_Main.add(Panel_South,BorderLayout.SOUTH);
		Button_Login = new JButton("登入");
		Button_Login.addActionListener(Login_Listener);
		Button_Login.setActionCommand("登入");
		
		Button_Cancel = new JButton("取消");
		Button_Cancel.addActionListener(Login_Listener);
		Button_Cancel.setActionCommand("取消");
		Panel_South.add(Button_Login);
		Panel_South.add(Button_Cancel);
		
		this.setVisible(true);
		
	}
	public JTextField getTF_User() {
		return TF_User;
	}
	
	public JPasswordField getPField_PW() {
		return PField_PW;
	}

	public JComboBox getCBox_Way() {
		return CBox_Way;
	}
	
	
}
