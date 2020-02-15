package db.model;

/**
 * ��ʦ������
 *
 * @author ����
 * @version 0.1
 */
public class CrTeacher implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id = null;
    private String mail = null;
    private String name = null;
    private String password = null;
    private String dept_name = null;

    public CrTeacher() {

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

}
