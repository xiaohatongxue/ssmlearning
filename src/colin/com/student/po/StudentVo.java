package colin.com.student.po;

public class StudentVo {

	DepartmentT departmentT;

	TeacherT teacherT;

	public StudentVo() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public StudentVo(DepartmentT departmentT, TeacherT teacherT) {
		this.departmentT = departmentT;
		this.teacherT = teacherT;
	}

	public DepartmentT getDepartmentT() {
		return departmentT;
	}

	public void setDepartmentT(DepartmentT departmentT) {
		this.departmentT = departmentT;
	}

	public TeacherT getTeacherT() {
		return teacherT;
	}

	public void setTeacherT(TeacherT teacherT) {
		this.teacherT = teacherT;
	}

}
