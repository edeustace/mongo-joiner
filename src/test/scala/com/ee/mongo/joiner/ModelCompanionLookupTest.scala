package com.ee.mongo.joiner

import org.specs2.mutable.Specification
import com.ee.mongo.joiner.models.{Subject, Item}
import org.bson.types.ObjectId
import com.novus.salat.dao.ModelCompanion
import org.specs2.mock.Mockito

class ModelCompanionLookupTest extends Specification with Mockito {

  "the lookup will find the companion dao for a relationship" in {
    val r = Relationship[Item,Subject,ObjectId]("subject")
    val itemCompanion : ModelCompanion[Item,ObjectId] = mock[ModelCompanion[Item,ObjectId]]
    val subjectCompantion : ModelCompanion[Subject,ObjectId] = mock[ModelCompanion[Subject,ObjectId]]
    val lookup = new ModelCompanionLookup( Seq(itemCompanion, subjectCompantion))
    lookup.getCompanion(r) !== None
  }
}
