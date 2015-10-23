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
import java.util.SortedSet;


/**
 * A serializable {@link SortedSet}. This means that the implementation of the set as well as its elements are declared
 * to be {@link java.io.Serializable}.
 *
 * @param <E> value type
 * @author Thomas Jensen
 */
public interface SerializableSortedSet<E extends Serializable>
    extends SortedSet<E>, SerializableSet<E>
{
    // nothing added
}
