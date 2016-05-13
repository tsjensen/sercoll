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
import java.util.Iterator;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Similar to an <em>unmodifiable</em> {@link TreeSet}, except that this class promises to be fully serializable. Note
 * that this implementation adds the elements of the original TreeSet instead of providing a view on it. In this way,
 * the set becomes truly structurally unmodifiable, but may incur a higher runtime cost. This is required because
 * keeping a reference to a backing set would impede serializability.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public final class SerializableUnmodifiableTreeSet<E extends Serializable>
    extends TreeSet<E>
    implements SerializableNavigableSet<E>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs the immutable empty set. <p>Consider using {@link SerializableCollections#emptySet()} instead for
     * better performance.</p>
     */
    public SerializableUnmodifiableTreeSet()
    {
        super();
    }



    /**
     * Constructor for a Singleton collection.
     *
     * @param pSingleItem the only element ever to be contained in this set
     */
    public SerializableUnmodifiableTreeSet(@Nullable final E pSingleItem)
    {
        super();
        super.add(pSingleItem);
    }



    /**
     * Constructor which adds the elements of the specified collection to the new serializable unmodifiable TreeSet,
     * using the elements' natural ordering.
     *
     * @param pCollection a collection (may contain <code>null</code> values)
     */
    public SerializableUnmodifiableTreeSet(@Nonnull final Collection<? extends E> pCollection)
    {
        super(pCollection);
    }



    /**
     * Constructor which adds the elements of the specified collection to the new serializable unmodifiable TreeSet,
     * retaining the given set's ordering.
     *
     * @param pSortedSet the backing sorted set, which must have a serializable comparator
     */
    public SerializableUnmodifiableTreeSet(@Nonnull final SerializableSortedSet<E> pSortedSet)
    {
        super(pSortedSet.comparator());
        addAll(pSortedSet);
    }



    @Override
    public Iterator<E> iterator()
    {
        return new UnmodifiableIterator<E>(super.iterator());
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pElement ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean add(final E pElement)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pElement ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean remove(final Object pElement)
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



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pCollection ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean removeAll(final Collection<?> pCollection)
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
    public boolean addAll(final Collection<? extends E> pCollection)
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
    public boolean retainAll(final Collection<?> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    @SuppressWarnings("unchecked")
    public SerializableUnmodifiableTreeSet<E> clone()
    {
        return (SerializableUnmodifiableTreeSet<E>) super.clone();
    }



    @Override
    public Iterator<E> descendingIterator()
    {
        return new UnmodifiableIterator<E>(super.descendingIterator());
    }



    @Override
    public SerializableNavigableSet<E> descendingSet()
    {
        return new SerializableUnmodifiableTreeSet<E>(super.descendingSet());
    }



    @Override
    public SerializableNavigableSet<E> subSet(final E pFromElement, final boolean pFromInclusive, final E pToElement,
        final boolean pToInclusive)
    {
        return new SerializableUnmodifiableTreeSet<E>(super.subSet(pFromElement, pFromInclusive, pToElement,
            pToInclusive));
    }



    @Override
    public SerializableNavigableSet<E> headSet(final E pToElement, final boolean pInclusive)
    {
        return new SerializableUnmodifiableTreeSet<E>(super.headSet(pToElement, pInclusive));
    }



    @Override
    public SerializableNavigableSet<E> tailSet(final E pFromElement, final boolean pInclusive)
    {
        return new SerializableUnmodifiableTreeSet<E>(super.tailSet(pFromElement, pInclusive));
    }



    @Override
    public SerializableSortedSet<E> subSet(final E pFromElement, final E pToElement)
    {
        return new SerializableUnmodifiableTreeSet<E>(super.subSet(pFromElement, pToElement));
    }



    @Override
    public SerializableSortedSet<E> headSet(final E pToElement)
    {
        return new SerializableUnmodifiableTreeSet<E>(super.headSet(pToElement));
    }



    @Override
    public SerializableSortedSet<E> tailSet(final E pFromElement)
    {
        return new SerializableUnmodifiableTreeSet<E>(super.tailSet(pFromElement));
    }



    @Override
    public SerializableComparator<? super E> comparator()
    {
        return (SerializableComparator<? super E>) super.comparator();
    }
}
