package za.co.entelect.challenge.engine.loader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class GameEngineClassLoader {
    public <T> T loadEngineObject(Class<T> cl) {
        final ServiceLoader<T> loader = ServiceLoader.load(cl);
        final Iterator<T> iterator = loader.iterator();
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Couldn't find implementation for " + cl.toString() + " on the classpath.");
        }
        return iterator.next();
    }
}