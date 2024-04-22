package subdomain
import org.apache.spark.sql.SparkSession

import platform.common_classes.{Metadata, RunConfigurations, SubdomainOp, Input}
import org.apache.spark.sql.DataFrame

object SubdomainSparkOpInstance4 extends SubdomainOp {
  val randomValue: Int = 3921 // Hardcoded random value

  override def name: String = "dataset/subdomain-spark-op-instance-4"
  override def inputs: Set[Input] = Set(new SubdomainInput(SubdomainSparkOpInstance3.name)) // Correctly typed Set of Input
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SubdomainSparkOpInstance3 as instructed
    val _ = SubdomainSparkOpInstance3.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
