package service;

import java.util.List;

public interface IBaseService <T, ID>{
	public T findById(ID id);
	public List<T> findAll();
	public void create(T elemento);
	public T update(T elemento);
	public void delete(T elemento);
}
