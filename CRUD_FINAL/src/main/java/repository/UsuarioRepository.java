package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import models.UsuarioEntity;
import utils.HibernateUtils;

import java.util.List;

public class UsuarioRepository {

    public UsuarioRepository() {

    }

    public void addUser(UsuarioEntity usuario) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<UsuarioEntity> getAllUsers() {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<UsuarioEntity> result = entityManager.createQuery( "from UsuarioEntity", UsuarioEntity.class ).getResultList();
        entityManager.close();
        return result;
    }

    public UsuarioEntity getUserByID(int id) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UsuarioEntity usuario = entityManager.find(UsuarioEntity.class, id);
        return usuario;
    }

    public void updateUser(UsuarioEntity usuario) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeUser(UsuarioEntity usuario) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(usuario));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
