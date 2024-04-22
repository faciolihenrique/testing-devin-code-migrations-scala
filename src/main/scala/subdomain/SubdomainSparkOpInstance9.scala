package subdomain
import org.apache.spark.sql.SparkSession

import platform.common_classes.{SubdomainOp, Input}
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SubdomainSparkOpInstance9 extends SubdomainOp {
  val randomValue: Int = 4821 // Hardcoded random value

  override def name: String = "dataset/subdomain-spark-op-instance-9"
  override def inputs: Set[Input] = Set(new SubdomainInput(SubdomainSparkOpInstance8.name)) // Correctly typed Set of Input
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SubdomainSparkOpInstance8 as instructed
    val _ = SubdomainSparkOpInstance8.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
