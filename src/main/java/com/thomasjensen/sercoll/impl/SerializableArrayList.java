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

import javax.annotation.Nonnull;

import com.thomasjensen.sercoll.SerializableList;


/**
 * Same as an {@link ArrayList}, except that this class promises to be fully serializable.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public class SerializableArrayList<E extends Serializable>
    extends ArrayList<E>
    implements SerializableList<E>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public SerializableArrayList()
    {
        super();
    }



    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param pInitialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public SerializableArrayList(final int pInitialCapacity)
    {
        super(pInitialCapacity);
    }



    /**
     * Constructs a list containing the elements of the specified collection, in the order they are returned by the
     * collection's iterator.
     *
     * @param pCollection the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public SerializableArrayList(@Nonnull final Collection<? extends E> pCollection)
    {
        super(pCollection);
    }



    @Override
    @Nonnull
    public SerializableList<E> subList(final int pFromIndex, final int pToIndex)
    {
        return new SerializableArrayList<E>(super.subList(pFromIndex, pToIndex));
    }



    @Override
    @Nonnull
    @SuppressWarnings("unchecked")
    public SerializableArrayList<E> clone()
    {
        return (SerializableArrayList<E>) super.clone();
    }
}
