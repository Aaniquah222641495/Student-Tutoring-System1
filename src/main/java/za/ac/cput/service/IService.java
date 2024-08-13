package za.ac.cput.service;

import java.util.List;

public interface IService<T,ID>{
    public T create(T object);
    public T read(ID id);
    public T update(T object);
    public void delete(ID id);
    public List<T> getAll();
}
