import munit.FunSuite
import subdomain._
import platform.common_classes.{SubdomainOp, Input}

class DAGConfigurationSpec extends FunSuite {
  // List of all SubdomainOp instances in the DAG
  val ops: List[SubdomainOp] = List(
    SubdomainSparkOpInstance1,
    SubdomainSparkOpInstance2,
    SubdomainSparkOpInstance3,
    SubdomainSparkOpInstance4,
    SubdomainSparkOpInstance5,
    SubdomainSparkOpInstance6,
    SubdomainSparkOpInstance7,
    SubdomainSparkOpInstance8,
    SubdomainSparkOpInstance9,
    SubdomainSparkOpInstance10,
    SubdomainSparkOpInstance11,
    SubdomainSparkOpInstance12,
    SubdomainSparkOpInstance13,
    SubdomainSparkOpInstance14,
    SubdomainSparkOpInstance15,
    SubdomainSparkOpInstance16,
    SubdomainSparkOpInstance17,
    SubdomainSparkOpInstance18,
    SubdomainSparkOpInstance19,
    SubdomainSparkOpInstance20
  )

  test("DAG should have no cycles") {
    val visited = scala.collection.mutable.Set[String]()
    val recStack = scala.collection.mutable.Set[String]()

    def isCyclic(op: SubdomainOp): Boolean = {
      println(s"Checking for cycles at: ${op.name}")
      if (recStack.contains(op.name)) return true
      if (visited.contains(op.name)) return false

      visited.add(op.name)
      recStack.add(op.name)

      val result = op.inputs.exists { input =>
        ops.exists(_.name == input.name) && isCyclic(ops.find(_.name == input.name).get)
      }
      recStack.remove(op.name)
      result
    }

    val hasCycles = ops.exists(op => isCyclic(op))
    assert(!hasCycles, "The DAG contains cycles")
  }

  test("SubdomainOp inputs must exist in the DAG") {
    val opNames = ops.map(_.name).toSet
    val inputsExist = ops.forall(op => op.inputs.forall(input => opNames.contains(input.name)))

    assert(inputsExist, "All SubdomainOp inputs must exist in the DAG")
  }
}
