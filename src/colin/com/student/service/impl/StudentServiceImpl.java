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
		// TODO 自动生成的方法存根
		return departmentTMapper.selectList(new RowBounds(1, 5));
	}

	@Override
	public void insert() {
		// TODO 自动生成的方法存根
		//
		DepartmentT t =new DepartmentT();
		 t.setDepartmentName("事务学");
		 t.setDepartmentDirectorId("fffff1");
		departmentTMapper.insert(t);
		
		//TeacherTMapper 插入
		teacherTMapper.insert(null);
	}

}
