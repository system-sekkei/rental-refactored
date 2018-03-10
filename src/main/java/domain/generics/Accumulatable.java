package domain.generics;

public interface Accumulatable<T> {
    T add(T other);
}
