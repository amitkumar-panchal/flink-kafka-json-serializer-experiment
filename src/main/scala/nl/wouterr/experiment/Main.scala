package nl.wouterr.experiment

import nl.wouterr.experiment.Protocol.Record
import nl.wouterr.experiment.serializer.{
  Json4sRecordDeserializer,
  JsoniterCommitExtractor,
  JsoniterRecordDeserializer
}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.flink.api.scala._

object Main {

  /** Kafka configuration */
  val kafkaBroker = "localhost:29092"
  val recordTopic = "ght_input"

  val brokerProperties = new java.util.Properties()
  brokerProperties.put("bootstrap.servers", kafkaBroker)

  val environment = StreamExecutionEnvironment.getExecutionEnvironment

  def main(args: Array[String]): Unit = {
    val kafkaJsoniterConsumer = new FlinkKafkaConsumer[Record](
      recordTopic,
      new JsoniterRecordDeserializer,
      brokerProperties)

    kafkaJsoniterConsumer.setStartFromLatest()

    val kafkaJson4sConsumer = new FlinkKafkaConsumer[Record](
      recordTopic,
      new Json4sRecordDeserializer,
      brokerProperties)

    //environment
    //  .addSource(kafkaJsoniterConsumer)
    // .filter(_.routingKey == "ent.commits.insert")

    environment
      .addSource(kafkaJsoniterConsumer)
      .filter(_.routingKey == "ent.commits.insert")
      .map(new JsoniterCommitExtractor)
      .print()

    environment.execute("JSON4s vs Jsoniter experiment")
  }

}
