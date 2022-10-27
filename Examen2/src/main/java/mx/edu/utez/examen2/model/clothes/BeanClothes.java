package mx.edu.utez.examen2.model.clothes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanClothes {

    private long idClotehes;
    private String name;
    private Double price ;
    private String size;
    private String brand;
    private int stock;
    private String cloth_type;
    private String created_at;
    private int status;
    private long idClotehesType;
    private long idCategory;

    public BeanClothes() {
    }
    public BeanClothes(long idClotehes, String name, Double price, String size, String brand, int stock, String cloth_type, String created_at, int status, long idClotehesType, long idCategory) {
        this.idClotehes = idClotehes;
        this.name = name;
        this.price = Double.valueOf(price);
        this.size = size;
        this.brand = brand;
        this.stock = stock;
        this.cloth_type = cloth_type;
        this.created_at = created_at;
        this.status = status;
        this.idClotehesType = idClotehesType;
        this.idCategory = idCategory;
    }

    public long getIdClotehes() {
        return idClotehes;
    }

    public void setIdClotehes(long idClotehes) {
        this.idClotehes = idClotehes;
    }

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
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCloth_type() {
        return cloth_type;
    }

    public void setCloth_type(String cloth_type) {
        this.cloth_type = cloth_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getIdClotehesType() {
        return idClotehesType;
    }

    public void setIdClotehesType(long idClotehesType) {
        this.idClotehesType = idClotehesType;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }
}
