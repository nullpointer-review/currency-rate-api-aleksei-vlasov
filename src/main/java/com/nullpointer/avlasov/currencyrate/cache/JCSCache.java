package com.nullpointer.avlasov.currencyrate.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 * Created by Alex Vlasov on 15.10.15.
 */

public class JCSCache<K, V> {

    private JCS cache;

    public JCSCache(String name) throws CacheException {
        this.cache = JCS.getInstance(name);
    }

    public V get(K key) {
        return (V) cache.get(key);
    }

    public boolean put(K key, V value) {
        try {
            cache.put(key, value);
            return true;
        } catch (CacheException e) {
            return false;
        }
    }

    public void close() {
        cache.dispose();
    }
}