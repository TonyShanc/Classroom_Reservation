package db.model;

/**
 * У�⹫˾���������
 *
 * @author ����
 * @version 0.1
 */

public class CrCompanyRepre implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    String id = null;
    String name = null;
    String mail = null;
    String area = null;
    String companyName = null;
    String position = null;
    String password = null;

    public CrCompanyRepre() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getArea() {
        return area;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public String getPassword() {
        return password;
    }

}
