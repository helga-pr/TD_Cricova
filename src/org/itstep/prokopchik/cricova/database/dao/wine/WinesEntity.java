package org.itstep.prokopchik.cricova.database.dao.wine;

import org.itstep.prokopchik.cricova.*;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "wines", schema = "", catalog = "cricovadb")
public class WinesEntity extends DAOWine {
    private int idWine;
    private String nameWine;
    private int priceWine;
    private int ndsrateWine;
    private byte[] imageWine;
    private String annotationWine;
    private String wineType;
    private String wineColor;
    private String wineAge;
    private String wineSugarContent;
    private String wineSpiritContent;
    private String wineCollection;

    @Id
    @Column(name = "id_wine", nullable = false, insertable = true, updatable = true)
    public int getIdWine() {
        return idWine;
    }

    public void setIdWine(int idWine) {
        this.idWine = idWine;
    }

    @Basic
    @Column(name = "name_wine", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameWine() {
        return nameWine;
    }

    public void setNameWine(String nameWine) {
        this.nameWine = nameWine;
    }

    @Basic
    @Column(name = "price_wine", nullable = false, insertable = true, updatable = true)
    public int getPriceWine() {
        return priceWine;
    }

    public void setPriceWine(int priceWine) {
        this.priceWine = priceWine;
    }

    @Basic
    @Column(name = "ndsrate_wine", nullable = false, insertable = true, updatable = true)
    public int getNdsrateWine() {
        return ndsrateWine;
    }

    public void setNdsrateWine(int ndsrateWine) {
        this.ndsrateWine = ndsrateWine;
    }

    @Basic
    @Column(name = "image_wine", nullable = true, insertable = true, updatable = true)
    public byte[] getImageWine() {
        return imageWine;
    }

    public void setImageWine(byte[] imageWine) {
        this.imageWine = imageWine;
    }

    @Basic
    @Column(name = "annotation_wine", nullable = true, insertable = true, updatable = true, length = 254)
    public String getAnnotationWine() {
        return annotationWine;
    }

    public void setAnnotationWine(String annotationWine) {
        this.annotationWine = annotationWine;
    }

    @Basic
    @Column(name = "wine_type", nullable = false, insertable = true, updatable = true, length = 14)
    public String getWineType() {
        return wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }

    @Basic
    @Column(name = "wine_color", nullable = false, insertable = true, updatable = true, length = 5)
    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    @Basic
    @Column(name = "wine_age", nullable = false, insertable = true, updatable = true, length = 15)
    public String getWineAge() {
        return wineAge;
    }

    public void setWineAge(String wineAge) {
        this.wineAge = wineAge;
    }

    @Basic
    @Column(name = "wine_sugar_content", nullable = false, insertable = true, updatable = true, length = 10)
    public String getWineSugarContent() {
        return wineSugarContent;
    }

    public void setWineSugarContent(String wineSugarContent) {
        this.wineSugarContent = wineSugarContent;
    }

    @Basic
    @Column(name = "wine_spirit_content", nullable = false, insertable = true, updatable = true, length = 8)
    public String getWineSpiritContent() {
        return wineSpiritContent;
    }

    public void setWineSpiritContent(String wineSpiritContent) {
        this.wineSpiritContent = wineSpiritContent;
    }

    @Basic
    @Column(name = "wine_collection", nullable = false, insertable = true, updatable = true, length = 15)
    public String getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(String wineCollection) {
        this.wineCollection = wineCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinesEntity that = (WinesEntity) o;

        if (idWine != that.idWine) return false;
        if (ndsrateWine != that.ndsrateWine) return false;
        if (priceWine != that.priceWine) return false;
        if (annotationWine != null ? !annotationWine.equals(that.annotationWine) : that.annotationWine != null)
            return false;
        if (!Arrays.equals(imageWine, that.imageWine)) return false;
        if (nameWine != null ? !nameWine.equals(that.nameWine) : that.nameWine != null) return false;
        if (wineAge != null ? !wineAge.equals(that.wineAge) : that.wineAge != null) return false;
        if (wineCollection != null ? !wineCollection.equals(that.wineCollection) : that.wineCollection != null)
            return false;
        if (wineColor != null ? !wineColor.equals(that.wineColor) : that.wineColor != null) return false;
        if (wineSpiritContent != null ? !wineSpiritContent.equals(that.wineSpiritContent) : that.wineSpiritContent != null)
            return false;
        if (wineSugarContent != null ? !wineSugarContent.equals(that.wineSugarContent) : that.wineSugarContent != null)
            return false;
        if (wineType != null ? !wineType.equals(that.wineType) : that.wineType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWine;
        result = 31 * result + (nameWine != null ? nameWine.hashCode() : 0);
        result = 31 * result + priceWine;
        result = 31 * result + ndsrateWine;
        result = 31 * result + (imageWine != null ? Arrays.hashCode(imageWine) : 0);
        result = 31 * result + (annotationWine != null ? annotationWine.hashCode() : 0);
        result = 31 * result + (wineType != null ? wineType.hashCode() : 0);
        result = 31 * result + (wineColor != null ? wineColor.hashCode() : 0);
        result = 31 * result + (wineAge != null ? wineAge.hashCode() : 0);
        result = 31 * result + (wineSugarContent != null ? wineSugarContent.hashCode() : 0);
        result = 31 * result + (wineSpiritContent != null ? wineSpiritContent.hashCode() : 0);
        result = 31 * result + (wineCollection != null ? wineCollection.hashCode() : 0);
        return result;
    }

    @Override
    public Wine createWine(String name,
                           Integer price,
                           Integer ndsRate,
                           Object image,
                           String annotation,
                           WineTypeEnum wineType,
                           WineColorEnum wineColor,
                           WineAgeEnum wineAge,
                           WineSugarContentEnum wineSugarContent,
                           WineSpiritContentEnum wineSpiritContent,
                           WineCollectionEnum wineCollection) {
        return null;
    }

    @Override
    public Wine createWine(Wine wine) {
        return null;
    }

    @Override
    public Wine getWine(String name) {
        return null;
    }

    @Override
    public Wine getWineById(Integer id) {
        return null;
    }
}
