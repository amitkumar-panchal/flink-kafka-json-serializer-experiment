package nl.wouterr.experiment

object Protocol {

  /** Represents a record as retrieved from GHTorrent.
    *
    * @param routingKey the routing key (e.g. evt.push.insert)
    * @param contents the content of the queue record.
    */
  case class Record(routingKey: String, contents: String)

  /** Every GHTorrent record has an _id object.
    *
    * @param `$oid` the object id.
    */
  case class _id(`$oid`: String)

}
