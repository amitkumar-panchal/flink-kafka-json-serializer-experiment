package nl.wouterr.experiment.serializer

import java.nio.charset.StandardCharsets

import nl.wouterr.experiment.Protocol.Record
import org.apache.flink.api.common.serialization.DeserializationSchema
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.read

class Json4sRecordDeserializer extends DeserializationSchema[Record] {
  implicit val formats = DefaultFormats

  override def deserialize(message: Array[Byte]): Record = {
    read[Record](new String(message, StandardCharsets.UTF_8))
  }

  override def isEndOfStream(nextElement: Record): Boolean = false

  override def getProducedType: TypeInformation[Record] =
    TypeInformation.of(classOf[Record])
}
