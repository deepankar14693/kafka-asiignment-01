package edu.knoldus
import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.util

import org.apache.kafka.common.serialization.Serializer

class CaseClassSerialization extends Serializer[Students] {

 override def configure (configs: util.Map[String, _], isKey: Boolean): Unit = {

 }


 def serialize (topic: String, data: Students): Array[Byte] = {
  try {
   val byteOutStream = new ByteArrayOutputStream ()
   val objOutStream = new ObjectOutputStream (byteOutStream)
   objOutStream.writeObject (data)
   objOutStream.close ()
   byteOutStream.close ()
   byteOutStream.toByteArray
  }
  catch {
   case msg: Exception => throw new Exception (msg.getMessage)
  }
 }

 override def close (): Unit = {}


}

