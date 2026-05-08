package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import models.DireccionEntity;
import utils.HibernateUtils;

public class DireccionRepository {

    public DireccionRepository() {

    }

    public void addDireccion(DireccionEntity direccion) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(direccion);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeDireccion(DireccionEntity direccion) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(direccion));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
