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
  "$CLASSPATH:./target/demo_optaplanner-1.0-SNAPSHOT.jar" \
  com.joelparkerhenderson.demo.optaplanner.App
Hello World!
```


### OptaPlanner binaries

The app expects the CLASSPATH to include the OptaPlanner binaries, such as `optaplanner-core-7.28.0.Final.jar`.

Example: add it with typical Unix syntax and typical Maven location:

```sh
export CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/optaplanner/optaplanner-core/7.28.0.Final/optaplanner-core-7.28.0.Final.jar"
```

If you get this error:

```sh
Exception in thread "main" java.lang.NoClassDefFoundError: org/optaplanner/core/api/solver/SolverFactory
```

Then verify the CLASSPATH includes the OptaPlanner binaries.


### Simple Logging Facade for Java (SLF4J)

The app expects the CLASSPATH to include Simple Logging Facade for Java (SLF4J).

Example: add it with typical Unix syntax and typical Maven location:

```sh
export CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar"
export CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/slf4j/slf4j-simple/1.7.26/slf4j-simple-1.7.26.jar"
```

If you get this error:

```sh
Exception in thread "main" java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory
```

Then verify the CLASSPATH includes the SLFJ API binary.

If you get this error:

```sh
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
```

Then verify the CLASSPATH includes the SLF4J simple binary, or equivalent SLF4J binding of your preference.

