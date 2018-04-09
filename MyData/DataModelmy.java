package MyData;

import javax.swing.DefaultListModel;

public class DataModelmy extends DefaultListModel{
	String[] str_Course = null;
	public DataModelmy(String Stu_no)
	{
		
		str_Course = MyFrame.Function.getStu_Course(Stu_no);
		for(int i = 0 ; str_Course[i] != null; i ++)
		{
			this.addElement(str_Course[i]);
		//	System.out.println(str_Course[i]);
		}
		
	}
			
}
