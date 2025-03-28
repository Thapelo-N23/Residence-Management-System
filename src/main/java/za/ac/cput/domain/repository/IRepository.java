package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Residence;

import java.util.Set;

public interface IRepository<T, ID> {
    T create (T t);
    T read (ID id);
    T update (T t);
    boolean delete (String id);
    Set<T> getAll ();
}
