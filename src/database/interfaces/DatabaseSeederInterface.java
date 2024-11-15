package database.interfaces;

import java.util.HashMap;

public interface DatabaseSeederInterface<E> {
    HashMap<String, E> seed();
}
