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
        //Here's an example of configuring annotation-driven spring context
        //please verify it
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();

        //get entity manager factory from spring context
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        //create entity manager
        EntityManager em = emf.createEntityManager();
        return em;
    }
/*    public static String find(int value){

        UserInfo user1=getEm().find(UserInfo.class, BigInteger.valueOf(value));
        return user1.toString();
    }  */
}
