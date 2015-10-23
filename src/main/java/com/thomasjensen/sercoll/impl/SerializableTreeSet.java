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
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.thomasjensen.sercoll.SerializableComparator;
import com.thomasjensen.sercoll.SerializableSortedSet;


/**
 * Same as a {@link TreeSet}, except that this class promises to be fully serializable.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public class SerializableTreeSet<E extends Serializable>
    extends TreeSet<E>
    implements SerializableSortedSet<E>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs a new, empty serializable tree set, sorted according to the natural ordering of its elements.  All
     * elements inserted into the set must implement the {@link Comparable} interface. Furthermore, all such elements
     * must be <i>mutually comparable</i>: {@code e1.compareTo(e2)} must not throw a {@code ClassCastException} for any
     * elements {@code e1} and {@code e2} in the set.  If the user attempts to add an element to the set that violates
     * this constraint (for example, the user attempts to add a string element to a set whose elements are integers),
     * the {@code add} call will throw a {@code ClassCastException}.
     */
    public SerializableTreeSet()
    {
        super();
    }



    /**
     * Constructs a new serializable tree set containing the elements in the specified collection, sorted according to
     * the <i>natural ordering</i> of its elements.  All elements inserted into the set must implement the {@link
     * Comparable} interface.  Furthermore, all such elements must be <i>mutually comparable</i>: {@code
     * e1.compareTo(e2)} must not throw a {@code ClassCastException} for any elements {@code e1} and {@code e2} in the
     * set.
     *
     * @param pCollection collection whose elements will comprise the new set
     * @throws ClassCastException if the elements in {@code pCollection} are not {@link Comparable}, or are not mutually
     * comparable
     * @throws NullPointerException if the specified collection is null
     */
    public SerializableTreeSet(@Nonnull final Collection<? extends E> pCollection)
    {
        super(pCollection);
    }



    /**
     * Constructs a new, empty serializable tree set, sorted according to the specified comparator.  All elements
     * inserted into the set must be <i>mutually comparable</i> by the specified comparator: {@code
     * comparator.compare(e1, e2)} must not throw a {@code ClassCastException} for any elements {@code e1} and {@code
     * e2} in the set.  If the user attempts to add an element to the set that violates this constraint, the {@code add}
     * call will throw a {@code ClassCastException}.
     *
     * @param pComparator the comparator that will be used to order this set. If {@code null}, the {@linkplain
     * Comparable natural ordering} of the elements will be used.
     */
    public SerializableTreeSet(@Nullable final SerializableComparator<? super E> pComparator)
    {
        super(pComparator);
    }



    /**
     * Constructs a new serializable tree set containing the same elements and using the same ordering as the specified
     * sorted set.
     *
     * @param pSortedSet sorted set whose elements will comprise the new set
     * @throws NullPointerException if the specified sorted set is null
     */
    public SerializableTreeSet(@Nonnull final SortedSet<E> pSortedSet)
    {
        super(pSortedSet);
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public SerializableTreeSet<E> clone()
    {
        return (SerializableTreeSet<E>) super.clone();
    }
}
