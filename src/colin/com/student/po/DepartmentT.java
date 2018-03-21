package colin.com.student.po;

import java.io.Serializable;


public class DepartmentT implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7259471376299483240L;

	private int id;

    private String departmentName;

    private String departmentDirectorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentDirectorId() {
        return departmentDirectorId;
    }

    public void setDepartmentDirectorId(String departmentDirectorId) {
        this.departmentDirectorId = departmentDirectorId == null ? null : departmentDirectorId.trim();
    }
}