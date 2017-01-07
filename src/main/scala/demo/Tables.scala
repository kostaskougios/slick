package demo

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends
	{
		val profile = slick.driver.H2Driver
	} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables
{
	val profile: slick.driver.JdbcProfile

	import profile.api._
	// NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
	import slick.jdbc.{GetResult => GR}

	/** DDL for all tables. Call .create to execute. */
	lazy val schema: profile.SchemaDescription = Companies.schema ++ Computers.schema

	@deprecated("Use .schema instead of .ddl", "3.0")
	def ddl = schema

	/** Entity class storing rows of table Companies
	  *
	  * @param id   Database column ID SqlType(INTEGER)
	  * @param name Database column NAME SqlType(VARCHAR) */
	case class CompaniesRow(id: Int, name: String)

	/** GetResult implicit for fetching CompaniesRow objects using plain SQL queries */
	implicit def GetResultCompaniesRow(implicit e0: GR[Int], e1: GR[String]): GR[CompaniesRow] = GR {
		prs =>
			import prs._
			CompaniesRow.tupled((<<[Int], <<[String]))
	}

	/** Table description of table COMPANIES. Objects of this class serve as prototypes for rows in queries. */
	class Companies(_tableTag: Tag) extends Table[CompaniesRow](_tableTag, "COMPANIES")
	{
		def * = (id, name) <> (CompaniesRow.tupled, CompaniesRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({ r => import r._; _1.map(_ => CompaniesRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column ID SqlType(INTEGER) */
		val id: Rep[Int] = column[Int]("ID")
		/** Database column NAME SqlType(VARCHAR) */
		val name: Rep[String] = column[String]("NAME")
	}

	/** Collection-like TableQuery object for table Companies */
	lazy val Companies = new TableQuery(tag => new Companies(tag))

	/** Entity class storing rows of table Computers
	  *
	  * @param id             Database column ID SqlType(INTEGER)
	  * @param name           Database column NAME SqlType(VARCHAR)
	  * @param manufacturerId Database column MANUFACTURER_ID SqlType(INTEGER) */
	case class ComputersRow(id: Int, name: String, manufacturerId: Int)

	/** GetResult implicit for fetching ComputersRow objects using plain SQL queries */
	implicit def GetResultComputersRow(implicit e0: GR[Int], e1: GR[String]): GR[ComputersRow] = GR {
		prs =>
			import prs._
			ComputersRow.tupled((<<[Int], <<[String], <<[Int]))
	}

	/** Table description of table COMPUTERS. Objects of this class serve as prototypes for rows in queries. */
	class Computers(_tableTag: Tag) extends Table[ComputersRow](_tableTag, "COMPUTERS")
	{
		def * = (id, name, manufacturerId) <> (ComputersRow.tupled, ComputersRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(manufacturerId)).shaped.<>({ r => import r._; _1.map(_ => ComputersRow.tupled((_1.get, _2.get, _3.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column ID SqlType(INTEGER) */
		val id: Rep[Int] = column[Int]("ID")
		/** Database column NAME SqlType(VARCHAR) */
		val name: Rep[String] = column[String]("NAME")
		/** Database column MANUFACTURER_ID SqlType(INTEGER) */
		val manufacturerId: Rep[Int] = column[Int]("MANUFACTURER_ID")
	}

	/** Collection-like TableQuery object for table Computers */
	lazy val Computers = new TableQuery(tag => new Computers(tag))
}
