package beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @Author: LiuLou
 * @Description:
 * @Date: Created in 15:16 2018/6/12
 * @Modified By:
 */
@Entity
public class Users {
    private String email;
    private String uPass;
    private String uName;
    private int state = 1;
    private Timestamp dor = new Timestamp(System.currentTimeMillis());
    private String profile;

    @Id
    @Column(name = "Email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "UPass", nullable = false, length = 100)
    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    @Basic
    @Column(name = "UName", nullable = true, length = 100)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "State", nullable = true)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "DOR", nullable = false)
    public Timestamp getDor() {
        return dor;
    }

    public void setDor(Timestamp dor) {
        this.dor = dor;
    }

    @Basic
    @Column(name = "profile", nullable = true, length = 100)
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (state != users.state) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (uPass != null ? !uPass.equals(users.uPass) : users.uPass != null) return false;
        if (uName != null ? !uName.equals(users.uName) : users.uName != null) return false;
        if (dor != null ? !dor.equals(users.dor) : users.dor != null) return false;
        if (profile != null ? !profile.equals(users.profile) : users.profile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (uPass != null ? uPass.hashCode() : 0);
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (dor != null ? dor.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }
}
