package dao;

import java.util.List;

public interface IBaseDao <T, ID>{
	public List<T> findAll();
	public T findById(ID id);
	public void persist(T elemento);
	public T merge(T elemento);
	public void remove(T daCancellare);
}
