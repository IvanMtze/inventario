package com.mycompany.inventario.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

        @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(
            name = "productos_proveedores",
            joinColumns = {@JoinColumn(name = "producto_id")},
            inverseJoinColumns = {@JoinColumn(name = "proveedor_id")}
    )
    private List<Proveedor> proveedores;
    public String toString(){
        return this.nombre;
    }
}
