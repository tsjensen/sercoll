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
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Same as a {@link TreeMap}, except that this class promises to be fully serializable.
 *
 * @param <K> key type
 * @param <V> value type
 * @author Thomas Jensen
 */
public class SerializableTreeMap<K extends Serializable, V extends Serializable>
    extends TreeMap<K, V>
    implements SerializableSortedMap<K, V>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs a new, empty serializable tree map, using the natural ordering of its keys.  All keys inserted into
     * the map must implement the {@link Comparable} interface.  Furthermore, all such keys must be <i>mutually
     * comparable</i>: <tt>k1.compareTo(k2)</tt> must not throw a <tt>ClassCastException</tt> for any keys <tt>k1</tt>
     * and <tt>k2</tt> in the map.  If the user attempts to put a key into the map that violates this constraint (for
     * example, the user attempts to put a string key into a map whose keys are integers), the <tt>put(Object key,
     * Object value)</tt> call will throw a <tt>ClassCastException</tt>.
     */
    public SerializableTreeMap()
    {
        super();
    }



    /**
     * Constructs a new, empty tree map, ordered according to the given comparator.  All keys inserted into the map must
     * be <i>mutually comparable</i> by the given comparator: <tt>comparator.compare(k1, k2)</tt> must not throw a
     * <tt>ClassCastException</tt> for any keys <tt>k1</tt> and <tt>k2</tt> in the map.  If the user attempts to put a
     * key into the map that violates this constraint, the <tt>put(Object key, Object value)</tt> call will throw a
     * <tt>ClassCastException</tt>.
     *
     * @param pComparator the comparator that will be used to order this map. If <tt>null</tt>, the {@linkplain
     * Comparable natural ordering} of the keys will be used.
     */
    public SerializableTreeMap(@Nullable final SerializableComparator<? super K> pComparator)
    {
        super(pComparator);
    }



    /**
     * Constructs a new tree map containing the same mappings as the given map, ordered according to the <i>natural
     * ordering</i> of its keys. All keys inserted into the new map must implement the {@link Comparable} interface.
     * Furthermore, all such keys must be <i>mutually comparable</i>: <tt>k1.compareTo(k2)</tt> must not throw a
     * <tt>ClassCastException</tt> for any keys <tt>k1</tt> and <tt>k2</tt> in the map.  This method runs in n*log(n)
     * time.
     *
     * @param pMap the map whose mappings are to be placed in this map
     * @throws ClassCastException if the keys in m are not {@link Comparable}, or are not mutually comparable
     * @throws NullPointerException if the specified map is null
     */
    public SerializableTreeMap(@Nonnull final Map<? extends K, ? extends V> pMap)
    {
        super(pMap);
    }



    /**
     * Constructs a new tree map containing the same mappings and using the same ordering as the specified sorted map.
     * This method runs in linear time.
     *
     * @param pMap the sorted map whose mappings are to be placed in this map, and whose comparator is to be used to
     * sort this map
     * @throws NullPointerException if the specified map is null
     */
    public SerializableTreeMap(@Nonnull final SerializableSortedMap<K, ? extends V> pMap)
    {
        super(pMap);
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public SerializableTreeMap<K, V> clone()
    {
        return (SerializableTreeMap<K, V>) super.clone();
    }



    @Override
    @Nonnull
    public SerializableSortedSet<K> keySet()
    {
        return new SerializableTreeSet<K>(super.keySet());
    }



    @Override
    @Nonnull
    public SerializableCollection<V> values()
    {
        return new SerializableArrayList<V>(super.values());
    }



    @Override
    public SerializableComparator<? super K> comparator()
    {
        return (SerializableComparator<? super K>) super.comparator();
    }



    @Override
    public SerializableSortedMap<K, V> subMap(final K pFromKey, final K pToKey)
    {
        return new SerializableTreeMap<K, V>(super.subMap(pFromKey, pToKey));
    }



    @Override
    public SerializableSortedMap<K, V> headMap(final K pToKey)
    {
        return new SerializableTreeMap<K, V>(super.headMap(pToKey));
    }



    @Override
    public SerializableSortedMap<K, V> tailMap(final K pFromKey)
    {
        return new SerializableTreeMap<K, V>(super.tailMap(pFromKey));
    }
}
