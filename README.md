# Demo OptaPlanner

* [](#)

## Setup

### Setup with macOS with Homebrew

```sh
$ brew install adoptopenjdk
$ brew install maven
```

### Preflight

Java:

```sh
$ java -version
openjdk version "13.0.1" 2019-10-15
```

Maven:

```sh
$ mvn -v
Apache Maven 3.6.2
```


## Create

Maven:

```sh
$ mvn archetype:generate \
  -DgroupId=com.joelparkerhenderson.demo.optaplanner \
  -DartifactId=demo_optaplanner \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

Add OptaPlanner bom to `pom.xml`:

```xml
<dependencyManagement>
  <dependencies>
    …
    <dependency>
      <groupId>org.optaplanner</groupId>
      <artifactId>optaplanner-bom</artifactId>
      <type>pom</type>
      <version>7.28.0.Final</version>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  …
  <dependency>
    <groupId>org.optaplanner</groupId>
    <artifactId>optaplanner-core</artifactId>
  </dependency>
</dependencies>
```
