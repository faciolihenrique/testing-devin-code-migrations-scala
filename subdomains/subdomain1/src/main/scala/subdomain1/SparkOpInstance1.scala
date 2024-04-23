package subdomain1

import org.apache.spark.sql.SparkSession
import utils.SharedComponents

import platform.common_classes.{Metadata, RunConfigurations, SparkOp}
import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkOpInstance1 extends SparkOp {
  val randomValue: Int = SharedComponents.randomValue // Using shared randomValue from SharedComponents

  override def name: String = "nu-br/dataset/spark-op-instance-1"
  override def inputs: Set[String] = Set() // No inputs, making it a root
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SharedComponents
    val _ = SharedComponents.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    // Mock implementation for metadata
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    // Mock implementation for runConfigurations
    new RunConfigurations()
  }
}
