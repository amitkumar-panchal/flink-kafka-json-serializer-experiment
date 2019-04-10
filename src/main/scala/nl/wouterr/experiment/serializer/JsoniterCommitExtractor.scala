package nl.wouterr.experiment.serializer

import java.text.SimpleDateFormat
import java.util.{Date, Locale}

import nl.wouterr.experiment.Protocol.{Commit, Record}
import org.apache.flink.api.common.functions.MapFunction
import com.github.plokhotnyuk.jsoniter_scala.macros._
import com.github.plokhotnyuk.jsoniter_scala.core._

class JsoniterCommitExtractor extends MapFunction[Record, Commit] {

  @transient
  implicit lazy val codec = JsonCodecMaker.make[Commit](CodecMakerConfig())

  override def map(value: Record): Commit = {
    readFromString(value.contents)
  }
}
