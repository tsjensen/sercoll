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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Immutable, serializable entry in an entry set. For internal use only.
 *
 * @param <K> key type
 * @param <V> value type
 * @author Thomas Jensen
 * @see SerializableUnmodifiableEntrySet
 */
final class SerializableUnmodifiableEntry<K extends Serializable, V extends Serializable>
    implements Map.Entry<K, V>, Serializable, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private final K iKey;

    private final V iValue;

    private final int iHashCode;

    private final String iString;



    SerializableUnmodifiableEntry(final Map.Entry<? extends K, ? extends V> pEntry)
    {
        iKey = pEntry.getKey();
        iValue = pEntry.getValue();
        iHashCode = pEntry.hashCode();
        iString = pEntry.toString();
    }



    @Override
    public K getKey()
    {
        return iKey;
    }



    @Override
    public V getValue()
    {
        return iValue;
    }



    @Override
    public V setValue(final V pValue)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public int hashCode()
    {
        return iHashCode;
    }



    @Override
    @SuppressWarnings("rawtypes")
    @SuppressFBWarnings(value = "NSE_NON_SYMMETRIC_EQUALS",
        justification = "False Positive, es ist tatsächlich symmetrisch.")
    public boolean equals(final Object pObject)
    {
        if (!(pObject instanceof Map.Entry)) {
            return false;
        }
        Map.Entry t = (Map.Entry) pObject;
        return eq(iKey, t.getKey()) && eq(iValue, t.getValue());
    }



    private boolean eq(final Object pObj1, final Object pObj2)
    {
        return pObj1 == null ? pObj2 == null : pObj1.equals(pObj2);
    }



    @Override
    public String toString()
    {
        return iString;
    }



    @Override
    @SuppressWarnings("unchecked")
    public SerializableUnmodifiableEntry<K, V> clone()
    {
        SerializableUnmodifiableEntry<K, V> result = null;
        try {
            result = (SerializableUnmodifiableEntry<K, V>) super.clone();
        }
        catch (CloneNotSupportedException e) {
            // cannot happen
            throw new IllegalStateException(e);
        }
        return result;
    }
}
