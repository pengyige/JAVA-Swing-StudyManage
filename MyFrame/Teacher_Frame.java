package MyFrame;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;
import MyListener.MyWindowListener;
import MyListener.Tea_Frame_Listener;

public class Teacher_Frame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Infor;//个人信息面板
	private String Tea_no;
	private JLabel label_Tea_no;
	private JLabel label_Tea_name;
	
	private JPanel panel_Func;//整体布局中间面板
	private JPanel panel_inScore;//录入成绩面板
	private JPanel panel_QueryScore;//查询成绩面板
	private JPanel panel_Modify_Ps;//修改密码面板
	private JPanel panel_BK;//背景面板
	
	private JPanel panel_BtnFunc;//左边按钮面板
	private JButton btn_inScore;
	private JButton btn_QueryScore;
	private JButton btn_Modify_Pw;
	
	private JTable Score_Table;
	private DefaultTableModel model;
	
	
	private JLabel label_BK ;
	
	private CardLayout card;//卡布布局
	
	private JLabel label_NewPs;
	private JLabel label_NewPsA;
	private JPasswordField PF_NewPs;
	private JPasswordField PF_NewPsA;
	private JButton btn_OK_Ps;
	private JButton btn_Cancel_Ps;
	
	
	/*录入成绩面板组件*/
	private JPanel panel_CouInfo;
	private JLabel label_Cou_name;
	private JComboBox cbox_Cou_name;
	private JButton btn_OK_In;
	
	private DefaultTableModel model_InScore;
	private JTable InScore_Table;
	
	private JPanel panel_OK_Cancel;
	private JButton btn_Save;
	private JButton btn_Cancel;
	
	//教师课程记录树
	public static HashMap hm_Tea_Cou = null;
	public Teacher_Frame(String Tea_no) {
		this.Tea_no = Tea_no;
		this.setTitle("学生选修成绩管理系统");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(500,400);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension di = kit.getScreenSize();
		int x = (int) ((di.getWidth() - 500)/2);
		int y = (int) ((di.getHeight() - 400)/2);
		this.setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//添加关闭监听
		this.addWindowListener(new MyWindowListener());
		
		//个人信息面板
		panel_Infor  = new JPanel();
		panel_Infor.setBorder(BorderFactory.createTitledBorder("教师信息"));
		label_Tea_no = new JLabel();
		label_Tea_no.setHorizontalAlignment(SwingConstants.LEFT);
		label_Tea_name = new JLabel();
		label_Tea_name.setHorizontalAlignment(SwingConstants.LEFT);
		setLabel();
		panel_Infor.add(label_Tea_no);
		panel_Infor.add(label_Tea_name);
		contentPane.add(panel_Infor,BorderLayout.NORTH);
		
		
		//左边按钮面板
		panel_BtnFunc = new JPanel();
		contentPane.add(panel_BtnFunc,BorderLayout.WEST);
		panel_BtnFunc.setLayout(new BoxLayout(panel_BtnFunc, BoxLayout.Y_AXIS));
		Tea_Frame_Listener Tea_Listener = new Tea_Frame_Listener();
		panel_BtnFunc.add(Box.createVerticalStrut(40));
		
		this.btn_inScore = new JButton("录入成绩");
		btn_inScore.addActionListener(Tea_Listener);
		btn_inScore.setActionCommand("录入成绩");
		panel_BtnFunc.add(btn_inScore);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		
		btn_QueryScore = new JButton("查询成绩");
		btn_QueryScore.addActionListener(Tea_Listener);
		btn_QueryScore.setActionCommand("查询成绩");
		panel_BtnFunc.add(btn_QueryScore);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		
		btn_Modify_Pw = new JButton("修改密码");
		btn_Modify_Pw.addActionListener(Tea_Listener);
		btn_Modify_Pw.setActionCommand("修改密码");
		panel_BtnFunc.add(btn_Modify_Pw);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		panel_BtnFunc.setBorder(BorderFactory.createTitledBorder("功能列表"));
		
		
		
		//中间面板
		
			//录入成绩面板
		panel_inScore = new JPanel(new BorderLayout());
		panel_CouInfo = new JPanel();
		this.label_Cou_name = new JLabel("我的课程:");
		this.cbox_Cou_name = new JComboBox();
		this.btn_OK_In = new JButton("确定");
		btn_OK_In.addActionListener(Tea_Listener);
		btn_OK_In.setActionCommand("课程确定");
		panel_CouInfo.add(label_Cou_name);
		panel_CouInfo.add(cbox_Cou_name);
		panel_CouInfo.add(btn_OK_In);
		panel_inScore.add(panel_CouInfo,BorderLayout.NORTH);
		
		model_InScore = new DefaultTableModel();
		this.InScore_Table = new JTable(model_InScore);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);   
		InScore_Table.setDefaultRenderer(Object.class, r);
		panel_inScore.add(new JScrollPane(InScore_Table),BorderLayout.CENTER);
		
		panel_OK_Cancel = new JPanel();
		btn_Save = new JButton("保存");
		btn_Save.addActionListener(Tea_Listener);
		btn_Save.setActionCommand("保存");
		btn_Cancel = new JButton("取消");
		btn_Cancel.addActionListener(Tea_Listener);
		btn_Cancel.setActionCommand("取消");
		panel_OK_Cancel.add(btn_Save);
		panel_OK_Cancel.add(btn_Cancel);
		panel_inScore.add(panel_OK_Cancel,BorderLayout.SOUTH);
		
		
			//查询成绩面板
		panel_QueryScore = new JPanel(new BorderLayout());
		model = new DefaultTableModel();
		Score_Table = new JTable(model);
		Score_Table.setEnabled(false);
		Score_Table.setDefaultRenderer(Object.class, r);
		panel_QueryScore.add(new JScrollPane(Score_Table),BorderLayout.CENTER);
		
		
		
			//背景面板
		panel_BK = new JPanel(new BorderLayout());
		label_BK = new JLabel("学生选课管理系统");
		panel_BK.add(label_BK,BorderLayout.CENTER);
		label_BK.setIcon(new ImageIcon("images//BK.png"));
			//修改密码面板
		label_NewPs = new JLabel("新密码:");
		label_NewPs.setHorizontalAlignment(SwingConstants.CENTER);
		label_NewPsA = new JLabel("确认密码：");
		label_NewPsA.setHorizontalAlignment(SwingConstants.CENTER);
		PF_NewPs = new JPasswordField();
		PF_NewPsA = new JPasswordField();
		btn_OK_Ps = new JButton("确定");
		btn_OK_Ps.addActionListener(Tea_Listener);
		btn_OK_Ps.setActionCommand("确定");
		btn_Cancel_Ps = new JButton("取消");
		btn_Cancel_Ps.addActionListener(Tea_Listener);
		btn_Cancel_Ps.setActionCommand("取消");
		
		GridLayout myGray = new GridLayout(3,2);
		myGray.setHgap(30);
		myGray.setVgap(50);
		panel_Modify_Ps = new JPanel(myGray);
		panel_Modify_Ps.setBorder(new EmptyBorder(60, 60, 60, 60));
		
		panel_Modify_Ps.add(label_NewPs);
		panel_Modify_Ps.add(PF_NewPs);
		panel_Modify_Ps.add(label_NewPsA);
		panel_Modify_Ps.add(PF_NewPsA);
		panel_Modify_Ps.add(btn_OK_Ps);
		panel_Modify_Ps.add(btn_Cancel_Ps);
		
		//卡片面板
		card = new CardLayout();
		panel_Func = new JPanel(card);
		contentPane.add(panel_Func,BorderLayout.CENTER);
		panel_Func.add(panel_BK,"背景吧");
		panel_Func.add(panel_QueryScore,"成绩吧");
		panel_Func.add(panel_Modify_Ps,"密码吧");
		panel_Func.add(panel_inScore,"录入吧");
		card.show(panel_Func, "背景吧");
		
		
		hm_Tea_Cou = new HashMap();
		
	}
	public void setLabel()
	{
		String[] info = Function.getTeacher_Infor(this.Tea_no);
		label_Tea_no.setText("教师号："+info[0]);
		label_Tea_name.setText("姓名："+info[1]);
	}
	public String getTea_no()
	{
		return this.Tea_no;
	}
	public DefaultTableModel getTableModel()
	{
		return this.model;
	}
	public CardLayout getCard()
	{
		return this.card;
	}
	public JPanel getShowPanel()
	{
		return this.panel_Func;
	}
	//返回密码
	public JPasswordField getPF_NEW()
	{
		return this.PF_NewPs;
	}
	//返回确认密码
	public JPasswordField getPF_NEWA()
	{
		return this.PF_NewPsA;
	}
	//返回课程安排
	public JComboBox getcBox_Cou()
	{
		return this.cbox_Cou_name;
	}
	//返回录入成绩表模式
	public DefaultTableModel getModel_InScore()
	{
		return model_InScore;
	}
  
}
