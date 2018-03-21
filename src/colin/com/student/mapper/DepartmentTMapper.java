package colin.com.student.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.RowBounds;

import colin.com.student.po.DepartmentExt;
import colin.com.student.po.DepartmentT;

public interface DepartmentTMapper {


  public  DepartmentT selectByPrimaryKey(int id);
  public  List<DepartmentExt> selectList(RowBounds rowBounds);
  @Insert("  insert into department_t ( department_name, department_director_id) values"
  		+ " ( #{departmentName,jdbcType=CHAR}, #{departmentDirectorId,jdbcType=CHAR})")
  public int insert(DepartmentT t);
   
}