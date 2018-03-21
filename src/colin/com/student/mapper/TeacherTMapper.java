package colin.com.student.mapper;

import java.util.List;

import colin.com.student.po.StudentVo;
import colin.com.student.po.TeacherExt;
import colin.com.student.po.TeacherT;

public interface TeacherTMapper {

	public List<TeacherT> findTeacherList(StudentVo studentVo) throws Exception;
	public List<TeacherExt> findTeacherDepartmentList() throws Exception;
	public List<TeacherT> findTeacherListFindDepartment(int id);
	public void insert(TeacherT teacherT);
}
