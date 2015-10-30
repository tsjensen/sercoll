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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.thomasjensen.sercoll.impl.SerializableArrayList;
import com.thomasjensen.sercoll.impl.SerializableHashSet;
import com.thomasjensen.sercoll.impl.SerializableUnmodifiableArrayList;
import com.thomasjensen.sercoll.impl.SerializableUnmodifiableHashMap;
import com.thomasjensen.sercoll.impl.SerializableUnmodifiableHashSet;
import com.thomasjensen.sercoll.impl.SerializableUnmodifiableTreeSet;


/**
 * Helper class for serializable collections similar to {@link Collections}.
 *
 * @author Thomas Jensen
 */
public final class SerializableCollections
{
    private static final SerializableSet<Serializable> EMTPY_SERIALIZABLE_SET =
        new SerializableUnmodifiableHashSet<Serializable>();

    private static final SerializableList<Serializable> EMTPY_SERIALIZABLE_LIST =
        new SerializableUnmodifiableArrayList<Serializable>();

    private static final SerializableMap<Serializable, Serializable> EMTPY_SERIALIZABLE_MAP =
        new SerializableUnmodifiableHashMap<Serializable, Serializable>();



    /**
     * Creates a new list containing the specified elements. In contrast to  {@link java.util.Arrays#asList}, this
     * method creates a serializable {@link java.util.ArrayList} which may subsequently be added to.
     *
     * @param <T> element type
     * @param pValues the values to be added to the list (<code>null</code> values allowed)
     * @return the list; if <tt>pValues</tt> == <code>null</code>, the empty list
     */
    @Nonnull
    public static <T extends Serializable> SerializableList<T> asList(@Nullable final T... pValues)
    {
        SerializableList<T> result = new SerializableArrayList<T>();
        if (pValues != null) {
            Collections.addAll(result, pValues);
        }
        return result;
    }



    /**
     * Creates a new set containing the specified elements. This method creates a serializable {@link java.util.HashSet}
     * which may subsequently be added to. Duplicate values will not be copied to the new set.
     *
     * @param <T> element type
     * @param pValues the values to be added to the set (<code>null</code> values allowed)
     * @return the set; if <tt>pValues</tt> == <code>null</code>, the empty set
     */
    @Nonnull
    public static <T extends Serializable> SerializableSet<T> asSet(@Nullable final T... pValues)
    {
        SerializableSet<T> result = new SerializableHashSet<T>();
        if (pValues != null) {
            Collections.addAll(result, pValues);
        }
        return result;
    }



    /**
     * Returns the empty set (immutable). This set is serializable, a fact that is indicated by the method's return
     * type. <p>This example illustrates the type-safe way to obtain an empty set:</p> {@code SerializableSet&lt;String>
     * s = SerializableCollections.emptySet();}
     *
     * @param <T> element type
     * @return an immutable, empty <code>SerializableSet</code>
     *
     * @see Collections#emptySet()
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> SerializableSet<T> emptySet()
    {
        return (SerializableSet<T>) EMTPY_SERIALIZABLE_SET;
    }



    /**
     * Returns the empty list (immutable). This list is serializable, a fact that is indicated by the method's return
     * type. <p>This example illustrates the type-safe way to obtain an empty list:</p> {@code
     * SerializableList&lt;String> s = SerializableCollections.emptyList();}
     *
     * @param <T> element type
     * @return an immutable, empty <code>SerializableList</code>
     *
     * @see Collections#emptyList()
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> SerializableList<T> emptyList()
    {
        return (SerializableList<T>) EMTPY_SERIALIZABLE_LIST;
    }



    /**
     * Returns the empty map (immutable). This map is serializable, a fact that is indicated by the method's return
     * type. <p>This example illustrates the type-safe way to obtain an empty map:</p> {@code SerializableMap&lt;String,
     * Date> m = SerializableCollections.emptyMap();}
     *
     * @param <K> key type
     * @param <V> value type
     * @return an immutable, empty <code>SerializableMap</code>
     *
     * @see Collections#emptyMap()
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    public static <K extends Serializable, V extends Serializable> SerializableMap<K, V> emptyMap()
    {
        return (SerializableMap<K, V>) EMTPY_SERIALIZABLE_MAP;
    }



    /**
     * Returns an unmodifiable view of the specified set. This method allows modules to provide users with "read-only"
     * access to internal sets. Query operations on the returned set "read through" to the specified set, and attempts
     * to modify the returned set, whether direct or via its iterator, result in an {@link
     * UnsupportedOperationException}. <p>The returned set will always be serializable, as indicated by the return
     * type.</p>
     *
     * @param <T> element type
     * @param pSet the set for which an unmodifiable view is to be returned
     * @return an unmodifiable view of the specified set
     *
     * @see Collections#unmodifiableSet(Set)
     */
    @Nonnull
    public static <T extends Serializable> SerializableSet<T> unmodifiableSet(@Nonnull final Set<T> pSet)
    {
        return new SerializableUnmodifiableHashSet<T>(pSet);
    }



    /**
     * Returns an unmodifiable view of the specified sorted set. This method allows modules to provide users with
     * "read-only" access to internal sorted sets. Query operations on the returned sorted set "read through" to the
     * specified set, and attempts to modify the returned sorted set, whether direct, via its iterator, or via its
     * <tt>subSet</tt>, <tt>headSet</tt>, or <tt>tailSet</tt> views, result in an {@link UnsupportedOperationException}.
     * <p>The returned sorted set will always be serializable, as indicated by the return type.</p>
     *
     * @param <T> element type
     * @param pSortedSet the sorted set for which an unmodifiable view is to be returned
     * @return an unmodifiable view of the specified sorted set
     *
     * @see Collections#unmodifiableSortedSet(SortedSet)
     */
    @Nonnull
    public static <T extends Serializable> SerializableSortedSet<T> unmodifiableSortedSet(
        @Nonnull final SortedSet<T> pSortedSet)
    {
        return new SerializableUnmodifiableTreeSet<T>(pSortedSet);
    }



    /**
     * Returns an unmodifiable view of the specified list. This method allows modules to provide users with "read-only"
     * access to internal lists. Query operations on the returned list "read through" to the specified list, and
     * attempts to modify the returned list, whether direct or via its iterator, result in an {@link
     * UnsupportedOperationException}. <p>The returned list will always be serializable, as indicated by the return
     * type.</p>
     *
     * @param <T> element type
     * @param pList the list for which an unmodifiable view is to be returned
     * @return an unmodifiable view of the specified list
     *
     * @see Collections#unmodifiableList(List)
     */
    @Nonnull
    public static <T extends Serializable> SerializableList<T> unmodifiableList(@Nonnull final List<T> pList)
    {
        return new SerializableUnmodifiableArrayList<T>(pList);
    }



    /**
     * Returns an unmodifiable view of the specified map. This method allows modules to provide users with "read-only"
     * access to internal maps. Query operations on the returned map "read through" to the specified map, and attempts
     * to modify the returned map, whether direct or via its iterator, result in an {@link
     * UnsupportedOperationException}. <p>The returned map will always be serializable, as indicated by the return
     * type.</p>
     *
     * @param <K> element type
     * @param <V> element type
     * @param pMap the map for which an unmodifiable view is to be returned
     * @return an unmodifiable view of the specified map
     *
     * @see Collections#unmodifiableMap(Map)
     */
    @Nonnull
    public static <K extends Serializable, V extends Serializable> SerializableMap<K, V> unmodifiableMap(
        @Nonnull final Map<K, V> pMap)
    {
        return new SerializableUnmodifiableHashMap<K, V>(pMap);
    }

    // TODO other methods: nCopies, 2x reverseOrder, unmodifiableCollection, unmodifiableSortedMap


    /**
     * Returns an immutable set containing only the specified object. The returned set will always be serializable, as
     * indicated by the return type.
     *
     * @param <T> element type
     * @param pSingleItem the sole object to be stored in the returned set
     * @return an immutable set containing only the specified object
     *
     * @see Collections#singleton
     */
    @Nonnull
    public static <T extends Serializable> SerializableSet<T> singleton(@Nullable final T pSingleItem)
    {
        return new SerializableUnmodifiableHashSet<T>(pSingleItem);
    }



    /**
     * Returns an immutable list containing only the specified object. The returned list will always be serializable, as
     * indicated by the return type.
     *
     * @param <T> element type
     * @param pSingleItem the sole object to be stored in the returned list
     * @return an immutable list containing only the specified object
     *
     * @see Collections#singletonList
     */
    @Nonnull
    public static <T extends Serializable> SerializableList<T> singletonList(@Nullable final T pSingleItem)
    {
        return new SerializableUnmodifiableArrayList<T>(pSingleItem);
    }



    /**
     * Returns an immutable map, mapping only the specified key to the specified value. The returned map will always be
     * serializable, as indicated by the return type.
     *
     * @param <K> key type
     * @param <V> value type
     * @param pKey the sole key to be stored in the returned map
     * @param pValue the value to which the returned map maps <code>pKey</code>
     * @return an immutable map containing only the specified key-value mapping
     *
     * @see Collections#singletonMap
     */
    @Nonnull
    public static <K extends Serializable, V extends Serializable> SerializableMap<K, V> singletonMap(
        @Nullable final K pKey, @Nullable final V pValue)
    {
        return new SerializableUnmodifiableHashMap<K, V>(pKey, pValue);
    }



    private SerializableCollections()
    {
        super();
    }
}
