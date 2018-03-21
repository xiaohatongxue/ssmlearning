package colin.com.student.po;

import java.io.Serializable;

public class TeacherT  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5293361890969724404L;

	private String teacherId;

    private String teacherName;

    private String teacherBothdate;

    private String departmentId;

    private Boolean teacherSexId;

    private String jobId;

    private Integer salary;

    private Byte partydues;

    private String passwd;

    private String mailbox;

    public TeacherT() {
		// TODO 自动生成的构造函数存根
	}
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherBothdate() {
        return teacherBothdate;
    }

    public void setTeacherBothdate(String teacherBothdate) {
        this.teacherBothdate = teacherBothdate == null ? null : teacherBothdate.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Boolean getTeacherSexId() {
        return teacherSexId;
    }

    public void setTeacherSexId(Boolean teacherSexId) {
        this.teacherSexId = teacherSexId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Byte getPartydues() {
        return partydues;
    }

    public void setPartydues(Byte partydues) {
        this.partydues = partydues;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }
}