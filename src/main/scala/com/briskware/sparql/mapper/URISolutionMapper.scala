package com.briskware.sparql.mapper

import com.briskware.sparql.client.QuerySolution

import java.net.URI

/**
 * The mapper expects that a query solution has a URI field.
 * It maps the solution to that field.
 */
class URISolutionMapper(fieldName : String) extends SolutionMapper[URI] {

  def map(querySolution : QuerySolution) : URI = querySolution.asValueMap(fieldName).asUri
}
