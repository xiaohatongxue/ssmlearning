package colin.com.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;

import colin.com.student.mapper.DepartmentTMapper;
import colin.com.student.mapper.TeacherTMapper;
import colin.com.student.po.DepartmentExt;
import colin.com.student.po.DepartmentT;
import colin.com.student.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Resource
	private DepartmentTMapper departmentTMapper;
	@Resource
	private TeacherTMapper teacherTMapper;

	@Override
	public List<DepartmentExt> selectDepattemntList() {
		// TODO �Զ����ɵķ������
		return departmentTMapper.selectList(new RowBounds(1, 5));
	}

	@Override
	public void insert() {
		// TODO �Զ����ɵķ������
		//
		DepartmentT t =new DepartmentT();
		 t.setDepartmentName("����ѧ");
		 t.setDepartmentDirectorId("fffff1");
		departmentTMapper.insert(t);
		
		//TeacherTMapper ����
		teacherTMapper.insert(null);
	}

}
