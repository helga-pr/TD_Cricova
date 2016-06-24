package org.itstep.prokopchik.cricova;

abstract class Product {

    private Integer id;
    private String name;
    private Integer price;
    private Integer ndsRate;
    private Object image;
    private String annotation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price > 0)
            this.price = price;
    }

    public Integer getNdsRate() {
        return ndsRate;
    }

    public void setNdsRate(Integer ndsRate) {
        this.ndsRate = ndsRate;
    }

    public Object getImage() {
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
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (annotation != null ? !annotation.equals(product.annotation) : product.annotation != null) return false;
        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        if (!ndsRate.equals(product.ndsRate)) return false;
        if (!price.equals(product.price)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + ndsRate.hashCode();
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ndsRate=" + ndsRate +
                ", image=" + image +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
