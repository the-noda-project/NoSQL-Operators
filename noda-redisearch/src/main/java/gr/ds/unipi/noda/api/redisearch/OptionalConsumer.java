package gr.ds.unipi.noda.api.redisearch;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalConsumer<T> implements Consumer<Optional<T>> {
    private final Consumer<T> c;
    private final Runnable r;

    public OptionalConsumer(Consumer<T> c, Runnable r) {
        super();
        this.c = c;
        this.r = r;
    }

    public static <T> OptionalConsumer<T> of(Consumer<T> c, Runnable r) {
        return new OptionalConsumer(c, r);
    }

    @Override
    public void accept(Optional<T> t) {
        if (t.isPresent()) {
            c.accept(t.get());
        } else {
            r.run();
        }
    }
}
