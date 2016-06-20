package org.itstep.prokopchik.cricova;

abstract class Product {

    private String name;
    private Double price;
    private Double ndsRate;
    private String image;
    private String annotation;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price > 0)
            this.price = price;
    }

    public Double getNdsRate() {
        return ndsRate;
    }

    public void setNdsRate(Double ndsRate) {
        if (ndsRate >= 0)
            this.ndsRate = ndsRate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        if (!ndsRate.equals(product.ndsRate)) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        return annotation.equals(product.annotation);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + ndsRate.hashCode();
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + annotation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ndsRate=" + ndsRate +
                ", image='" + image + '\'' +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
