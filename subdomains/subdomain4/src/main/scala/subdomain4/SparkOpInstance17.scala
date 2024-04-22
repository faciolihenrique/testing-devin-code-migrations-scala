package subdomain4

import platform.common_classes.{Metadata, RunConfigurations, SparkOp}
import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkOpInstance17 extends SparkOp {
  override def name: String = "dataset/spark-op-instance-17"
  override def inputs: Set[String] = Set()
  override def metadata: Metadata = new Metadata() // Corrected instantiation
  override def runConfigurations: RunConfigurations = new RunConfigurations() // Corrected instantiation

  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
}
