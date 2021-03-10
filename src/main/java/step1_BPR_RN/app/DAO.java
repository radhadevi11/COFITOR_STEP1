package step1_BPR_RN.app;
import java.util.*;

public interface DAO<T> {
    T get(int id);
    List<T> getAll();
}
