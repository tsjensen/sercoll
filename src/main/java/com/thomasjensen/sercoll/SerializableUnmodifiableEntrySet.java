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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Same as an <em>unmodifiable</em> entry set, except that this class promises to be fully serializable. Intended only
 * for internal use by the {@link SerializableUnmodifiableHashMap}.
 *
 * @param <K> key type
 * @param <V> value type
 * @author Thomas Jensen
 * @see SerializableUnmodifiableHashMap
 */
final class SerializableUnmodifiableEntrySet<K extends Serializable, V extends Serializable>
    extends HashSet<Map.Entry<K, V>>
    implements Cloneable
{
    private static final long serialVersionUID = 1L;



    /**
     * Constructs a new, empty unmodifiable entry set.
     */
    SerializableUnmodifiableEntrySet()
    {
        super(1);
    }



    /**
     * Constructs a new unmodifiable entry set containing the elements in the specified entry set.  The backing
     * <tt>HashMap</tt> is created with default load factor (0.75) and an initial capacity sufficient to contain the
     * elements in the specified collection.
     *
     * @param pEntrySet the entry set whose elements are to be placed into this entry set
     * @throws NullPointerException if the specified entry set is <code>null</code>
     */
    @SuppressWarnings("unchecked")
    SerializableUnmodifiableEntrySet(@Nonnull final Set<? extends Map.Entry<? extends K, ? extends V>> pEntrySet)
    {
        super();
        for (Map.Entry<? extends K, ? extends V> entry : pEntrySet) {
            super.add((Map.Entry<K, V>) entry);
        }
    }



    @Override
    public Iterator<Map.Entry<K, V>> iterator()
    {
        final Iterator<Map.Entry<K, V>> superIter = super.iterator();
        return new Iterator<Map.Entry<K, V>>()
        {
            @Override
            public boolean hasNext()
            {
                return superIter.hasNext();
            }



            @Override
            public Map.Entry<K, V> next()
            {
                return new SerializableUnmodifiableEntry<K, V>(superIter.next());
            }



            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public Object[] toArray()
    {
        Object[] result = super.toArray();
        for (int i = 0; i < result.length; i++) {
            result[i] = new SerializableUnmodifiableEntry<K, V>((Map.Entry<K, V>) result[i]);
        }
        return result;
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(final T[] pArray)
    {
        T[] result = super.toArray(pArray);
        for (int i = 0; i < result.length; i++) {
            result[i] = (T) new SerializableUnmodifiableEntry<K, V>((Map.Entry<K, V>) result[i]);
        }
        return result;
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pEntry ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean add(@Nullable final Map.Entry<K, V> pEntry)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pObject ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean remove(@Nullable final Object pObject)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pCollection ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean addAll(@Nonnull final Collection<? extends Map.Entry<K, V>> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pCollection ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean retainAll(@Nonnull final Collection<?> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pCollection ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean removeAll(@Nonnull final Collection<?> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public SerializableUnmodifiableEntrySet<K, V> clone()
    {
        return (SerializableUnmodifiableEntrySet<K, V>) super.clone();
    }
}
