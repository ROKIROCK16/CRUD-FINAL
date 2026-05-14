package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import models.SolicitudesEntity;
import models.UsuarioEntity;
import utils.HibernateUtils;

import java.util.List;

public class SolicitudRepository {

    public SolicitudRepository(){

    }

    public void addSolicitud(SolicitudesEntity solicitud) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(solicitud);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<SolicitudesEntity> getAllSolicitudes() {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<SolicitudesEntity> result = entityManager.createQuery( "from SolicitudesEntity", SolicitudesEntity.class ).getResultList();
        entityManager.close();
        return result;
    }

    public SolicitudesEntity getSolicitudByID(int id) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SolicitudesEntity solicitud = entityManager.find(SolicitudesEntity.class, id);
        return solicitud;
    }

    public void updateSolicitud(SolicitudesEntity solicitud) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(solicitud);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeSolicitud(SolicitudesEntity solicitud) {
        EntityManagerFactory entityManagerFactory = HibernateUtils.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(solicitud));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
