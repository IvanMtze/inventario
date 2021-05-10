package com.mycompany.inventario.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author wuser
 */
@Entity
@Data
@Table(name="productos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    private String nombre;
    private String unit;
    private Category categoria;
    private List<Proveedor> proveedores;
}
