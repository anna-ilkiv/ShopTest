/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import classes.CustomerToBase;
import classes.ProductToBase;
import classes.Purchase;
import classes.Repository;
import classes.SingletonEM;
import entity.Customer;
import entity.Product;

/**
 *
 * @author pupil
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                SingletonEM sem = SingletonEM.getInstanse();
        
        CustomerToBase newCustomer = new CustomerToBase();
        newCustomer.addCustomer("Ivan", "Ivanov", 60, "Kohtla-Järve", "372234564");
        newCustomer.addCustomer("Adnrey", "Sokolov", 50, "Jõhvi", "372534534");
        newCustomer.addCustomer("Dmitriy", "Petrov", 100, "Kohtla-Järve", "372756543");
     
        ProductToBase newProduct = new ProductToBase();
        newProduct.addProduct("Молоко", 1, 40);
        newProduct.addProduct("Бананы", 3, 60);
        
        Repository r = new Repository();
        Customer customer = r.customerByNameSurname("Ivan", "Ivanov"); 
        Product product = r.getProductByName("Молоко");
        Purchase purchase = new Purchase();
        if(product != null && customer != null){
            System.out.println("Состояние продукта до покупки: "+product.toString());
            System.out.println("Состояние покупателя до покупки: "+customer.toString());
            purchase.doPurchase(customer, product, 2);
            System.out.println("Состояние продукта после покупки: "+product.toString());
            System.out.println("Состояние покупателя после покупки: "+customer.toString());
        }else{
            System.out.println("Покупку совершить не удалось");
        }
        
        sem.close();
    }
        
        
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPU");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//
//            //ПОЛЬЗОВАТЕЛИ
//            Customer customer1 = new Customer("Ivan", "Ivanov", 60, "Kohtla-Järve", "372234564");
//            em.persist(customer1);
//
//            Customer customer2 = new Customer("Adnrey", "Sokolov", 50, "Jõhvi", "372534534");
//            em.persist(customer2);
//
//            Customer customer3 = new Customer("Dmitriy", "Petrov", 100, "Kohtla-Järve", "372756543");
//            em.persist(customer3);
//
//            Customer customer4 = new Customer("Aleksey", "Molotov", 130, "Tallinn", "372645864");
//            em.persist(customer4);
//
//            Customer customer5 = new Customer("Evgeniy", "Kostilev", 220, "Kohtla-Järve", "372940324");
//            em.persist(customer5);
//
//            //ТОВАРЫ
//            Product product1 = new Product("Молоко", 1, 40);
//            em.persist(product1);
//
//            Product product2 = new Product("Бананы", 3, 60);
//            em.persist(product2);
//
//            Product product3 = new Product("Помидоры", 2, 80);
//            em.persist(product3);
//
//            Product product4 = new Product("Курица", 7, 20);
//            em.persist(product4);
//
//            Product product5 = new Product("Колбаса", 4, 35);
//            em.persist(product5);
//
//            Calendar date = new GregorianCalendar();
//
//            //ИСТОРИЯ
//            //ПЕРВЫЙ ПОЛЬЗОВАТЕЛЬ
//            History history1 = new History(date.getTime(), customer1, product1, 1);
//            em.persist(history1);
//
//            History history2 = new History(date.getTime(), customer1, product2, 1);
//            em.persist(history2);
//
//            History history3 = new History(date.getTime(), customer1, product3, 1);
//            em.persist(history3);
//
//            History history3_1 = new History(date.getTime(), customer1, product3, 1);
//            em.persist(history3_1);
//
//            History history4 = new History(date.getTime(), customer1, product4, 1);
//            em.persist(history4);
//
//            //ВТОРОЙ ПОЛЬЗОВАТЕЛЬ
//            History history5 = new History(date.getTime(), customer2, product1, 1);
//            em.persist(history5);
//
//            History history6 = new History(date.getTime(), customer2, product2, 1);
//            em.persist(history6);
//
//            //ТРЕТИЙ ПОЛЬЗОВАТЕЛЬ
//            History history7 = new History(date.getTime(), customer3, product3, 1);
//            em.persist(history7);
//
//            History history8 = new History(date.getTime(), customer3, product4, 1);
//            em.persist(history8);
//
//            //ЧЕТВЁРТЫЙ ПОЛЬЗОВАТЕЛЬ
//            History history9 = new History(date.getTime(), customer4, product1, 1);
//            em.persist(history9);
//
//            History history10 = new History(date.getTime(), customer4, product3, 1);
//            em.persist(history10);
//
//            History history11 = new History(date.getTime(), customer4, product5, 1);
//            em.persist(history11);
//
//            //ПЯТЫЙ ПОЛЬЗОВАТЕЛЬ
//            History history12 = new History(date.getTime(), customer5, product1, 1);
//            em.persist(history12);
//
//            History history13 = new History(date.getTime(), customer5, product3, 1);
//            em.persist(history13);
//
//            History history14 = new History(date.getTime(), customer5, product4, 1);
//            em.persist(history14);
//
//            em.getTransaction().commit();
//
//            /*em.getTransaction().begin();*/
//
// /*String city = "Kohtla-Järve";
//
//            List<History> historyList = em.createQuery("SELECT h FROM History h WHERE h.customer.city=:city ORDER BY h.transactionDate ASC")
//                    .setParameter("city", city)
//                    .getResultList();
//
//            em.getTransaction().commit();
//
//            HashSet<Customer> customerSet = new HashSet();
//
//            for (int i = 0; i < historyList.size(); i++) {
//                History history = historyList.get(i);
//                customerSet.add(history.getCustomer());
//            }
//            System.out.println("");
//            System.out.printf("Покупатели из города %s: ", city);
//            Iterator iter = customerSet.iterator();
//
//            while (iter.hasNext()) {
//                Customer customerFromCity = (Customer) iter.next();
//                System.out.printf("Покупатель %s купил:%n", customerFromCity);
//                Double sum = 0.0;
//                Double price = 0.0;
//                for (int i = 0; i < historyList.size(); i++) {
//                    History history = historyList.get(i);
//                    if (customerFromCity.equals(history.getCustomer())) {
//                        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy h:m:s");
//                        price = history.getProduct().getPrice().doubleValue() / 100;
//                        System.out.println(format1.format(history.getTransactionDate()) + " " + history.getProduct().getName() + " - " + history.getNum() + " шт. по цене: ");
//                        sum += history.getProduct().getPrice() * history.getNum();
//
//                    }
//                }
//                System.out.printf("Затратил: %.2f EUR%n%n", sum / 100);
//             */
//            em.getTransaction().begin();
//
//            String name = "Помидоры";
//
//            List<History> historyList = em.createQuery("SELECT h FROM History h WHERE h.product.name=:name")
//                    .setParameter("name", name)
//                    .getResultList();
//
//            HashSet<Customer> pomidoricustomer = new HashSet();
//            
//
//            for (int i = 0; i < historyList.size(); i++) {
//                History history = historyList.get(i);
//                pomidoricustomer.add(history.getCustomer());
//                //System.out.println(history.getCustomer().getName() + " " + history.getCustomer().getSurname());
//            }
//            
//            Iterator pomidoricust = pomidoricustomer.iterator();
//            
//            while (pomidoricust.hasNext()) {
//                Customer pomidori = (Customer) pomidoricust.next();
//                System.out.println(pomidori.getName() + " " + pomidori.getSurname());
//                
//            }
//            
//            /*}*/
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//            emf.close();
//        }
    }


