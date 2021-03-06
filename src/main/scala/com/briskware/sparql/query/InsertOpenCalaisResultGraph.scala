package com.briskware.sparql.query

import com.briskware.sparql.{SparqlUpdate, PrefixMapping}
import java.net.URI

case class InsertOpenCalaisResultGraph(body : String, resultsGraphURI : URI, requestorURI : URI)(implicit pm : PrefixMapping)
    extends SparqlUpdate()(pm) {

  override def statement = {
    build(s"""
      |DROP SILENT GRAPH <$resultsGraphURI>;
      |INSERT DATA {
      |  GRAPH <$resultsGraphURI> {
      |    $body
      |  }
      |};
      |INSERT DATA {
      |   <$requestorURI> fo-publisher:hasTextMinerSubmission <$resultsGraphURI>
      |}
      """)
  }
}
