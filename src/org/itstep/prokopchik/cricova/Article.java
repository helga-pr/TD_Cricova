package org.itstep.prokopchik.cricova;

/**
 * класс используется ддя нзаполнения страниц index.jsp и products_view.jsp статьями
 */
public class Article {

    private Integer id;
    /**
     * название статьи
     */
    private String name;
    /**
     * контент (текст, изображение)
     */
    private String content;


    /**
     *? путь к файлу ? имя файла в БД
     * в БД применен тип BLOB (может хранить до 64 килобайт информации)
     */
    private Object image;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (!content.equals(article.content)) return false;
        if (!id.equals(article.id)) return false;
        if (!name.equals(article.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
