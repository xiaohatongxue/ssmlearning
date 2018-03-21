package colin.com.student.po;

import java.util.List;


public class DepartmentExt extends DepartmentT {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3688898538469944897L;
	private List<TeacherT> tList;

	public DepartmentExt() {
		// TODO 自动生成的构造函数存根
	}
	public List<TeacherT> gettList() {
		return tList;
	}

	public void settList(List<TeacherT> tList) {
		this.tList = tList;
	}

}
