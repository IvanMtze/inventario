/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author wuser
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalles_pedido")
public class DetallePedido implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private Product producto;
    private Proveedor proveedor;
    private Double precioUnidad;
    private String size;
    private Double cantidad;
    private Double descuento;
    private Double total;

    
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;
    
    private Pago pago;

}
