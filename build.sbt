name := "flink-kafka-json-serializer-experiment"
version := "0.1"
scalaVersion := "2.12.8"

// Flink dependencies
libraryDependencies += "org.apache.flink" %% "flink-scala" % "1.7.2" //% "provided"
libraryDependencies += "org.apache.flink" %% "flink-streaming-scala" % "1.7.2" //% "provided"
libraryDependencies += "org.apache.flink" %% "flink-connector-kafka" % "1.7.2" //% "provided"


//Json4s dependencies
libraryDependencies +=  "org.json4s" %% "json4s-native" % "3.6.5"
libraryDependencies +=  "org.json4s" %% "json4s-jackson" % "3.6.5"

//Jsoniter
libraryDependencies +=  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "0.45.1" % Compile
libraryDependencies +=  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "0.45.1" % Provided // required only in compile-time