# JSON SerDe performance in Flink/Kafka environment
In this repo I compare the following (popular) serializers:
- [Json4s](http://json4s.org/)
- [Jsoniter](https://github.com/plokhotnyuk/jsoniter-scala)

## Context
- Around **2.2 million** [GHTorrent](http://ghtorrent.org/streaming.html) records (60GB compressed).
- ~75% of these records are commits. 
- GHTorrent records are stored in a Kafka topic spread over **4** partitions compressed with **gzip**.

The Flink application reads, filters and parses the GHTorrent records to commits.