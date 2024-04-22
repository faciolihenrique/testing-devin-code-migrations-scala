import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfterAll
import org.apache.spark.sql.SparkSession
import subdomain._
import subdomain.SubdomainInput

class SubdomainOpInstanceTest extends AnyFunSuite with BeforeAndAfterAll {
  val sparkSession = SparkSession.builder().appName("SubdomainOpInstanceTest").master("local[*]").getOrCreate()

  // Test for SubdomainSparkOpInstance1
  test("SubdomainSparkOpInstance1: name should be dataset/subdomain-spark-op-instance-1") {
    assert(SubdomainSparkOpInstance1.name == "dataset/subdomain-spark-op-instance-1")
  }

  test("SubdomainSparkOpInstance1: inputs should reference correct dependencies") {
    // Assuming SubdomainSparkOpInstance1 has no dependencies or is the first in the chain
    assert(SubdomainSparkOpInstance1.inputs.isEmpty)
  }

  test("SubdomainSparkOpInstance1: query should return a DataFrame") {
    val inputs = Map.empty[String, org.apache.spark.sql.DataFrame]
    val result = SubdomainSparkOpInstance1.query(inputs)
    assert(result.isInstanceOf[org.apache.spark.sql.Dataset[_]])
  }

  test("SubdomainSparkOpInstance1: metadata should be valid") {
    val metadata = SubdomainSparkOpInstance1.metadata
    assert(metadata.isInstanceOf[platform.common_classes.Metadata])
  }

  test("SubdomainSparkOpInstance1: runConfigurations should be valid") {
    val runConfigurations = SubdomainSparkOpInstance1.runConfigurations
    assert(runConfigurations.isInstanceOf[platform.common_classes.RunConfigurations])
  }

  // Tests for SubdomainSparkOpInstance2 through SubdomainSparkOpInstance19
  for (i <- 2 to 19) {
    val instance = i match {
      case 2 => SubdomainSparkOpInstance2
      case 3 => SubdomainSparkOpInstance3
      case 4 => SubdomainSparkOpInstance4
      case 5 => SubdomainSparkOpInstance5
      case 6 => SubdomainSparkOpInstance6
      case 7 => SubdomainSparkOpInstance7
      case 8 => SubdomainSparkOpInstance8
      case 9 => SubdomainSparkOpInstance9
      case 10 => SubdomainSparkOpInstance10
      case 11 => SubdomainSparkOpInstance11
      case 12 => SubdomainSparkOpInstance12
      case 13 => SubdomainSparkOpInstance13
      case 14 => SubdomainSparkOpInstance14
      case 15 => SubdomainSparkOpInstance15
      case 16 => SubdomainSparkOpInstance16
      case 17 => SubdomainSparkOpInstance17
      case 18 => SubdomainSparkOpInstance18
      case 19 => SubdomainSparkOpInstance19
    }

    test(s"SubdomainSparkOpInstance$i: name should be dataset/subdomain-spark-op-instance-$i") {
      assert(instance.name == s"dataset/subdomain-spark-op-instance-$i")
    }

    test(s"SubdomainSparkOpInstance$i: inputs should reference correct dependencies") {
      // This is a placeholder for actual dependencies check
      // Assuming each instance depends on the previous instance
      val expectedInputs = if (i == 2) Set(new SubdomainInput("dataset/subdomain-spark-op-instance-1")) else Set(new SubdomainInput(s"dataset/subdomain-spark-op-instance-${i-1}"))
      assert(instance.inputs == expectedInputs)
    }

    test(s"SubdomainSparkOpInstance$i: query should return a DataFrame") {
      val inputs = Map.empty[String, org.apache.spark.sql.DataFrame]
      val result = instance.query(inputs)
      assert(result.isInstanceOf[org.apache.spark.sql.Dataset[_]])
    }

    test(s"SubdomainSparkOpInstance$i: metadata should be valid") {
      val metadata = instance.metadata
      assert(metadata.isInstanceOf[platform.common_classes.Metadata])
    }

    test(s"SubdomainSparkOpInstance$i: runConfigurations should be valid") {
      val runConfigurations = instance.runConfigurations
      assert(runConfigurations.isInstanceOf[platform.common_classes.RunConfigurations])
    }
  }

  // Test for SubdomainSparkOpInstance20
  test("SubdomainSparkOpInstance20: name should be dataset/subdomain-spark-op-instance-20") {
    assert(SubdomainSparkOpInstance20.name == "dataset/subdomain-spark-op-instance-20")
  }

  test("SubdomainSparkOpInstance20: inputs should reference SubdomainSparkOpInstance19") {
    assert(SubdomainSparkOpInstance20.inputs == Set(new SubdomainInput("dataset/subdomain-spark-op-instance-19")))
  }

  test("SubdomainSparkOpInstance20: query should return a DataFrame") {
    val inputs = Map("dataset/subdomain-spark-op-instance-19" -> sparkSession.emptyDataFrame)
    val result = SubdomainSparkOpInstance20.query(inputs)
    assert(result.isInstanceOf[org.apache.spark.sql.Dataset[_]])
  }

  test("SubdomainSparkOpInstance20: metadata should be valid") {
    val metadata = SubdomainSparkOpInstance20.metadata
    assert(metadata.isInstanceOf[platform.common_classes.Metadata])
  }

  test("SubdomainSparkOpInstance20: runConfigurations should be valid") {
    val runConfigurations = SubdomainSparkOpInstance20.runConfigurations
    assert(runConfigurations.isInstanceOf[platform.common_classes.RunConfigurations])
  }

  // Clean up Spark session after tests
  override def afterAll(): Unit = {
    sparkSession.stop()
  }
}
