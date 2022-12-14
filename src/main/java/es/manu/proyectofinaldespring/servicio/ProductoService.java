package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IProductoService;
import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.repositorios.ProductoRepository;
import es.manu.proyectofinaldespring.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

     @Autowired
     private ProductoRepository ProductoRepository;

    @Override
    public List<Producto> listar() {
        return ProductoRepository.findAll();
    }


    @Override
    public Producto findById(Long id) {
        return ProductoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return ProductoRepository.save(producto);
    }

    @Override
    public Producto delete(Producto producto) {
        Producto resultado = findById(producto.getId());
        ProductoRepository.delete(resultado);
        return resultado;
    }

    @Override
    public List<Producto> productosId(List<Long> ids){
        return ProductoRepository.findAllById(ids);
    }

    @Override
    public List<Producto> buscador(String cadena) {
        return ProductoRepository.findByTituloContainsOrMaterialContains(cadena, cadena);
    }

    @Override
    public List<Producto> findByMarca_IdIsNotNull() {
        return ProductoRepository.findByMarca_IdIsNotNull();
    }

    @Override
    public List<Producto> productosDeUnaCompra(Compra c){
        return ProductoRepository.findByCompra(c);
    }

    @Override
    public List<Producto> findByMarca_IdEquals(Long id){
        return ProductoRepository.findByMarca_IdEquals(id);
    }
}
