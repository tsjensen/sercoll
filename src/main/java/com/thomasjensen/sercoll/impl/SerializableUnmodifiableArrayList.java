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
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.thomasjensen.sercoll.SerializableList;


/**
 * Same as an <em>unmodifiable</em> {@link ArrayList}, except that this class promises to be fully serializable.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public final class SerializableUnmodifiableArrayList<E extends Serializable>
    extends ArrayList<E>
    implements SerializableList<E>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs an unmodifiable empty list.
     */
    public SerializableUnmodifiableArrayList()
    {
        super(1);
    }



    /**
     * Constructs a Singleton collection.
     *
     * @param pSingleItem the single element ever contained in this collection
     */
    public SerializableUnmodifiableArrayList(@Nullable final E pSingleItem)
    {
        super(1);
        super.add(pSingleItem);
    }



    /**
     * Constructs an unmodifiable list containing the elements of the specified collection, in the order they are
     * returned by the collection's iterator.
     *
     * @param pCollection the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is <code>null</code>
     */
    public SerializableUnmodifiableArrayList(@Nonnull final Collection<? extends E> pCollection)
    {
        super(pCollection);
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pIndex ignored parameter
     * @param pElement ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    @CheckForNull
    public E set(final int pIndex, @Nullable final E pElement)
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
    public boolean add(@Nullable final E pElement)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pIndex ignored parameter
     * @param pElement ignored parameter
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public void add(final int pIndex, @Nullable final E pElement)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pIndex ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    @CheckForNull
    public E remove(final int pIndex)
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
    public boolean remove(@Nullable final Object pElement)
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
    public boolean addAll(@Nonnull final Collection<? extends E> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pIndex ignored parameter
     * @param pCollection ignored parameter
     * @return never
     *
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean addAll(final int pIndex, @Nonnull final Collection<? extends E> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pFromIndex ignored parameter
     * @param pToIndex ignored parameter
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    protected void removeRange(final int pFromIndex, final int pToIndex)
    {
        throw new UnsupportedOperationException();
    }



    /**
     * This operation is not supported by the unmodifiable collection.
     *
     * @param pCollection ignored parameter
     * @return never
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public boolean removeAll(@Nonnull final Collection<?> pCollection)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    @Nonnull
    public ListIterator<E> listIterator()
    {
        return new UnmodifiableListIterator<E>(super.listIterator());
    }



    @Override
    @Nonnull
    public ListIterator<E> listIterator(final int pIndex)
    {
        return new UnmodifiableListIterator<E>(super.listIterator(pIndex));
    }



    @Override
    @Nonnull
    public SerializableList<E> subList(final int pFromIndex, final int pToIndex)
    {
        return new SerializableUnmodifiableArrayList<E>(super.subList(pFromIndex, pToIndex));
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public SerializableUnmodifiableArrayList<E> clone()
    {
        return (SerializableUnmodifiableArrayList<E>) super.clone();
    }
}
