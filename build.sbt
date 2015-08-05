name := "learning"
version := "1.0.0"

scalaVersion := "2.11.5"


javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Spy" at "http://files.couchbase.com/maven2/"



libraryDependencies ++= List(
	"junit" % "junit" % "4.10" % "test",
	"org.json4s" %% "json4s-native" % "3.2.11",
	"org.json4s" %% "json4s-native" % "3.2.11",
	"org.apache.httpcomponents" % "httpcore" % "4.4",
	"org.apache.httpcomponents" % "httpclient" % "4.4",
	"com.typesafe" % "config" % "1.2.1",
	"org.mongodb" %% "casbah" % "2.8.1",
	"org.apache.hadoop" % "hadoop-core" % "1.2.1",
	"org.apache.hbase" % "hbase" % "1.1.1",
	"org.apache.hbase" % "hbase-client" % "1.1.1",
	"org.apache.hbase" % "hbase-common" % "1.1.1",
	"joda-time" % "joda-time" % "2.8.1"

)

 
lazy val scala_core = RootProject ( file("../../Neuralytics/ScalaCore") )

ivyXML :=
  <dependencies>
    <exclude module="thrift" />
  </dependencies>