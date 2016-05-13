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

import org.assertj.core.api.Assertions;
import org.junit.Test;


/**
 * Unit tests of {@link SerializableTreeSet}.
 *
 * @author Thomas Jensen
 */
public class SerializableTreeSetTest
{
    @Test
    public void testDuplicates()
    {
        SerializableTreeSet<String> testee = new SerializableTreeSet<String>();
        testee.add("Frodo");
        testee.add("Frodo");
        testee.add("Frodo");

        Assertions.assertThat(testee).containsExactly("Frodo");
    }



    @Test
    public void testOrdering()
    {
        SerializableTreeSet<String> testee = new SerializableTreeSet<String>();
        testee.add("Frodo");
        testee.add("Bilbo");
        testee.add("Samweis");
        testee.add("Pippin");

        Assertions.assertThat(testee).containsExactly("Bilbo", "Frodo", "Pippin", "Samweis");
    }
}
