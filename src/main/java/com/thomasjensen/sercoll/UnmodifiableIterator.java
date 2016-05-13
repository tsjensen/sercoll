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
import java.util.Iterator;


/**
 * Unmodifiable implementation of {@link Iterator}.
 * <p/>
 * <b>Caution:</b> This class is <em>not</em> itself serializable, because it is not easily possible (and would not make
 * sense) to create serializable iterators.
 *
 * @param <E> element type
 * @author Thomas Jensen
 */
public final class UnmodifiableIterator<E extends Serializable>
    implements Iterator<E>
{
    private final Iterator<E> iter;



    /**
     * Constructor.
     *
     * @param pIter something to iterate over
     */
    public UnmodifiableIterator(final Iterator<E> pIter)
    {
        iter = pIter;
    }



    @Override
    public boolean hasNext()
    {
        return iter.hasNext();
    }



    @Override
    public E next()
    {
        return iter.next();
    }



    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
