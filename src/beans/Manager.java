package beans;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager
{
    private int mid;
    private String mPass;

    @Id
    @Column(name = "MID", nullable = false)
    public int getMid()
    {
        return mid;
    }

    public void setMid(int mid)
    {
        this.mid = mid;
    }

    @Basic
    @Column(name = "MPass", nullable = false, length = 100)
    public String getmPass()
    {
        return mPass;
    }

    public void setmPass(String mPass)
    {
        this.mPass = mPass;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return mid == manager.mid &&
                Objects.equals(mPass, manager.mPass);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(mid, mPass);
    }

    @Override
    public String toString()
    {
        return "Manager{" +
                "mid=" + mid +
                ", mPass='" + mPass + '\'' +
                '}';
    }
}
