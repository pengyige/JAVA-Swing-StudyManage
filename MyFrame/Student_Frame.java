package MyFrame;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import MyData.DataModelmy;
import MyListener.MyWindowListener;
import MyListener.Stu_Frame_Listener;

import java.awt.*;
import javax.swing.*;
public class Student_Frame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Infor;//个人信息面板
	private JPanel panel_Func;//布局卡片面板
	private JPanel panel_XuanKe;//选课面板
	private JPanel panel_QueryScore;//成绩面板
	private JPanel panel_Modify_Ps;//修改密码面板
	private JPanel panel_BK;//背景面板
	private JLabel label_Stu_no;
	private JLabel label_Stu_name;
	private JLabel label_Stu_sex;
	private JLabel label_Stu_class;
	private String Stu_no;
	
	private JPanel panel_BtnFunc;//左边按钮面板
	private JButton btn_XuanKe;
	private JButton btn_QueryScore;
	private JButton btn_Modify_Pw;
	
	private JList list_all = null;
	private JList list_my = null;
	private DataModelmy mode_my = null;
	
	private JPanel panel_OK_flu;//选课面板南部
	private JButton btn_Ok_XK;
	private JButton btn_Flush_XK;
	private JButton btn_OK_Pw;
	
	
	private JTable Score_Table;
	private DefaultTableModel model;
	private CardLayout card;
	
	private JLabel label_BK;
	
	
	private JLabel label_NewPs;
	private JLabel label_NewPsA;
	private JPasswordField PF_NewPs;
	private JPasswordField PF_NewPsA;
	private JButton btn_OK_Ps;
	private JButton btn_Cancel_Ps;
	
	
	private DefaultTableModel model_XK_tab;
	private JTable tab_XK;
	public Student_Frame(String Stu_no) {
		this.Stu_no = Stu_no;
		setTitle("学生选修成绩管理系统");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(800, 500);
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
		
		label_Stu_no = new JLabel();
		label_Stu_no.setHorizontalAlignment(SwingConstants.LEFT);
		label_Stu_name = new JLabel();
		label_Stu_name.setHorizontalAlignment(SwingConstants.LEFT);
		label_Stu_sex = new JLabel();
		label_Stu_sex.setHorizontalAlignment(SwingConstants.LEFT);
		label_Stu_class = new JLabel();
		label_Stu_class.setHorizontalAlignment(SwingConstants.LEFT);
		//设置标签title
		panel_Infor = new JPanel();
		contentPane.add(panel_Infor, BorderLayout.NORTH);
		panel_Infor.setLayout(new GridLayout(2,2));
		panel_Infor.add(label_Stu_no);
		panel_Infor.add(label_Stu_name);
		panel_Infor.add(label_Stu_sex);
		panel_Infor.add(label_Stu_class);
		Border lBorder = new LineBorder(Color.BLACK,1);
		panel_Infor.setBorder(BorderFactory.createTitledBorder(lBorder, "学生信息"));
		
		
		//按钮面板
		panel_BtnFunc = new JPanel();
		contentPane.add(panel_BtnFunc, BorderLayout.WEST);
		panel_BtnFunc.setLayout(new BoxLayout(panel_BtnFunc, BoxLayout.Y_AXIS));
		
		Stu_Frame_Listener Stu_Listener = new Stu_Frame_Listener();
		panel_BtnFunc.add(Box.createVerticalStrut(40));
		btn_XuanKe = new JButton("开始选课");
		btn_XuanKe.addActionListener(Stu_Listener);
		btn_XuanKe.setActionCommand("开始选课");
		panel_BtnFunc.add(btn_XuanKe);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
	
		btn_QueryScore = new JButton("查询成绩");
		btn_QueryScore.addActionListener(Stu_Listener);
		btn_QueryScore.setActionCommand("查询成绩");
		panel_BtnFunc.add(btn_QueryScore);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		
		btn_Modify_Pw = new JButton("修改密码");
		btn_Modify_Pw.addActionListener(Stu_Listener);
		btn_Modify_Pw.setActionCommand("修改密码");
		panel_BtnFunc.add(btn_Modify_Pw);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		panel_BtnFunc.setBorder(BorderFactory.createTitledBorder("功能列表"));
		
		
		//中间部分面板
		
		//选课面板
		panel_XuanKe = new JPanel(new BorderLayout());
		/*不采用list
		mode_all = new DataModel();
		list_all = new JList(mode_all);
		list_all.addMouseListener(list_Listener);
		list_all.setBorder(BorderFactory.createTitledBorder("所有课程"));
		panel_XuanKe.add(new JScrollPane(list_all),BorderLayout.CENTER);
		*/
		//采用表格
		model_XK_tab = new DefaultTableModel();
		tab_XK = new JTable(model_XK_tab);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);  
		tab_XK.setDefaultRenderer(Object.class,r);
		panel_XuanKe.add(new JScrollPane(tab_XK),BorderLayout.CENTER);
		
		//显示课程还是采用list
		mode_my = new DataModelmy(Stu_no);
		list_my = new JList(mode_my);
		//list_my.addMouseListener(list_Listener);
		list_my.setBorder(BorderFactory.createTitledBorder("我的课程"));
		panel_XuanKe.add(new JScrollPane(list_my),BorderLayout.EAST);
		
					//保存和刷新面板
		panel_OK_flu = new JPanel();
		btn_Ok_XK = new JButton("保存");
		btn_Ok_XK.addActionListener(Stu_Listener);
		btn_Ok_XK.setActionCommand("保存");
		panel_OK_flu.add(btn_Ok_XK);
		
		btn_Flush_XK = new JButton("刷新");
		btn_Flush_XK.addActionListener(Stu_Listener);
		btn_Flush_XK.setActionCommand("刷新");
		panel_OK_flu.add(btn_Flush_XK);
		panel_XuanKe.add(panel_OK_flu,BorderLayout.SOUTH);
		
		
		//成绩面板
		panel_QueryScore = new JPanel(new BorderLayout());
		model = new DefaultTableModel();
		Score_Table = new JTable(model); 
		Score_Table.setEnabled(false);
		Score_Table.setDefaultRenderer(Object.class, r);
		Score_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_QueryScore.add(new JScrollPane(Score_Table),BorderLayout.CENTER);
		
		
		//背景面板
		panel_BK = new JPanel(new BorderLayout());
		label_BK = new JLabel("学生选课管理系统");
		panel_BK.add(label_BK,BorderLayout.CENTER);
		label_BK.setIcon(new ImageIcon("images//BK.png"));
		//Image image = img.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		//img.setImage(image);
		
		//修改密码面板
		label_NewPs = new JLabel("新密码:");
		label_NewPs.setHorizontalAlignment(SwingConstants.CENTER);
		label_NewPsA = new JLabel("确认密码：");
		label_NewPsA.setHorizontalAlignment(SwingConstants.CENTER);
		PF_NewPs = new JPasswordField();
		PF_NewPsA = new JPasswordField();
		btn_OK_Ps = new JButton("确定");
		btn_OK_Ps.addActionListener(Stu_Listener);
		btn_OK_Ps.setActionCommand("确定");
		btn_Cancel_Ps = new JButton("取消");
		btn_Cancel_Ps.addActionListener(Stu_Listener);
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
		contentPane.add(panel_Func, BorderLayout.CENTER);
		panel_Func.add(panel_XuanKe,"选课吧");
		panel_Func.add(panel_QueryScore,"成绩吧");
		panel_Func.add(panel_BK,"背景吧");
		panel_Func.add(panel_Modify_Ps,"密码吧");
		card.show(panel_Func, "背景吧");
	}
	public void setLabel()
	{
	 Student stu = Function.getStudent_Infor(this.Stu_no);
		label_Stu_no.setText("学号："+stu.getStu_no()) ;
		label_Stu_name.setText("姓名："+stu.getStu_name());
		label_Stu_sex.setText("性别："+stu.getStu_sex());
		label_Stu_class.setText("班级："+stu.getStu_class());
	}
	
	//返回卡片布局对象
	public CardLayout getCard()
	{
		return this.card;
	}
	//返回设置在卡片布局对象的面板
	public JPanel getShowPanel()
	{
		return this.panel_Func;
	}
	
	public JList getList_my()
	{
		return this.list_my;
	}
	public DataModelmy getDataModelmy()
	{
		return this.mode_my;
	}
	//返回学号
	public String getStu_no()
	{
		return this.Stu_no;
	}
	//返回表格模式
	public DefaultTableModel getTable_Model()
	{
		return this.model;
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
	//返回选课表模式
	public DefaultTableModel getXK_Tab_Mod()
	{
		return this.model_XK_tab;
	}
	//返回选课表table
	public JTable getXK_Table()
	{
		return this.tab_XK;
	}
}


