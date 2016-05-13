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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;


/**
 * Unit tests of {@link SerializableUnmodifiableHashMap}.
 *
 * @author Thomas Jensen
 */
public class SerializableUnmodifiableHashMapUTest
{
    private static final int NUM_ENTRIES = 3;



    private SerializableMap<String, String> buildNewTestMap()
    {
        final Map<String, String> inputMap = new HashMap<String, String>();
        String argh = "argh";
        inputMap.put("A", argh); // use exact same value twice
        inputMap.put("B", argh);
        inputMap.put("C", "cool");
        SerializableMap<String, String> result = new SerializableUnmodifiableHashMap<String, String>(inputMap);
        Assert.assertEquals(NUM_ENTRIES, result.size());
        return result;
    }



    @Test
    public void testIterators()
    {
        final SerializableMap<String, String> mapUnderTest = buildNewTestMap();

        int count = 0;
        for (String key : mapUnderTest.keySet()) {
            Assert.assertNotNull(key);
            count++;
        }
        Assert.assertEquals(NUM_ENTRIES, count);

        count = 0;
        for (String v : mapUnderTest.values()) {
            Assert.assertNotNull(v);
            count++;
        }
        Assert.assertEquals(NUM_ENTRIES, count);

        count = 0;
        for (Entry<String, String> entry : mapUnderTest.entrySet()) {
            Assert.assertNotNull(entry);
            count++;
        }
        Assert.assertEquals(NUM_ENTRIES, count);
    }



    @Test
    public void testUnsupportedOps()
    {
        final SerializableMap<String, String> mapUnderTest = buildNewTestMap();

        try {
            mapUnderTest.clear();
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.put("D", "value");
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.putAll(new HashMap<String, String>());
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.remove("A");
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.keySet().remove("B");
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.keySet().add("E");
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.keySet().clear();
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.keySet().removeAll(Collections.singleton("A"));
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.keySet().addAll(Arrays.asList("E", "F"));
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.keySet().retainAll(Collections.singleton("A"));
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.values().remove("B");
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        Map.Entry<String, String> entry1 = mapUnderTest.entrySet().iterator().next();
        Assert.assertNotNull(entry1);
        try {
            mapUnderTest.entrySet().remove(entry1);
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            entry1.setValue("poison");
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            mapUnderTest.entrySet().clear();
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }

        try {
            Iterator<Entry<String, String>> iter = mapUnderTest.entrySet().iterator();
            Assert.assertNotNull(iter.next());
            iter.remove();
            Assert.fail("expected exception was not thrown");
        }
        catch (UnsupportedOperationException e) {
            // expected
        }
    }



    @Test
    public void testSerialization()
        throws IOException, ClassNotFoundException
    {
        final SerializableMap<String, String> mapUnderTest = buildNewTestMap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(mapUnderTest);
        final byte[] byteRepresentation = bos.toByteArray();
        IOUtils.closeQuietly(oos);
        IOUtils.closeQuietly(bos);

        ByteArrayInputStream bais = new ByteArrayInputStream(byteRepresentation);
        ObjectInputStream ois = new ObjectInputStream(bais);
        @SuppressWarnings("unchecked")
        SerializableMap<String, String> resurrectedMap = (SerializableMap<String, String>) ois.readObject();
        IOUtils.closeQuietly(bais);
        IOUtils.closeQuietly(ois);

        Assert.assertNotSame(mapUnderTest, resurrectedMap);
        Assert.assertEquals(NUM_ENTRIES, resurrectedMap.size());
        Assert.assertEquals(mapUnderTest.getClass(), resurrectedMap.getClass());
        Assert.assertEquals(mapUnderTest.keySet(), resurrectedMap.keySet());
        Assert.assertEquals(mapUnderTest.values(), resurrectedMap.values());
        Assert.assertEquals(mapUnderTest.entrySet(), resurrectedMap.entrySet());
    }



    @Test
    public void testClone()
    {
        final SerializableMap<String, String> mapUnderTest = buildNewTestMap();

        final SerializableMap<String, String> clonedMap =
            ((SerializableUnmodifiableHashMap<String, String>) mapUnderTest).clone();

        Assert.assertNotNull(clonedMap);
        Assert.assertEquals(mapUnderTest.getClass().getName(), clonedMap.getClass().getName());

        Assert.assertNotSame(mapUnderTest, clonedMap);
        Assert.assertEquals(mapUnderTest, clonedMap);

        Assert.assertEquals(mapUnderTest.size(), clonedMap.size());
        Assert.assertTrue(clonedMap.keySet().containsAll(mapUnderTest.keySet()));
        Assert.assertTrue(clonedMap.values().containsAll(mapUnderTest.values()));
    }



    @Test
    public void testEmptyMap()
    {
        final SerializableMap<String, String> mapUnderTest = new SerializableUnmodifiableHashMap<String, String>();

        Assert.assertNotNull(mapUnderTest);
        Assert.assertEquals(0, mapUnderTest.size());
    }



    @Test
    public void testCloneEnumMap()
    {
        final SerializableEnumMap<TestEnum, String> mapUnderTest = new SerializableEnumMap<TestEnum, String>(
            TestEnum.class);
        mapUnderTest.put(TestEnum.foo, "baz");
        mapUnderTest.put(TestEnum.bar, "boo");
        Assert.assertEquals(SerializableEnumMap.class, mapUnderTest.getClass());

        final SerializableMap<TestEnum, String> mapClone = mapUnderTest.clone();
        Assert.assertEquals(mapUnderTest, mapClone);
        Assert.assertEquals(SerializableEnumMap.class, mapClone.getClass());
    }



    @Test
    public void testCloneHashMap()
    {
        final SerializableHashMap<TestEnum, String> mapUnderTest = new SerializableHashMap<TestEnum, String>();
        mapUnderTest.put(TestEnum.foo, "baz");
        mapUnderTest.put(TestEnum.bar, "boo");
        Assert.assertEquals(SerializableHashMap.class, mapUnderTest.getClass());

        final SerializableMap<TestEnum, String> mapClone = mapUnderTest.clone();
        Assert.assertEquals(mapUnderTest, mapClone);
        Assert.assertEquals(SerializableHashMap.class, mapClone.getClass());
    }



    @Test
    public void testCloneSerializableUnmodifiableEntry()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "value");
        SerializableUnmodifiableEntry<String, String> entry = new SerializableUnmodifiableEntry<String, String>(
            map.entrySet().iterator().next());
        SerializableUnmodifiableEntry<String, String> myClone = entry.clone();
        Assert.assertNotSame(entry, myClone);
        Assert.assertEquals(entry, myClone);
    }
}
