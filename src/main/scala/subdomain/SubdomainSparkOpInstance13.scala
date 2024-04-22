package subdomain
import org.apache.spark.sql.SparkSession

import platform.common_classes.{SubdomainOp, Input}
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SubdomainSparkOpInstance13 extends SubdomainOp {
  val randomValue: Int = 7854 // Hardcoded random value

  override def name: String = "dataset/subdomain-spark-op-instance-13"
  override def inputs: Set[Input] = Set(new SubdomainInput(SubdomainSparkOpInstance12.name)) // Correctly typed Set of Input
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SubdomainSparkOpInstance12 as instructed
    val _ = SubdomainSparkOpInstance12.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
