package mx.edu.utez.examen2.controller.shop;


import mx.edu.utez.examen2.model.clothes.BeanClothes;
import mx.edu.utez.examen2.model.clothes.DaoClothes;
import mx.edu.utez.examen2.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/shop")
public class ShopServices {
    Map<String,Object> response = new HashMap<>();
    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanClothes> getAll() {
        return new DaoClothes().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanClothes getById(@PathParam("id")Long id) {
        return new DaoClothes().findById(id);
    }

    @POST
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})

    public Map<String, Object> save (BeanClothes clothes){
        System.out.println(clothes.getName());
        Response<BeanClothes> result = new DaoClothes().save(clothes);
        response.put("result",result);
        return  response;
    }

}
