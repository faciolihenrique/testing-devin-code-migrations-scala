package subdomain
import org.apache.spark.sql.SparkSession

import platform.common_classes.{SubdomainOp, Input}
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SubdomainSparkOpInstance15 extends SubdomainOp {
  val randomValue: Int = 5283 // Hardcoded random value

  override def name: String = "dataset/subdomain-spark-op-instance-15"
  override def inputs: Set[Input] = Set(new SubdomainInput(SubdomainSparkOpInstance14.name)) // Correctly typed Set of Input
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SubdomainSparkOpInstance14 as instructed
    val _ = SubdomainSparkOpInstance14.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
