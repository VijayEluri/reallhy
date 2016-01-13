import java.io.File

import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import collection.JavaConversions._
object DeployJarsToJobServer {
  def main(args: Array[String]) {
    val pb = new ProcessBuilder()
    val folder: File = new File("D:/dev/spark-jobserver-for-windows/spark-jobserver-local/tmp/spark-job-server/sqldao/data-backup")
    pb.directory(folder)
    val jars = folder.list.filter(_.contains(".jar"))
    for(jar <- jars; appName = jar.split("-")(0)) {
      //curl --data-binary  @SVM-2015-06-15T19_39_04.969+09_00.jar localhost:8090/jars/SVM
      val commands = ListBuffer("curl", "--data-binary", "@"+jar, "localhost:8090/jars/"+appName)
      println(commands.mkString(" "))
      val exec = pb.command(commands)
      pb.start()
    }
  }
}
