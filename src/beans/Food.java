package beans;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food
{
    private int foodId;
    private String fName;
    private String description;
    private BigDecimal avgPrice;
    private int cityId;
    private String pictures;
    private int viewCount;

    @Id
    @Column(name = "FoodID", nullable = false)
    public int getFoodId()
    {
        return foodId;
    }

    public void setFoodId(int foodId)
    {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "FName", nullable = false, length = 100)
    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
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
        Food food = (Food) o;
        return foodId == food.foodId &&
                cityId == food.cityId &&
                viewCount == food.viewCount &&
                Objects.equals(fName, food.fName) &&
                Objects.equals(description, food.description) &&
                Objects.equals(avgPrice, food.avgPrice) &&
                Objects.equals(pictures, food.pictures);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(foodId, fName, description, avgPrice, cityId, pictures, viewCount);
    }

    @Override
    public String toString()
    {
        return "Food{" +
                "foodId=" + foodId +
                ", fName='" + fName + '\'' +
                ", description='" + description + '\'' +
                ", avgPrice=" + avgPrice +
                ", cityId=" + cityId +
                ", pictures='" + pictures + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}
