import org.scalatest.funsuite.AnyFunSuite
import subdomain1.SparkOpInstance1

class SparkOpInstance1Test extends AnyFunSuite {
  test("SparkOpInstance1: name should be nu-br/dataset/spark-op-instance-1") {
    assert(SparkOpInstance1.name == "nu-br/dataset/spark-op-instance-1")
  }

  // Additional tests for inputs, query, metadata, and runConfigurations can be added here
}
