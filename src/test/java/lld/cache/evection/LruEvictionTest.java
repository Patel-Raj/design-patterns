package lld.cache.evection;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class LruEvictionTest extends TestCase {

    EvictionPolicy<Integer> evictionPolicy;

    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        evictionPolicy = new LruEviction<>();
    }

    @Test
    public void testEvict() {
        evictionPolicy.keyAccessed(1);
        assertEquals(1, (int) evictionPolicy.evict());
        evictionPolicy.keyAccessed(1);
        assertEquals(1, (int) evictionPolicy.evict());
        assertNull(evictionPolicy.evict());
    }

    @Test
    public void testKeyAccessed() {
        evictionPolicy.keyAccessed(1);
        evictionPolicy.keyAccessed(2);
        evictionPolicy.keyAccessed(3);
        evictionPolicy.keyAccessed(1);

        assertEquals(2, (int) evictionPolicy.evict());
        assertEquals(3, (int) evictionPolicy.evict());
        assertEquals(1, (int) evictionPolicy.evict());
    }
}