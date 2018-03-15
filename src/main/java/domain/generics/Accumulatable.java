package domain.generics;

/**
 * 加算可能
 * @param <T>
 */
public interface Accumulatable<T> {
    T add(T other);
}
