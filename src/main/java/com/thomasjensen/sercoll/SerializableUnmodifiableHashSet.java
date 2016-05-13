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

import javax.annotation.Nullable;


/**
 * Same as an <em>unmodifiable</em> {@link HashSet}, except that this class promises to be fully serializable.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public final class SerializableUnmodifiableHashSet<E extends Serializable>
    extends HashSet<E>
    implements SerializableSet<E>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructor.
     */
    public SerializableUnmodifiableHashSet()
    {
        super(1);
    }



    /**
     * Constructor for a Singleton collection.
     *
     * @param pSingleItem the only element ever to be contained in this set
     */
    public SerializableUnmodifiableHashSet(@Nullable final E pSingleItem)
    {
        super(1, 1f);
        super.add(pSingleItem);
    }



    /**
     * Constructor.
     *
     * @param pCollection a collection (may contain <code>null</code> values)
     */
    public SerializableUnmodifiableHashSet(final Collection<? extends E> pCollection)
    {
        super();
        for (E elem : pCollection) {
            super.add(elem);
        }
    }



    @Override
    public Iterator<E> iterator()
    {
        return new UnmodifiableIterator<E>(super.iterator());
    }



    @Override
    public boolean add(final E pElement)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean remove(final Object pElement)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean removeAll(final Collection<?> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean addAll(final Collection<? extends E> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean retainAll(final Collection<?> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    @SuppressWarnings("unchecked")
    public SerializableUnmodifiableHashSet<E> clone()
    {
        return (SerializableUnmodifiableHashSet<E>) super.clone();
    }
}
