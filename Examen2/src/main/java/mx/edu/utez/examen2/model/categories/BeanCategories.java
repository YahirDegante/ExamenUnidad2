package mx.edu.utez.examen2.model.categories;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanCategories {
    private long idCategory;
    private String name;

    public BeanCategories() {
    }

    public BeanCategories(long id, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
