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
import java.util.EnumMap;

import com.thomasjensen.sercoll.SerializableCollection;
import com.thomasjensen.sercoll.SerializableMap;
import com.thomasjensen.sercoll.SerializableSet;

import javax.annotation.Nonnull;


/**
 * Same as an {@link EnumMap}, except that this class promises to be fully serializable.
 *
 * @author Thomas Jensen
 * @param <K> key type
 * @param <V> value type
 */
public class SerializableEnumMap<K extends Enum<K>, V extends Serializable>
    extends EnumMap<K, V>
    implements SerializableMap<K, V>, Cloneable
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;



    /**
     * Creates an empty enum map with the specified key type.
     *
     * @param pKeyType the class object of the key type for this enum map
     * @throws NullPointerException if <tt>pKeyType</tt> is null
     */
    public SerializableEnumMap(@Nonnull final Class<K> pKeyType)
    {
        super(pKeyType);
    }



    /**
     * Creates an enum map with the same key type as the specified enum map, initially containing the same mappings (if
     * any).
     *
     * @param pMap the enum map from which to initialize this enum map
     * @throws NullPointerException if <tt>pMap</tt> is null
     */
    public SerializableEnumMap(@Nonnull final EnumMap<K, V> pMap)
    {
        super(pMap);
    }



    @Override
    @Nonnull
    public SerializableEnumMap<K, V> clone()
    {
        return (SerializableEnumMap<K, V>) super.clone();
    }



    @Override
    @Nonnull
    public SerializableSet<K> keySet()
    {
        return new SerializableHashSet<K>(super.keySet());
    }



    @Override
    @Nonnull
    public SerializableCollection<V> values()
    {
        return new SerializableArrayList<V>(super.values());
    }
}
