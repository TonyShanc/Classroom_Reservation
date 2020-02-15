package db.model;

/**
 * ѧ��������
 *
 * @author ����
 * @version 0.1
 */

public class CrStudent implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id = null;
    private String mail = null;
    private String name = null;
    private String password = null;
    private String stu_type = null;
    private String enrollment = null;
    private String dept_name = null;

    public CrStudent() {

    }

    public void setStuType(String stu_type) {
        this.stu_type = stu_type;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public void setDeptName(String dept_name) {
        this.dept_name = dept_name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDeptName() {
        return dept_name;
    }

    public String getStuType() {
        return stu_type;
    }

    public String getEnrollment() {
        return enrollment;
    }

}
