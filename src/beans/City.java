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
    private Integer viewCount;

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

    @Basic
    @Column(name = "viewCount", nullable = true)
    public Integer getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(Integer viewCount)
    {
        this.viewCount = viewCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId &&
                Objects.equals(cName, city.cName) &&
                Objects.equals(viewCount, city.viewCount);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(cityId, cName, viewCount);
    }
}
