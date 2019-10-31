# Demo OptaPlanner

* [Setup](#setup)
  * [macOS with Homebrew](#macos-with-homebrew)
  * [Preflight](#preflight)
  * [Build and run](#build-and-run)
* [Create](#create)
  * [Maven](#maven)
  * [OptaPlanner](#optaplanner)
  * [Placeholders](#placeholders)


## Setup


### macOS with Homebrew

```sh
$ brew install adoptopenjdk
$ brew install maven
$ brew install plantuml
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

PlantUML for documentation:

```sh
$ plantuml -version
PlantUML version 1.2019.11
```


### Build and run

Build:

```sh
$ mvn package
```

Run:

```sh
$ java -cp \
  target/demo_optaplanner-1.0-SNAPSHOT.jar \
  com.joelparkerhenderson.demo.optaplanner.App
Hello World!
```


## Create

Create a skeleton app with Maven, OptaPlanner, and placeholders for files and classes.


### Maven

Maven:

```sh
$ mvn archetype:generate \
  -DgroupId=com.joelparkerhenderson.demo.optaplanner \
  -DartifactId=demo_optaplanner \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```


### OptaPlanner

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


### Placeholders

Files:

```sh
$ touch .gitignore README.md CONTRIBUTING.md
$ mkdir -p doc/plans tmp
```

Classes:

```sh
subdir=java/com/joelparkerhenderson/demo/optaplanner
touch src/main/$subdir/{App,Maker,MakerSet,Taker,TakerSet,Matcher,Solution}.java
touch src/test/$subdir/{App,Maker,MakerSet,Taker,TakerSet,Matcher,Solution}Test.java
```
