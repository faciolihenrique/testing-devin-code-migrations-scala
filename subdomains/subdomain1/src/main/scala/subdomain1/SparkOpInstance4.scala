package subdomain1
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SparkOpInstance4 extends SparkOp {
  val randomValue: Int = 3921 // Hardcoded random value

  override def name: String = "nu-br/dataset/spark-op-instance-4"
  override def inputs: Set[String] = Set("nu-br/dataset/spark-op-instance-3") // Hardcoded name of SparkOpInstance3
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using hardcoded randomValue previously from SparkOpInstance3
    val _ = 6243 // This value was previously SparkOpInstance3.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
