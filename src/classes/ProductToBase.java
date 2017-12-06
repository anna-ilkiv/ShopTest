/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Customer;
import entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class ProductToBase {
    private String name;
    private Integer price;
    private Integer quantity;

    public ProductToBase() {
    }

    public ProductToBase(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    
    public boolean addProduct(){
    
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
        EntityManager em = emf.createEntityManager();
        Product p = new Product(name, price, quantity);
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            return false;
        }finally{
            em.close();
            emf.close();
        }
    
    }
    
    public boolean addProduct(String name,Integer price,Integer quantity){
    
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
        EntityManager em = emf.createEntityManager();
        Product p = new Product(name, price, quantity);
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            return false;
        }finally{
            em.close();
            emf.close();
        }
    
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
   
    
}
