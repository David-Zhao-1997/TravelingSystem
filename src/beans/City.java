package beans;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City
{
    private int cityId;
    private String cName;

    @Id
    @Column(name = "CityID", nullable = false)
    public int getCityId()
    {
        return cityId;
    }

    public void setCityId(int cityId)
    {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CName", nullable = false, length = 100)
    public String getcName()
    {
        return cName;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId &&
                Objects.equals(cName, city.cName);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(cityId, cName);
    }

    @Override
    public String toString()
    {
        return "City{" +
                "cityId=" + cityId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
