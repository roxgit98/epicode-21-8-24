package davideGiliberti.dao;

import davideGiliberti.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Evento found = em.find(Evento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("eliminato");
            } else System.out.println("non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
