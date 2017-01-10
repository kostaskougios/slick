package demo
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends
	{
		val profile = slick.driver.PostgresDriver
	} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables
{
	val profile: slick.driver.JdbcProfile

	import profile.api._
	import slick.model.ForeignKeyAction
	// NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
	import slick.jdbc.{GetResult => GR}

	/** DDL for all tables. Call .create to execute. */
	lazy val schema: profile.SchemaDescription = Attribute.schema ++ Category.schema ++ Product.schema ++ ProductAttribute.schema ++ ProductCategory.schema

	@deprecated("Use .schema instead of .ddl", "3.0")
	def ddl = schema

	/** Entity class storing rows of table Attribute
	  *
	  * @param id    Database column id SqlType(int4), PrimaryKey
	  * @param name  Database column name SqlType(text)
	  * @param value Database column value SqlType(text) */
	case class AttributeRow(id: Int, name: String, value: String)

	/** GetResult implicit for fetching AttributeRow objects using plain SQL queries */
	implicit def GetResultAttributeRow(implicit e0: GR[Int], e1: GR[String]): GR[AttributeRow] = GR {
		prs =>
			import prs._
			AttributeRow.tupled((<<[Int], <<[String], <<[String]))
	}

	/** Table description of table attribute. Objects of this class serve as prototypes for rows in queries. */
	class Attribute(_tableTag: Tag) extends Table[AttributeRow](_tableTag, "attribute")
	{
		def * = (id, name, value) <> (AttributeRow.tupled, AttributeRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(value)).shaped.<>({ r => import r._; _1.map(_ => AttributeRow.tupled((_1.get, _2.get, _3.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column id SqlType(int4), PrimaryKey */
		val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
		/** Database column name SqlType(text) */
		val name: Rep[String] = column[String]("name")
		/** Database column value SqlType(text) */
		val value: Rep[String] = column[String]("value")
	}

	/** Collection-like TableQuery object for table Attribute */
	lazy val Attribute = new TableQuery(tag => new Attribute(tag))

	/** Entity class storing rows of table Category
	  *
	  * @param id   Database column id SqlType(int4), PrimaryKey
	  * @param name Database column name SqlType(text) */
	case class CategoryRow(id: Int, name: String)

	/** GetResult implicit for fetching CategoryRow objects using plain SQL queries */
	implicit def GetResultCategoryRow(implicit e0: GR[Int], e1: GR[String]): GR[CategoryRow] = GR {
		prs =>
			import prs._
			CategoryRow.tupled((<<[Int], <<[String]))
	}

	/** Table description of table category. Objects of this class serve as prototypes for rows in queries. */
	class Category(_tableTag: Tag) extends Table[CategoryRow](_tableTag, "category")
	{
		def * = (id, name) <> (CategoryRow.tupled, CategoryRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({ r => import r._; _1.map(_ => CategoryRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column id SqlType(int4), PrimaryKey */
		val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
		/** Database column name SqlType(text) */
		val name: Rep[String] = column[String]("name")
	}

	/** Collection-like TableQuery object for table Category */
	lazy val Category = new TableQuery(tag => new Category(tag))

	/** Entity class storing rows of table Product
	  *
	  * @param id   Database column id SqlType(int4), PrimaryKey
	  * @param name Database column name SqlType(text) */
	case class ProductRow(id: Int, name: String)

	/** GetResult implicit for fetching ProductRow objects using plain SQL queries */
	implicit def GetResultProductRow(implicit e0: GR[Int], e1: GR[String]): GR[ProductRow] = GR {
		prs =>
			import prs._
			ProductRow.tupled((<<[Int], <<[String]))
	}

	/** Table description of table product. Objects of this class serve as prototypes for rows in queries. */
	class Product(_tableTag: Tag) extends Table[ProductRow](_tableTag, "product")
	{
		def * = (id, name) <> (ProductRow.tupled, ProductRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({ r => import r._; _1.map(_ => ProductRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column id SqlType(int4), PrimaryKey */
		val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
		/** Database column name SqlType(text) */
		val name: Rep[String] = column[String]("name")
	}

	/** Collection-like TableQuery object for table Product */
	lazy val Product = new TableQuery(tag => new Product(tag))

	/** Entity class storing rows of table ProductAttribute
	  *
	  * @param productId   Database column product_id SqlType(int4)
	  * @param attributeId Database column attribute_id SqlType(int4) */
	case class ProductAttributeRow(productId: Int, attributeId: Int)

	/** GetResult implicit for fetching ProductAttributeRow objects using plain SQL queries */
	implicit def GetResultProductAttributeRow(implicit e0: GR[Int]): GR[ProductAttributeRow] = GR {
		prs =>
			import prs._
			ProductAttributeRow.tupled((<<[Int], <<[Int]))
	}

	/** Table description of table product_attribute. Objects of this class serve as prototypes for rows in queries. */
	class ProductAttribute(_tableTag: Tag) extends Table[ProductAttributeRow](_tableTag, "product_attribute")
	{
		def * = (productId, attributeId) <> (ProductAttributeRow.tupled, ProductAttributeRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(productId), Rep.Some(attributeId)).shaped.<>({ r => import r._; _1.map(_ => ProductAttributeRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column product_id SqlType(int4) */
		val productId: Rep[Int] = column[Int]("product_id")
		/** Database column attribute_id SqlType(int4) */
		val attributeId: Rep[Int] = column[Int]("attribute_id")

		/** Primary key of ProductAttribute (database name product_attribute_pkey) */
		val pk = primaryKey("product_attribute_pkey", (productId, attributeId))

		/** Foreign key referencing Attribute (database name product_attribute_attribute_id_fkey) */
		lazy val attributeFk = foreignKey("product_attribute_attribute_id_fkey", attributeId, Attribute)(r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
		/** Foreign key referencing Product (database name product_attribute_product_id_fkey) */
		lazy val productFk = foreignKey("product_attribute_product_id_fkey", productId, Product)(r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
	}

	/** Collection-like TableQuery object for table ProductAttribute */
	lazy val ProductAttribute = new TableQuery(tag => new ProductAttribute(tag))

	/** Entity class storing rows of table ProductCategory
	  *
	  * @param productId  Database column product_id SqlType(int4)
	  * @param categoryId Database column category_id SqlType(int4) */
	case class ProductCategoryRow(productId: Int, categoryId: Int)

	/** GetResult implicit for fetching ProductCategoryRow objects using plain SQL queries */
	implicit def GetResultProductCategoryRow(implicit e0: GR[Int]): GR[ProductCategoryRow] = GR {
		prs =>
			import prs._
			ProductCategoryRow.tupled((<<[Int], <<[Int]))
	}

	/** Table description of table product_category. Objects of this class serve as prototypes for rows in queries. */
	class ProductCategory(_tableTag: Tag) extends Table[ProductCategoryRow](_tableTag, "product_category")
	{
		def * = (productId, categoryId) <> (ProductCategoryRow.tupled, ProductCategoryRow.unapply)

		/** Maps whole row to an option. Useful for outer joins. */
		def ? = (Rep.Some(productId), Rep.Some(categoryId)).shaped.<>({ r => import r._; _1.map(_ => ProductCategoryRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

		/** Database column product_id SqlType(int4) */
		val productId: Rep[Int] = column[Int]("product_id")
		/** Database column category_id SqlType(int4) */
		val categoryId: Rep[Int] = column[Int]("category_id")

		/** Primary key of ProductCategory (database name product_category_pkey) */
		val pk = primaryKey("product_category_pkey", (productId, categoryId))

		/** Foreign key referencing Category (database name product_category_category_id_fkey) */
		lazy val categoryFk = foreignKey("product_category_category_id_fkey", categoryId, Category)(r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
		/** Foreign key referencing Product (database name product_category_product_id_fkey) */
		lazy val productFk = foreignKey("product_category_product_id_fkey", productId, Product)(r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
	}

	/** Collection-like TableQuery object for table ProductCategory */
	lazy val ProductCategory = new TableQuery(tag => new ProductCategory(tag))
}
