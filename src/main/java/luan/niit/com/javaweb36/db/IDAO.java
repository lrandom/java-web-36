package luan.niit.com.javaweb36.db;

import java.util.ArrayList;

public interface IDAO<T> {
    public ArrayList<T> list();

    public T get(int id);

    public boolean remove(int id);

    public T update(int id, T newT);

    public T add(T t);

    public int getLastId();
}
