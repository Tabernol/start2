package dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    T get(long id);

    void update(Long id);

    void delete(String login);
}
