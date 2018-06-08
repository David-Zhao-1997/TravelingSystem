package beans;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users
{
    private String email;
    private String uPass;
    private String uName;
    private int state;
    private Timestamp dor;
    private String profile;

    @Id
    @Column(name = "Email", nullable = false, length = 100)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "UPass", nullable = false, length = 100)
    public String getuPass()
    {
        return uPass;
    }

    public void setuPass(String uPass)
    {
        this.uPass = uPass;
    }

    @Basic
    @Column(name = "UName", nullable = true, length = 100)
    public String getuName()
    {
        return uName;
    }

    public void setuName(String uName)
    {
        this.uName = uName;
    }

    @Basic
    @Column(name = "State", nullable = false)
    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    @Basic
    @Column(name = "DOR", nullable = false)
    public Timestamp getDor()
    {
        return dor;
    }

    public void setDor(Timestamp dor)
    {
        this.dor = dor;
    }

    @Basic
    @Column(name = "profile", nullable = true, length = 100)
    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return state == users.state &&
                Objects.equals(email, users.email) &&
                Objects.equals(uPass, users.uPass) &&
                Objects.equals(uName, users.uName) &&
                Objects.equals(dor, users.dor) &&
                Objects.equals(profile, users.profile);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(email, uPass, uName, state, dor, profile);
    }
}
