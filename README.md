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
