# Bootstrapping

Bootstrapping for a skeleton app with Maven, OptaPlanner, and placeholders for files and classes.


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
