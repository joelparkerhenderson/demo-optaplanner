# Setup

* [Dependencies](#dependencies)
  * [macOS with Homebrew](#macos-with-homebrew)
  * [Preflight](#preflight)
  * [Build and run](#build-and-run)
* [Libraries and classpaths](#libraries-and-classpaths)
  * [OptaPlanner binaries](#optaplanner-binaries)
  * [Simple Logging Facade for Java (SLF4J)](#simple-logging-facade-for-java-slf4j)
  * [Apache Lang and Math](#apache-lang-and-math)
  * [Google collections and Guava](#google-collections-and-guava)


## Dependencies


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
Demo OptaPlanner …
```


## Libraries and classpaths


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


### Apache Lang and Math

The app expects the CLASSPATH to include Apache commons lang and math.

Example: add then with typical Unix syntax and typical Maven location:

```sh
export CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/apache/commons/commons-lang3/3.8.1/commons-lang3-3.8.1.jar"
export CLASSPATH="$CLASSPATH:$HOME/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar"
```

If you get this error:

```sh
java.lang.ClassNotFoundException: org.apache.commons.lang3.…
```

Then you are missing Apache commons lang library.

If you get an error such as:

```sh
java.lang.NoClassDefFoundError: org/apache/commons/math3/…
```

Then verify the CLASSPATH includes the Apache commons libraries.


### Google collections and Guava

The app expects the CLASSPATH to include Google collections a.k.a. Guava.

```sh
export CLASSPATH="$CLASSPATH:$HOME/.m2/repository/com/google/guava/guava/25.0-jre/guava-25.0-jre.jar"

If you get an error such as:

```sh
java.lang.NoClassDefFoundError: com/google/common/…
```

Then verify the CLASSPATH includes the Google Guava library.
