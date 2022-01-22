package dao;

import java.util.List;

public interface IDao<T> {
	
		boolean create(T o);

	    boolean delete(T o);

	    boolean update(T o);
	    
	    boolean approve(String id);

	    T findById(int id);
	    
	    T findByEmailAndPassword(String email, String password);
	    
	    T findAdmin(String email, String password);

	    List<T> findAll();

}
