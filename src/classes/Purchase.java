/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Customer;
import entity.History;
import entity.Product;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class Purchase {
 private Customer customer;
    private Product product;
    private Integer quantity;

    public Purchase() {
    }

    public Purchase(Customer customer, Product product, Integer quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }
    public boolean doPurchase(){
        History history = new History();
        history.setCustomer(customer);
        history.setNum(quantity);
        history.setProduct(product);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
               customer.setMoney(customer.getMoney()-product.getPrice()*quantity);
               product.setQuantity(product.getQuantity()-quantity);
               em.merge(customer);
               em.merge(product);
               em.persist(history);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }finally {
            em.close();
            emf.close();
        }
    }
    public boolean doPurchase(Customer customer, Product product, Integer quantity){
        Calendar date = new GregorianCalendar();
        
        History history = new History();
        history.setTransactionDate(date.getTime());
        history.setCustomer(customer);
        history.setNum(quantity);
        history.setProduct(product);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
        EntityManager em = emf.createEntityManager();
        try {
            if ((customer.getMoney() - product.getPrice()*quantity)>=customer.getMoney()&&((product.getQuantity()-quantity)>0)){
            em.getTransaction().begin();
               customer.setMoney(customer.getMoney()-product.getPrice()*quantity);
               product.setQuantity(product.getQuantity()-quantity);
               em.merge(customer);
               em.merge(product);
               em.persist(history);
            em.getTransaction().commit();
            return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }finally {
            em.close();
            emf.close();
        }
    }
}

