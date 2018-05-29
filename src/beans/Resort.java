package beans;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resort
{
    private int resortId;
    private String rName;
    private String description;
    private BigDecimal price;
    private int cityId;
    private String pictures;
    private int viewCount;

    @Id
    @Column(name = "ResortID", nullable = false)
    public int getResortId()
    {
        return resortId;
    }

    public void setResortId(int resortId)
    {
        this.resortId = resortId;
    }

    @Basic
    @Column(name = "RName", nullable = false, length = 100)
    public String getrName()
    {
        return rName;
    }

    public void setrName(String rName)
    {
        this.rName = rName;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 1000)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 2)
    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    @Basic
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
    @Column(name = "Pictures", nullable = false, length = 2147483647)
    public String getPictures()
    {
        return pictures;
    }

    public void setPictures(String pictures)
    {
        this.pictures = pictures;
    }

    @Basic
    @Column(name = "ViewCount", nullable = false)
    public int getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(int viewCount)
    {
        this.viewCount = viewCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resort resort = (Resort) o;
        return resortId == resort.resortId &&
                cityId == resort.cityId &&
                viewCount == resort.viewCount &&
                Objects.equals(rName, resort.rName) &&
                Objects.equals(description, resort.description) &&
                Objects.equals(price, resort.price) &&
                Objects.equals(pictures, resort.pictures);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(resortId, rName, description, price, cityId, pictures, viewCount);
    }

    @Override
    public String toString()
    {
        return "Resort{" +
                "resortId=" + resortId +
                ", rName='" + rName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cityId=" + cityId +
                ", pictures='" + pictures + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}
