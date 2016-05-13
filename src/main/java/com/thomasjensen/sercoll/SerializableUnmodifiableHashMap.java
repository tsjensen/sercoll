package com.thomasjensen.sercoll;
/*
 * sercoll - Java Collections declared Serializable
 * Copyright (c) 2015 Thomas Jensen
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for
 * the specific language governing permissions and limitations under the License.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;


/**
 * Same as an <em>unmodifiable</em> {@link HashMap}, except that this class promises to be fully serializable.
 * <p/>
 * The wrapped sets are stored locally in order to improve performance. This is <code>transient</code> in order to avoid
 * double serialization. After deserialization, that local state is lazily reinitialized.
 *
 * @param <K> key type
 * @param <V> value type
 * @author Thomas Jensen
 */
public final class SerializableUnmodifiableHashMap<K extends Serializable, V extends Serializable>
    extends HashMap<K, V>
    implements SerializableMap<K, V>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private transient SerializableSet<K> ourKeySet = null;

    private transient SerializableCollection<V> ourValueList = null;

    private transient Set<Map.Entry<K, V>> ourEntrySet = null;



    /**
     * Constructor.
     */
    public SerializableUnmodifiableHashMap()
    {
        super(1);
        ourKeySet = getSuperKeySet();
        ourValueList = getSuperValues();
        ourEntrySet = getSuperEntrySet();
    }



    /**
     * Constructor of a Singleton map.
     *
     * @param pKey the sole key to be stored in the returned map
     * @param pValue the value to which the returned map maps key
     */
    public SerializableUnmodifiableHashMap(@Nullable final K pKey, @Nullable final V pValue)
    {
        super(1, 1f);
        super.put(pKey, pValue);
        ourKeySet = getSuperKeySet();
        ourValueList = getSuperValues();
        ourEntrySet = getSuperEntrySet();
    }



    /**
     * Constructor.
     *
     * @param pMap a different map
     */
    public SerializableUnmodifiableHashMap(final Map<K, V> pMap)
    {
        super(pMap);
        ourKeySet = getSuperKeySet();
        ourValueList = getSuperValues();
        ourEntrySet = getSuperEntrySet();
    }



    @Override
    public V put(final K pKey, final V pValue)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public void putAll(final Map<? extends K, ? extends V> pMap)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public V remove(final Object pKey)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    @SuppressWarnings("unchecked")
    public SerializableUnmodifiableHashMap<K, V> clone()
    {
        return (SerializableUnmodifiableHashMap<K, V>) super.clone();
    }



    @Override
    public SerializableSet<K> keySet()
    {
        if (ourKeySet == null) {
            ourKeySet = getSuperKeySet();
        }
        return ourKeySet;
    }



    @Override
    public SerializableCollection<V> values()
    {
        if (ourValueList == null) {
            ourValueList = getSuperValues();
        }
        return ourValueList;
    }



    /**
     * {@inheritDoc}
     * <p/>
     * The resulting Set is serializable. Serializability cannot be declared, because Map.Entry is not declared
     * serializable. However, the result of this method can safely be cast to something serializable.
     */
    @Override
    public Set<Map.Entry<K, V>> entrySet()
    {
        if (ourEntrySet == null) {
            ourEntrySet = getSuperEntrySet();
        }
        return ourEntrySet;
    }



    private SerializableSet<K> getSuperKeySet()
    {
        SerializableSet<K> result = null;
        if (size() > 0) {
            result = new SerializableUnmodifiableHashSet<K>(super.keySet());
        }
        else {
            result = new SerializableUnmodifiableHashSet<K>();
        }
        return result;
    }



    private SerializableCollection<V> getSuperValues()
    {
        SerializableCollection<V> result = null;
        if (size() > 0) {
            result = new SerializableUnmodifiableArrayList<V>(super.values());
        }
        else {
            result = new SerializableUnmodifiableArrayList<V>();
        }
        return result;
    }



    private Set<Map.Entry<K, V>> getSuperEntrySet()
    {
        Set<Map.Entry<K, V>> result = null;
        if (size() > 0) {
            result = new SerializableUnmodifiableEntrySet<K, V>(super.entrySet());
        }
        else {
            result = new SerializableUnmodifiableEntrySet<K, V>();
        }
        return result;
    }
}
