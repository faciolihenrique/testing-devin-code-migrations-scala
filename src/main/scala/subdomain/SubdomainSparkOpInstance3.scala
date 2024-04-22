package subdomain
import org.apache.spark.sql.SparkSession
import platform.common_classes.{Metadata, RunConfigurations, SubdomainOp, Input}
import org.apache.spark.sql.DataFrame

object SubdomainSparkOpInstance3 extends SubdomainOp {
  val randomValue: Int = 6243 // Hardcoded random value

  override def name: String = "dataset/subdomain-spark-op-instance-3"
  override def inputs: Set[Input] = Set(new SubdomainInput(SubdomainSparkOpInstance2.name)) // Correctly typed Set of Input
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SubdomainSparkOpInstance2 as instructed
    val _ = SubdomainSparkOpInstance2.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
