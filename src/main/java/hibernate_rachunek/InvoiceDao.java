package hibernate_rachunek;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class InvoiceDao {
    private EntityDao entityDao = new EntityDao();

    public List<Invoice> getAllUnpaid() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Invoice> query = cb.createQuery(Invoice.class);

            Root<Invoice> root = query.from(Invoice.class);

            query.select(root).where(
                    cb.equal(root.get("ifPaid"), 0));

            return session.createQuery(query).getResultList();
        }
    }

    public List<Invoice> getAllFromLastWeek() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Invoice> query = cb.createQuery(Invoice.class);

            Root<Invoice> root = query.from(Invoice.class);

            query.select(root).where(
                    cb.between(
                            root.get("dateOfCreation"),
                            LocalDateTime.now().minusDays(7),
                            LocalDateTime.now()
                    )
            );

            return session.createQuery(query).getResultList();
        }
    }
}
