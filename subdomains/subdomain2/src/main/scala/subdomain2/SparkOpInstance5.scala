package subdomain2
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SparkOpInstance5 extends SparkOp {
  val randomValue: Int = 2753 // Hardcoded random value

  override def name: String = "nu-br/dataset/spark-op-instance-5"
  override def inputs: Set[String] = Set("nu-br/dataset/spark-op-instance-4") // Hardcoded name of SparkOpInstance4
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using hardcoded randomValue previously from SparkOpInstance4
    val _ = 3921 // This value was previously SparkOpInstance4.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
