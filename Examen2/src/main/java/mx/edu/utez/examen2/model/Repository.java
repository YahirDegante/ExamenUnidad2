package mx.edu.utez.examen2.model;

import mx.edu.utez.examen2.utils.Response;

import java.util.List;

public interface Repository<T> /*Pasa un clase para usarlos en los metodos de la app*/{
    List<T> findAll();
    T findById(Long id);
    Response<T> save(T object);
    Response<T> update(T object);
    Response delete(Long id);
}

