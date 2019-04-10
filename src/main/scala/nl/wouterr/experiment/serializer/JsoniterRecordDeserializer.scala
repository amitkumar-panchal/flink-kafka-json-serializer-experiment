package nl.wouterr.experiment.serializer

import com.github.plokhotnyuk.jsoniter_scala.macros.{
  CodecMakerConfig,
  JsonCodecMaker
}
import com.github.plokhotnyuk.jsoniter_scala.core._
import nl.wouterr.experiment.Protocol.Record
import org.apache.flink.api.common.serialization.DeserializationSchema
import org.apache.flink.api.common.typeinfo.TypeInformation

class JsoniterRecordDeserializer extends DeserializationSchema[Record] {

  override def deserialize(message: Array[Byte]): Record = {
    implicit val codec = JsonCodecMaker.make[Record](CodecMakerConfig())
    readFromArray(message)
  }

  override def isEndOfStream(nextElement: Record): Boolean = false

  override def getProducedType: TypeInformation[Record] =
    TypeInformation.of(classOf[Record])
}
