/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    
    private Float precioUnidad;
    private Integer size;
    private Float cantidad;
    private Float descuento;
    private Float total;
    private Product producto;
    private Pedido pedido;
    private Pago pago;
    
}
