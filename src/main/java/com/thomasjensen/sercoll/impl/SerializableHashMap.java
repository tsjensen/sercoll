package com.thomasjensen.sercoll.impl;
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
import javax.annotation.Nonnull;

import com.thomasjensen.sercoll.SerializableCollection;
import com.thomasjensen.sercoll.SerializableMap;
import com.thomasjensen.sercoll.SerializableSet;


/**
 * Same as a {@link HashMap}, except that this class promises to be fully serializable.
 *
 * @param <K> key type
 * @param <V> value type
 * @author Thomas Jensen
 */
public class SerializableHashMap<K extends Serializable, V extends Serializable>
    extends HashMap<K, V>
    implements SerializableMap<K, V>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs an empty <tt>SerializableHashMap</tt> with the default initial capacity (16) and the default load
     * factor (0.75).
     */
    public SerializableHashMap()
    {
        super();
    }



    /**
     * Constructs an empty <tt>SerializableHashMap</tt> with the specified initial capacity and load factor.
     *
     * @param pInitialCapacity the initial capacity
     * @param pLoadFactor the load factor
     * @throws IllegalArgumentException if the initial capacity is negative or the load factor is nonpositive
     */
    public SerializableHashMap(final int pInitialCapacity, final float pLoadFactor)
    {
        super(pInitialCapacity, pLoadFactor);
    }



    /**
     * Constructs an empty <tt>SerializableHashMap</tt> with the specified initial capacity and the default load factor
     * (0.75).
     *
     * @param pInitialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public SerializableHashMap(final int pInitialCapacity)
    {
        super(pInitialCapacity);
    }



    /**
     * Constructs a new <tt>SerializableHashMap</tt> with the same mappings as the specified <tt>Map</tt>.  The
     * <tt>SerializableHashMap</tt> is created with default load factor (0.75) and an initial capacity sufficient to
     * hold the mappings in the specified <tt>Map</tt>.
     *
     * @param pMap the map whose mappings are to be placed in this map
     * @throws NullPointerException if the specified map is null
     */
    public SerializableHashMap(@Nonnull final Map<? extends K, ? extends V> pMap)
    {
        super(pMap);
    }



    @Override
    @SuppressWarnings("unchecked")
    public SerializableHashMap<K, V> clone()
    {
        return (SerializableHashMap<K, V>) super.clone();
    }



    @Override
    public SerializableSet<K> keySet()
    {
        return new SerializableHashSet<K>(super.keySet());
    }



    @Override
    public SerializableCollection<V> values()
    {
        return new SerializableArrayList<V>(super.values());
    }
}
