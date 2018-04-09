package MyFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MyListener.Adm_Frame_Listener;
import MyListener.MyWindowListener;

import java.awt.*;
import javax.swing.*;
public class Admin_Frame extends JFrame {

	private JPanel contentPane;//主面板
	private JMenuBar menBar;
	private JMenu menu_Student;
	private JMenu menu_Teacher;
	private JMenu menu_Course;
	private JMenu menu_XK_Ctr;
	
	private JMenuItem mi_Stu_Add;
	private JMenuItem mi_Stu_Query;
	private JMenuItem mi_Stu_Modify;
	private JMenuItem mi_Stu_Delete;
	
	private JMenuItem mi_Tea_Add;
	private JMenuItem mi_Tea_Query;
	private JMenuItem mi_Tea_Modify;
	private JMenuItem mi_Tea_Delete;
	
	private JMenuItem mi_Cou_Add;
	private JMenuItem mi_Cou_Query;
	private JMenuItem mi_Cou_Modify;
	private JMenuItem mi_Cou_Delete;
	
	private JMenuItem mi_Open_Xk;
	private JMenuItem mi_Close_Xk;
	private JMenuItem mi_Plan_Xk;
	private String Adm_no;
	
	private JPanel panel_Plan;//选课计划面板
	private DefaultTableModel table_model;
	private JTable table_Plan;
	private JPanel panel_Btn;//按钮面板
	private JButton btn_Insert_Plan;
	private JButton btn_Modify_Plan;
	private JButton btn_Save_Plan;
	private JButton btn_Delete_Plan;
	private JButton btn_Cancel_Plan;
	
	private CardLayout card;
	
	private JPanel panel_BK;//背景面板
	private JLabel label_BK;
	
	private Adm_Up_Dia Insert_Dialog;
	private Adm_Modify_Dia Modify_Dia;
	public Admin_Frame(String Adm_no) {
		
		this.Adm_no = Adm_no;
		setTitle("学生选修成绩管理系统");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(500, 400);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension di = kit.getScreenSize();
		int x = (int) ((di.getWidth() - 500)/2);
		int y = (int) ((di.getHeight() - 400)/2);
		this.setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		card = new CardLayout();
		contentPane.setLayout(card);
		setContentPane(contentPane);
		
		//创建窗口监听
		MyWindowListener mWLis = new MyWindowListener();
		this.addWindowListener(mWLis);
		
		
		//创建监听对象
		Adm_Frame_Listener admin_Listener = new Adm_Frame_Listener();
		//菜单栏创建
		menBar = new JMenuBar();
		menu_Student = new JMenu("学生管理");
		mi_Stu_Add = new JMenuItem("添加学生");
		mi_Stu_Add.addActionListener(admin_Listener);
		mi_Stu_Add.setActionCommand("添加学生");
		
		mi_Stu_Query =  new JMenuItem("查询学生");
		mi_Stu_Query.addActionListener(admin_Listener);
		mi_Stu_Query.setActionCommand("查询学生");
		
		mi_Stu_Modify = new JMenuItem("修改学生");
		mi_Stu_Modify.addActionListener(admin_Listener);
		mi_Stu_Modify.setActionCommand("修改学生");
		
		mi_Stu_Delete = new JMenuItem("删除学生");
		mi_Stu_Delete.addActionListener(admin_Listener);
		mi_Stu_Delete.setActionCommand("删除学生");
		menu_Student.add(mi_Stu_Add);
		menu_Student.add(mi_Stu_Query);
		menu_Student.add(mi_Stu_Modify);
		menu_Student.add(mi_Stu_Delete);
		
		menBar.add(menu_Student);
		
		
		menu_Teacher = new JMenu("教师管理");
		mi_Tea_Add = new JMenuItem("添加教师");
		mi_Tea_Add.addActionListener(admin_Listener);
		mi_Tea_Add.setActionCommand("添加教师");
		
		mi_Tea_Query = new JMenuItem("查询教师");
		mi_Tea_Query.addActionListener(admin_Listener);
		mi_Tea_Query.setActionCommand("查询教师");
		
		mi_Tea_Modify = new JMenuItem("修改教师");
		mi_Tea_Modify.addActionListener(admin_Listener);
		mi_Tea_Modify.setActionCommand("修改教师");
		
		mi_Tea_Delete = new JMenuItem("删除教师");
		mi_Tea_Delete.addActionListener(admin_Listener);
		mi_Tea_Delete.setActionCommand("删除教师");
		menu_Teacher.add(mi_Tea_Add);
		menu_Teacher.add(mi_Tea_Query);
		menu_Teacher.add(mi_Tea_Modify);
		menu_Teacher.add(mi_Tea_Delete);
		
		menBar.add(menu_Teacher);
		
		
		menu_Course = new JMenu("课程管理");
		mi_Cou_Add = new JMenuItem("添加课程");
		mi_Cou_Add.addActionListener(admin_Listener);
		mi_Cou_Add.setActionCommand("添加课程");
		
		mi_Cou_Query = new JMenuItem("查询课程");
		mi_Cou_Query.addActionListener(admin_Listener);
		mi_Cou_Query.setActionCommand("查询课程");
		
		mi_Cou_Modify = new JMenuItem("修改课程");
		mi_Cou_Modify.addActionListener(admin_Listener);
		mi_Cou_Modify.setActionCommand("修改课程");
		
		mi_Cou_Delete = new JMenuItem("删除课程");
		mi_Cou_Delete.addActionListener(admin_Listener);
		mi_Cou_Delete.setActionCommand("删除课程");
		menu_Course.add(mi_Cou_Add);
		menu_Course.add(mi_Cou_Query);
		menu_Course.add(mi_Cou_Modify);
		menu_Course.add(mi_Cou_Delete);
		
		menBar.add(menu_Course);
		
		menu_XK_Ctr = new JMenu("选课管理");
		mi_Open_Xk = new JMenuItem("开始选课");
		mi_Open_Xk.addActionListener(admin_Listener);
		mi_Open_Xk.setActionCommand("开始选课");
		
		mi_Close_Xk = new JMenuItem("停止选课");
		mi_Close_Xk.addActionListener(admin_Listener);
		mi_Close_Xk.setActionCommand("停止选课");
		
		mi_Plan_Xk = new JMenuItem("课程安排");
		mi_Plan_Xk.addActionListener(admin_Listener);
		mi_Plan_Xk.setActionCommand("课程安排");
		menu_XK_Ctr.add(mi_Open_Xk);
		menu_XK_Ctr.add(mi_Close_Xk);
		menu_XK_Ctr.add(mi_Plan_Xk);
		
		menBar.add(menu_XK_Ctr);
		
		
		//课程计划面板
		panel_Plan = new JPanel(new BorderLayout());
		table_model = new DefaultTableModel();
		this.table_Plan = new JTable(table_model);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);   
		table_Plan.setDefaultRenderer(Object.class, r);
		table_Plan.setEnabled(false);
		panel_Plan.add(new JScrollPane(table_Plan),BorderLayout.CENTER);
		
		panel_Btn = new JPanel();
		btn_Insert_Plan = new JButton("添加");
		btn_Insert_Plan.addActionListener(admin_Listener);
		btn_Insert_Plan.setActionCommand("添加");
		panel_Btn.add(btn_Insert_Plan);
		btn_Modify_Plan = new JButton("修改");
		btn_Modify_Plan.addActionListener(admin_Listener);
		btn_Modify_Plan.setActionCommand("修改");
		panel_Btn.add(btn_Modify_Plan);
		btn_Save_Plan = new JButton("查看");
		btn_Save_Plan.addActionListener(admin_Listener);
		btn_Save_Plan.setActionCommand("查看");
		panel_Btn.add(btn_Save_Plan);
		btn_Delete_Plan = new JButton("删除");
		btn_Delete_Plan.addActionListener(admin_Listener);
		btn_Delete_Plan.setActionCommand("删除");
		panel_Btn.add(btn_Delete_Plan);
		btn_Cancel_Plan = new JButton("取消");
		btn_Cancel_Plan.addActionListener(admin_Listener);
		btn_Cancel_Plan.setActionCommand("取消");
		panel_Btn.add(btn_Cancel_Plan);
		
		panel_Plan.add(panel_Btn,BorderLayout.SOUTH);
		
		//背景面板
		panel_BK = new JPanel(new BorderLayout());
		label_BK = new JLabel("学生选课管理系统");
		panel_BK.add(label_BK,BorderLayout.CENTER);
		label_BK.setIcon(new ImageIcon("images//BK.png"));
		
		//添加卡片布局的卡片
		contentPane.add(panel_Plan,"计划吧");
		contentPane.add(panel_BK,"背景吧");
		card.show(contentPane, "背景吧");
		
		this.setJMenuBar(menBar);
		
		
		Insert_Dialog = new Adm_Up_Dia();
		Insert_Dialog.setLocationRelativeTo(this);
		
		Modify_Dia = new Adm_Modify_Dia();
		Modify_Dia.setLocationRelativeTo(this);

		
	}
	//返回卡片布局
	public CardLayout getCard()
	{
		return this.card;
	}
	//返回卡片容器
	public JPanel getShow_Panel()
	{
		return this.contentPane;
	}
	//返回表格模式
	public DefaultTableModel getTable_Model()
	{
		return this.table_model;
	}
	//返回添加对话框
	public JDialog get_Insert_Dia()
	{
		return this.Insert_Dialog;
	}
	//返回修改对话框
	public JDialog get_Modify_Dia()
	{
		return this.Modify_Dia;
	}
	
}
