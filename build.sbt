val slickVersion = "3.1.1"

name := "slick"

scalaVersion := "2.11.8"

libraryDependencies ++= List(
	"com.typesafe.slick" %% "slick" % slickVersion,
	"com.typesafe.slick" %% "slick-codegen" % slickVersion,
	"org.slf4j" % "slf4j-nop" % "1.7.19",
	"postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)

slick <<= slickCodeGenTask // register manual sbt command

//sourceGenerators in Compile <+= slickCodeGenTask // register automatic code generation on every compile, remove for only manual use

// code generation task
lazy val slick = TaskKey[Seq[File]]("gen-tables")
lazy val slickCodeGenTask = (sourceDirectory, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
	val outputDir = (dir / "main" / "scala").getPath
	val url = "jdbc:postgresql://localhost/slick"
	val username = "slick"
	val password = "slick"
	val jdbcDriver = "org.postgresql.Driver"
	val slickDriver = "slick.driver.PostgresDriver"
	val pkg = "demo"
	toError(r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, username, password), s.log))
	val fname = outputDir + "/demo/Tables.scala"
	Seq(file(fname))
}
