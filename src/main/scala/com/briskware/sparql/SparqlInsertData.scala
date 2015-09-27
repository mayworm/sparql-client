package com.briskware.sparql

import spray.http.HttpMethods

abstract class SparqlInsertData()(implicit pm : PrefixMapping) extends SparqlStatement() {

  override def httpMethod = HttpMethods.POST
}
