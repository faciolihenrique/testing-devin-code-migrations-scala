import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.{Metadata, RunConfigurations}
import subdomain1.{SparkOpInstance1, SparkOpInstance4, SparkOpInstance7, SparkOpInstance10, SparkOpInstance14, SparkOpInstance18}
import subdomain2.{SparkOpInstance2, SparkOpInstance5, SparkOpInstance8, SparkOpInstance11, SparkOpInstance15, SparkOpInstance19}
import subdomain3.{SparkOpInstance3, SparkOpInstance6, SparkOpInstance9, SparkOpInstance12, SparkOpInstance16, SparkOpInstance20}
import subdomain4.{SparkOpInstance13, SparkOpInstance17}

object DAG {
  val ops: Set[SparkOp] = Set(
    SparkOpInstance1,
    SparkOpInstance2,
    SparkOpInstance3,
    SparkOpInstance4,
    SparkOpInstance5,
    SparkOpInstance6,
    SparkOpInstance7,
    SparkOpInstance8,
    SparkOpInstance9,
    SparkOpInstance10,
    SparkOpInstance11,
    SparkOpInstance12,
    SparkOpInstance13,
    SparkOpInstance14,
    SparkOpInstance15,
    SparkOpInstance16,
    SparkOpInstance17,
    SparkOpInstance18,
    SparkOpInstance19,
    SparkOpInstance20
  )
}
