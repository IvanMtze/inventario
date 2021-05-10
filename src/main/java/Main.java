

import com.mycompany.inventario.Entity.Product;
import com.mycompany.inventario.dao.ProductRepository;

/**
 *
 * @author wuser
 */
public class Main {
    public static void main(String[] args){

        Product p = new Product();
        p.setNombre("Descr");

        
        ProductRepository productRepository = new ProductRepository();
        productRepository.create(p);
        for(Product producto : productRepository.findAll())
            System.out.println(producto.getNombre());
        p.setNombre("mi otra descripcion");
        productRepository.update(p);
        for(Product producto : productRepository.findAll())
            System.out.println(producto.getNombre());
    }
}
