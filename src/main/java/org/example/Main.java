package org.example;

import entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin(); //Para comenzar la conexion con la base de datos

            /*
            Categoria categoria1= Categoria.builder()
                    .denominacion("Bebidas")
                    .build();

            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("San Juan")
                    .numero(2030)
                    .build();

            Cliente cliente1 = Cliente.builder()
                    .dni(24567899)
                    .nombre("Nicolas")
                    .apellido("Ocampo")
                    .domicilio(domicilio1)
                    .build();

            domicilio1.setCliente(cliente1);


            Articulo coca500ml= Articulo.builder()
                    .cantidad(10)
                    .denominacion("Coca 500ml")
                    .precio(60)
                    .build();

            Articulo sprite500ml= Articulo.builder()
                    .cantidad(20)
                    .denominacion("sprite 500ml")
                    .precio(60)
                    .build();

            categoria1.getArticulos().add(sprite500ml);
            categoria1.getArticulos().add(coca500ml);
            sprite500ml.getCategorias().add(categoria1);
            coca500ml.getCategorias().add(categoria1);

            Factura factura1= Factura.builder()
                    .fecha("06/09/2024")
                    .numero(1)
                    .total(1200)
                    .cliente(cliente1)
                    .build();

            DetalleFactura detalle1 = DetalleFactura.builder()
                    .cantidad(1)
                    .subtotal(60)
                    .articulo(coca500ml)
                    .factura(factura1)
                    .build();

            DetalleFactura detalle2 = DetalleFactura.builder()
                    .cantidad(2)
                    .subtotal(120)
                    .articulo(sprite500ml)
                    .factura(factura1)
                    .build();

            factura1.getDetallesFactura().add(detalle1);
            factura1.getDetallesFactura().add(detalle2);

            coca500ml.getDetallesFactura().add(detalle1);
            sprite500ml.getDetallesFactura().add(detalle2);


            em.persist(factura1);

            */

            Factura factura1= em.find(Factura.class,1L);
            factura1.setNumero(10);
            em.merge(factura1);

            /*
            Articulo articulo= em.find(Articulo.class,2L);
            System.out.println(articulo.getDenominacion());
            articulo.setPrecio(70);
            em.merge(articulo);
            */


            em.flush();

            em.getTransaction().commit();

            em.close();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace(System.out);
            System.out.println("ERROR");
        }
    }
}