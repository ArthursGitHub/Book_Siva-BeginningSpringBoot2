package netgloo.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity. Repository annotation allows the component scanning support to find and
 * configure the DAO wihtout any XML configuration and also provide the Spring exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDao {

  @PersistenceContext
  private EntityManager entityManager;


  public void create(User user) {
    entityManager.persist(user);
    return;
  }

  public void update(User user) {
    entityManager.merge(user);
    return;
  }

  public void delete(User user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
    else
      entityManager.remove(entityManager.merge(user));
    return;
  }

  @SuppressWarnings("unchecked")
  public List<User> getAll() {
    return entityManager.createQuery("from User").getResultList();
  }

  public User getByEmail(String email) {
    return (User) entityManager.createQuery(
            "from User where email = :email")
            .setParameter("email", email)
            .getSingleResult();
  }

  public User getById(long id) {
    return entityManager.find(User.class, id);
  }
}
