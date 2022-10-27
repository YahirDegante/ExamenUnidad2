package mx.edu.utez.examen2.model.clothes;

import mx.edu.utez.examen2.model.Repository;
import mx.edu.utez.examen2.model.categories.BeanCategories;
import mx.edu.utez.examen2.model.clothe_types.BeanClothe_types;
import mx.edu.utez.examen2.utils.MySQLConnection;
import mx.edu.utez.examen2.utils.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoClothes implements Repository<BeanClothes> {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanClothes> findAll() {
        List<BeanClothes> clothes = new ArrayList<>();
        BeanClothes cloth = null;
        BeanClothe_types type = null;
        BeanCategories category = null;
        try {
            conn = client.getConnection();
            String query = "SELECT cl.*, ca.name,ct.name from clothes cl JOIN categories ca JOIN clothe_types ct ON ca.id = cl.category_id AND ct.id = cl.clothe_type_id";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                cloth = new BeanClothes();
                type = new BeanClothe_types();
                category = new BeanCategories();
                cloth.setIdClotehes(rs.getLong("id"));
                cloth.setName(rs.getString("name"));
                cloth.setPrice(rs.getDouble("price"));
                cloth.setSize(rs.getString("size"));
                cloth.setBrand(rs.getString("brand"));
                cloth.setStock(rs.getInt("stock"));
                cloth.setCloth_type(rs.getString("cloth_type"));
                cloth.setCreated_at(rs.getString("created_at"));
                cloth.setStatus(rs.getInt("status"));
                type.setIdClotehesType(rs.getLong("category_id"));
                category.setIdCategory(rs.getLong("clothe_type_id"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE, "Error -> findAll"+e.getMessage());
        }finally {
            client.close(conn,pstm,rs);
        }
        return clothes;
    }
    @Override
    public BeanClothes findById(Long id) {
        BeanClothes cloth = null;
        BeanClothe_types type = null;
        BeanCategories category = null;
        try {
            conn = client.getConnection();
            String query = "SELECT cl.*, ca.name,ct.name from clothes cl JOIN categories ca JOIN clothe_types ct ON ca.id = cl.category_id AND ct.id = cl.clothe_type_id WHERE cl.id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()){
                cloth = new BeanClothes();
                type = new BeanClothe_types();
                category = new BeanCategories();
                cloth.setIdClotehes(rs.getLong("id"));
                cloth.setName(rs.getString("name"));
                cloth.setPrice(rs.getDouble("price"));
                cloth.setSize(rs.getString("size"));
                cloth.setBrand(rs.getString("brand"));
                cloth.setStock(rs.getInt("stock"));
                cloth.setCloth_type(rs.getString("cloth_type"));
                cloth.setCreated_at(rs.getString("created_at"));
                cloth.setStatus(rs.getInt("status"));
                type.setIdClotehesType(rs.getLong("category_id"));
                category.setIdCategory(rs.getLong("clothe_type_id"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE, "Error -> findAll"+e.getMessage());
        }finally {
            client.close(conn,pstm,rs);
        }
        return cloth;
    }

    public Response save(BeanClothes clothes) {
        try {
            conn = client.getConnection();
            String query = "INSERT INTO personal(id,name,price,size,brand,stock,cloth_type,created_at,status)"+
                    "VALUES (?,?,?,?,?,?,?,?,?)";

            pstm = conn.prepareStatement(query);
            pstm.setString(1, clothes.getName());
            pstm.setDouble(2, clothes.getPrice());
            pstm.setString(3, clothes.getSize());
            pstm.setString(4, clothes.getBrand());
            pstm.setInt(5, clothes.getStock());
            pstm.setString(6, clothes.getCloth_type());
            pstm.setString(7, clothes.getCreated_at());
            pstm.setInt(8,clothes.getStatus());
            if (pstm.executeUpdate()==1){
                return new Response<>(200,"Registro Correctamente",clothes,false);
            }else {
                return new Response<>(200,"ERROR al registrar",clothes,true);
            }


        }catch (SQLException e){
            Logger.getLogger(DaoClothes.class.getName())
                    .log(Level.SEVERE,"ERROR- -> save "+e.getMessage());
            return  new Response<>(400,"Error con el servidor",null,true);
        }finally {
            client.close(conn,pstm,rs);
        }
    }
    }

    @Override
    public Response update(BeanClothes object) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
}
