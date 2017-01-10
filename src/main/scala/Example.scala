object Tables extends
	{
		// or just use object demo.Tables, which is hard-wired to the driver stated during generation
		val profile = slick.driver.H2Driver
	} with demo.Tables

import Tables._
import Tables.profile.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object Example extends App
{
	// connection info for a pre-populated throw-away, in-memory db for this demo, which is freshly initialized on every run
	val url = "jdbc:postgresql://localhost/slick"
	val db = Database.forURL(url, driver = "org.postgresql.Driver", user = "slick", password = "slick")

	val productAttributeQ = ProductAttribute.joinLeft(Attribute).on(_.attributeId === _.id)

	val categoryQ = Category.joinLeft(ProductCategory).on(_.id === _.categoryId)
		.joinLeft(Product).on(_.productId === _.id)
		.joinLeft(productAttributeQ).on(_._2.id === _._1.productId)
		.map {
			case (((category, _), product), (_, attribute)) =>
				(category.name, product.name, attribute.name)
		}

	Await.result(
		db.run(categoryQ.result).map { result =>
			println(result.mkString("\n"))
		},
		60 seconds
	)
}
