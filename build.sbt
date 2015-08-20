name := "learning"
version := "1.0.0"

scalaVersion := "2.11.5"


javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Spy" at "http://files.couchbase.com/maven2/"



libraryDependencies ++= List(
	"junit" % "junit" % "4.10" % "test",
	"com.typesafe.slick" %% "slick" % "2.1.0",
	"mysql" % "mysql-connector-java" % "5.1.22",
    "org.virtuslab" % "unicorn-core_2.11" % "0.6.2",
	"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test",
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