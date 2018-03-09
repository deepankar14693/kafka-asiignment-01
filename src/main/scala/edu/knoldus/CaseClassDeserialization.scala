package edu.knoldus
import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util
import org.apache.kafka.common.serialization.Deserializer

class CaseClassDeserialization extends Deserializer[Students] {

 override def configure (configs: util.Map[String, _], isKey: Boolean): Unit = {}


 override def deserialize (topic: String, bytes: Array[Byte]): Students = {
  val byteInputStream = new ByteArrayInputStream (bytes)
  val objInputStream = new ObjectInputStream (byteInputStream)
  val readObj = objInputStream.readObject ().asInstanceOf[Students]
  byteInputStream.close ()
  objInputStream.close ()
  readObj
 }

 override def close (): Unit = {

 }


}
