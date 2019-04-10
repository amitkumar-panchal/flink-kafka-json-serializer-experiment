package nl.wouterr.experiment.serializer

import nl.wouterr.experiment.Protocol.Record
import org.apache.flink.api.common.functions.MapFunction

class JsoniterCommitExtractor extends MapFunction[Record, Commit] {}
