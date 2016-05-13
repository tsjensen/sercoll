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
import java.util.ListIterator;
import javax.annotation.Nonnull;


/**
 * Unmodifiable implementation of {@link ListIterator}.
 * <p/>
 * <b>Caution:</b> This class is <em>not</em> itself serializable, because it is not easily possible (and would not make
 * sense) to create serializable iterators.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public final class UnmodifiableListIterator<E extends Serializable>
    implements ListIterator<E>
{
    @Nonnull
    private final ListIterator<E> listIter;



    /**
     * Constructor.
     *
     * @param pIter a list iterator
     */
    @SuppressWarnings("ConstantConditions")
    public UnmodifiableListIterator(@Nonnull final ListIterator<E> pIter)
    {
        listIter = pIter;
        if (pIter == null) {
            throw new IllegalArgumentException("wrapped iterator is null");
        }
    }



    @Override
    public boolean hasNext()
    {
        return listIter.hasNext();
    }



    @Override
    public E next()
    {
        return listIter.next();
    }



    @Override
    public boolean hasPrevious()
    {
        return listIter.hasPrevious();
    }



    @Override
    public E previous()
    {
        return listIter.previous();
    }



    @Override
    public int nextIndex()
    {
        return listIter.nextIndex();
    }



    @Override
    public int previousIndex()
    {
        return listIter.previousIndex();
    }



    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public void set(final E pElement)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public void add(final E pElement)
    {
        throw new UnsupportedOperationException();
    }
}
