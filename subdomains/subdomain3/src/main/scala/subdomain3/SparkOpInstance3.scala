package subdomain3
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SparkOpInstance3 extends SparkOp {
  val randomValue: Int = 6243 // Hardcoded random value

  override def name: String = "nu-br/dataset/spark-op-instance-3"
  override def inputs: Set[String] = Set("nu-br/dataset/spark-op-instance-2") // Hardcoded name of SparkOpInstance2
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using hardcoded randomValue previously from SparkOpInstance2
    val _ = 1987 // This value was previously SparkOpInstance2.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
