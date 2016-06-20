package org.itstep.prokopchik.cricova;

public class Wine extends Product {

    /**
     * тип вина (тихое или игристое)
     */
    private WineTypeEnum wineType;

    /**
     * цвет вина (белое красное или розовое)
     */
    private WineColorEnum wineColor;
    /**
     * выдержка вина (ординарное, выдержанное, коллекционное)
     */
    private WineAgeEnum wineAge;
    /**
     * вид вина по содержанию сахара (брют (для игристых вин), сухое, полусухое, полусладкое, сладкое)
     */
    private WineSugarContentEnum wineSugarContent;
    /**
     * вид вина по содержанию спирта в объемных процентах (6 %об, 9 %об, 9-11 %об и т.д.)
     */
    private WineSpiritContentEnum wineSpiritContent;
    /**
     * к какой коллекции (по оформлению бутылки, этикетки) относится (например, "Кружева", "Cramele", "Папирус", "Старокриковское")
     */
    private WineCollectionEnum wineCollection;

    /**
     * конструктор по умолчанию
     */
    public Wine() {
    }

    /**
     * getters & setters
     */
    public WineTypeEnum getWineType() {
        return wineType;
    }

    public void setWineType(WineTypeEnum wineType) {
        this.wineType = wineType;
    }

    public WineColorEnum getWineColor() {
        return wineColor;
    }

    public void setWineColor(WineColorEnum wineColor) {
        this.wineColor = wineColor;
    }

    public WineAgeEnum getWineAge() {
        return wineAge;
    }

    public void setWineAge(WineAgeEnum wineAge) {
        this.wineAge = wineAge;
    }

    public WineSugarContentEnum getWineSugarContent() {
        return wineSugarContent;
    }

    public void setWineSugarContent(WineSugarContentEnum wineSugarContent) {
        this.wineSugarContent = wineSugarContent;
    }

    public WineSpiritContentEnum getWineSpiritContent() {
        return wineSpiritContent;
    }

    public void setWineSpiritContent(WineSpiritContentEnum wineSpiritContent) {
        this.wineSpiritContent = wineSpiritContent;
    }

    public WineCollectionEnum getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(WineCollectionEnum wineCollection) {
        this.wineCollection = wineCollection;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "wineType=" + wineType +
                ", wineColor=" + wineColor +
                ", wineAge=" + wineAge +
                ", wineSugarContent=" + wineSugarContent +
                ", wineSpiritContent=" + wineSpiritContent +
                ", wineCollection=" + wineCollection +
                '}';
    }

    /**
     * override methods
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Wine wine = (Wine) o;

        if (wineAge != wine.wineAge) return false;
        if (wineCollection != wine.wineCollection) return false;
        if (wineColor != wine.wineColor) return false;
        if (wineSpiritContent != wine.wineSpiritContent) return false;
        if (wineSugarContent != wine.wineSugarContent) return false;
        if (wineType != wine.wineType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + wineType.hashCode();
        result = 31 * result + wineColor.hashCode();
        result = 31 * result + wineAge.hashCode();
        result = 31 * result + wineSugarContent.hashCode();
        result = 31 * result + wineSpiritContent.hashCode();
        result = 31 * result + (wineCollection != null ? wineCollection.hashCode() : 0);
        return result;
    }

}
