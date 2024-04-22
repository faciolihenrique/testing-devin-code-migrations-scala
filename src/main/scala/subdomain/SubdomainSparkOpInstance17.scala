package subdomain
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import platform.common_classes.{SubdomainOp, Metadata, RunConfigurations, Input}

object SubdomainSparkOpInstance17 extends SubdomainOp {
  val randomValue: Int = 1987 // Hardcoded random value

  override def name: String = "dataset/subdomain-spark-op-instance-17"
  override def inputs: Set[Input] = Set(new SubdomainInput(SubdomainSparkOpInstance16.name)) // Correctly typed Set of Input
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = new Metadata()
  override def runConfigurations: RunConfigurations = new RunConfigurations()
}
