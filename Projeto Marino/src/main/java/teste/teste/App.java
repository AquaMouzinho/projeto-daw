package teste.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("te");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Teste t = new Teste();
        manager.persist(t);
        manager.getTransaction().commit();
    }
}
