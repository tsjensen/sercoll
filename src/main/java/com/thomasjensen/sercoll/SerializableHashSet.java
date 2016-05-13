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
import javax.annotation.Nonnull;


/**
 * Same as a {@link HashSet}, except that this class promises to be fully serializable.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public class SerializableHashSet<E extends Serializable>
    extends HashSet<E>
    implements SerializableSet<E>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has default initial capacity (16) and load
     * factor (0.75).
     */
    public SerializableHashSet()
    {
        super();
    }



    /**
     * Constructs a new set containing the elements in the specified collection.  The backing <tt>HashMap</tt> is
     * created with default load factor (0.75) and an initial capacity sufficient to contain the elements in the
     * specified collection.
     *
     * @param pCollection the collection whose elements are to be placed into this set
     * @throws NullPointerException if the specified collection is null
     */
    public SerializableHashSet(@Nonnull final Collection<? extends E> pCollection)
    {
        super(pCollection);
    }



    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has the specified initial capacity and the
     * specified load factor.
     *
     * @param pInitialCapacity the initial capacity of the hash map
     * @param pLoadFactor the load factor of the hash map
     * @throws IllegalArgumentException if the initial capacity is less than zero, or if the load factor is nonpositive
     */
    public SerializableHashSet(final int pInitialCapacity, final float pLoadFactor)
    {
        super(pInitialCapacity, pLoadFactor);
    }



    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has the specified initial capacity and default
     * load factor (0.75).
     *
     * @param pInitialCapacity the initial capacity of the hash table
     * @throws IllegalArgumentException if the initial capacity is less than zero
     */
    public SerializableHashSet(final int pInitialCapacity)
    {
        super(pInitialCapacity);
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public SerializableHashSet<E> clone()
    {
        return (SerializableHashSet<E>) super.clone();
    }
}
