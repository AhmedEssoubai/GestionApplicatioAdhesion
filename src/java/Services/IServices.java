package Services;

import java.util.ArrayList;

/**
 *
 * @author Zed
 */
public interface IServices<T> {
     int add(T obj);
     T get(int id);
     ArrayList<T> getAll();
     boolean delete(T obj);
     boolean update(int id,T obj);          
}
