[![Build Status](https://github.com/tsjensen/sercoll/actions/workflows/build.yml/badge.svg)](https://github.com/tsjensen/sercoll/actions/workflows/build.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.thomasjensen.sercoll/sercoll/badge.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3Acom.thomasjensen.sercoll)

# sercoll

**Java Collections declared Serializable**

This Java library provides one way to deal with the problem that Java collection interfaces are not declared serializable. Without *sercoll*, the following code will cause the FindBugs warning `Non-transient non-serializable instance field in serializable class` ([SE_BAD_FIELD](http://findbugs.sourceforge.net/bugDescriptions.html#SE_BAD_FIELD)):
```java
public class MyObject implements Serializable {
  private static final long serialVersionUID = 1L;
  private String foo;
  private List<String> strings;  // FindBugs error
  // ... snip ...
}
```
This is correct, because `List`, `Set`, `Map`, and other standard Java collection classes do not implement `Serializable`, as they cannot know whether their elements are serializable or not.

So, while [other solutions](http://stackoverflow.com/q/4861228/1005481) exist, such as using the concrete collection type, tricking the detector into not working for your class, or ignoring the warning, I believe the cleanest way is to make the declaration:
```java
public class MyObject implements Serializable {
  private static final long serialVersionUID = 1L;
  private String foo;
  private SerializableList<String> strings;  // OK!
  // ... snip ...
}
```
*Sercoll* provides the interfaces such as `SerializableList` that are directly derived from the JDK classes, but add the serializability declaration. In addition to that, the required supplementary code is provided to successfully use the new interfaces in practice with little to no refactoring effort.

## Prerequisites

*Sercoll* requires at least JDK 6. It has no dependencies on other libraries.

## Status

This is work in progress. *Sercoll* is not yet complete (some classes are missing), and also poorly tested as yet. This notice will be updated once *sercoll* has stabilized sufficiently to be ready for production use.

## Integration

*Sercoll* is distributed through [Maven Central](http://search.maven.org/#search|gav|1|g%3Acom.thomasjensen.sercoll), so you can just use it in your build. *Sercoll* uses [semantic versioning](http://semver.org/), so you can safely include the latest of a major version.

**Gradle:**
```groovy
dependencies {
    compile group: 'com.thomasjensen.sercoll', name: 'sercoll', version: '0.+'
}
```
**Maven:**
```xml
<dependencies>
  <dependency>
    <groupId>com.thomasjensen.sercoll</groupId>
    <artifactId>sercoll</artifactId>
    <version>0.7.0</version>
  </dependency>
</dependencies>
```
**Download:**
You can also [download](https://repo1.maven.org/maven2/com/thomasjensen/sercoll/sercoll/) the JAR manually, of course.

## Resources

[Javadoc](http://tsjensen.github.io/sercoll/apidocs/latest/)
