package colin.com.student.service;

import java.util.List;

import colin.com.student.po.DepartmentExt;

public interface StudentService {

	public List<DepartmentExt> selectDepattemntList();
	public void insert();
}
