/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class CustomerToBase {
    private String name;
    private String surname;
    private int money;
    private String phone;
    private String city;

    
    public CustomerToBase() {
    }
    
    public CustomerToBase(String name, String surname, int money, String phone, String city) {
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.phone = phone;
        this.city = city;
    }

    
    public boolean addCustomer(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
        EntityManager em = emf.createEntityManager();
        Customer c = new Customer(name, surname, money,city,phone);
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            return false;
        }finally{
            em.close();
            emf.close();
        }
    }
    
    public boolean addCustomer(String name, String surname, int money, String phone, String city){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
        EntityManager em = emf.createEntityManager();
        Customer c = new Customer(name, surname, money,city,phone);
        try{
            em.getTransaction().begin();
            em.persist(c);
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
