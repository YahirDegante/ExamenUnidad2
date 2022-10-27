package mx.edu.utez.examen2.model.clothe_types;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanClothe_types {

    private long idClotehesType;
    private String nameClothesType;

    public BeanClothe_types() {
    }

    public BeanClothe_types(long idClotehesType, String nameClothesType) {
        this.idClotehesType = idClotehesType;
        this.nameClothesType = nameClothesType;
    }

    public long getIdClotehesType() {
        return idClotehesType;
    }

    public void setIdClotehesType(long idClotehesType) {
        this.idClotehesType = idClotehesType;
    }

    public String getNameClothesType() {
        return nameClothesType;
    }

    public void setNameClothesType(String nameClothesType) {
        this.nameClothesType = nameClothesType;
    }
}
