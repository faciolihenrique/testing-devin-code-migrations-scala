package subdomain2
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SparkOpInstance11 extends SparkOp {
  val randomValue: Int = 6578 // Hardcoded random value

  override def name: String = "nu-br/dataset/spark-op-instance-11"
  // Reference to SparkOpInstance10 as an input using object name
  // Since SparkOpInstance10 is in a different subdomain, we replace the direct reference with a hardcoded string
  override def inputs: Set[String] = Set("nu-br/dataset/spark-op-instance-10")
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using hardcoded randomValue previously from SparkOpInstance10
    val _ = 9034 // This value was previously SparkOpInstance10.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
