package legacy
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SparkOpInstance12 extends SparkOp {
  val randomValue: Int = 3142 // Hardcoded random value

  override def name: Input = "dataset/spark-op-instance-12"
  override def inputs: Set[Input] = Set(SparkOpInstance11.name) // Reference to SparkOpInstance11 as an input using object name
  override def query(inputs: Map[Input, DataFrame]): DataFrame = {
    // Using randomValue from SparkOpInstance11 as instructed
    val _ = SparkOpInstance11.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
