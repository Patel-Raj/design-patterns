package lld.cache;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class LruCacheTest extends TestCase {

    Cache<Integer, Integer> cache;

    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        cache = new CacheFactory<Integer, Integer>().getCache();
    }

    @Test
    public void testGetAndPut() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);

        assertEquals(5, (int) cache.get(5));
        assertEquals(4, (int) cache.get(4));
        assertEquals(3, (int) cache.get(3));
        assertEquals(2, (int) cache.get(2));
        assertEquals(1, (int) cache.get(1));

        cache.put(6, 6);
        assertNull(cache.get(5));
    }
}