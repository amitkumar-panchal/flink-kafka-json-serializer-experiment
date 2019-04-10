package nl.wouterr.experiment

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

object Main {

  /** Kafka configuration */
  val kafkaBroker = "localhost:29092"
  val recordTopic = "ght_input"

  val environment = StreamExecutionEnvironment.getExecutionEnvironment

  def main(args: Array[String]): Unit = {
    val kafkaConsumer = new FlinkKafkaConsumer()

    environment.execute("JSON4s vs Jsoniter experiment")
  }

}
