package beans;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel
{
    private int hotelId;
    private String hName;
    private String description;
    private BigDecimal avgPrice;
    private int cityId;
    private String pictures;
    private int viewCount;

    @Id
    @Column(name = "HotelID", nullable = false)
    public int getHotelId()
    {
        return hotelId;
    }

    public void setHotelId(int hotelId)
    {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "HName", nullable = false, length = 100)
    public String gethName()
    {
        return hName;
    }

    public void sethName(String hName)
    {
        this.hName = hName;
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
    @Column(name = "AvgPrice", nullable = false, precision = 2)
    public BigDecimal getAvgPrice()
    {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice)
    {
        this.avgPrice = avgPrice;
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
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                cityId == hotel.cityId &&
                viewCount == hotel.viewCount &&
                Objects.equals(hName, hotel.hName) &&
                Objects.equals(description, hotel.description) &&
                Objects.equals(avgPrice, hotel.avgPrice) &&
                Objects.equals(pictures, hotel.pictures);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(hotelId, hName, description, avgPrice, cityId, pictures, viewCount);
    }

    @Override
    public String toString()
    {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hName='" + hName + '\'' +
                ", description='" + description + '\'' +
                ", avgPrice=" + avgPrice +
                ", cityId=" + cityId +
                ", pictures='" + pictures + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}
