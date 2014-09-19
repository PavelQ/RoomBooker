package ru.qupol;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Pavl on 13.03.14.
 */
public class emHelper {
    public static EntityManager getEm(){
        //Set up Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();

        //get entity manager factory from spring context
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        //create entity manager
        EntityManager em = emf.createEntityManager();
        return em;
    }

}
