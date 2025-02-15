package br.marcuslima.exemplo.utils;

public class Coalesce {
    private Coalesce() {
    }

    /**
     * Returns the target value if it is not null, otherwise returns the fallback
     * value.
     *
     * @param <T>      the type of the values
     * @param target   the value to be checked for null
     * @param fallback the value to return if the target is null
     * @return the target value if it is not null, otherwise the fallback value
     */
    public static <T> T of(T target, T fallback) {
        return target != null ? target : fallback;
    }

}
