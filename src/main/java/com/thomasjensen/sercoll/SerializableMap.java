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


/**
 * A serializable {@link Map}. This means that the implementation of the map as well as its elements are declared to be
 * {@link java.io.Serializable}.
 *
 * @param <K> key type
 * @param <V> value type
 * @author Thomas Jensen
 */
public interface SerializableMap<K extends Serializable, V extends Serializable>
    extends Map<K, V>, Serializable
{
    @Override
    SerializableCollection<V> values();



    @Override
    SerializableSet<K> keySet();


    // Remark: Having a method SerializableSet<SerializableEntry<K, V>> entrySet() would be quite inefficient, because
    // every entry would have to be converted into a serializable copy. Since we assume that entry sets are used for
    // iteration rather then serialization, we skip this method. It could potentially be added later as a convenience
    // method under a new name, for example serializableEntrySet().
}
