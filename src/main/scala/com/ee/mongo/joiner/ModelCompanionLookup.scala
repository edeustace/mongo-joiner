package com.ee.mongo.joiner

import com.novus.salat.dao.ModelCompanion

class ModelCompanionLookup(val daos : Seq[ModelCompanion[_ <: AnyRef, _]]) {

    def getCompanion[S <: AnyRef,T <: AnyRef,B](r:Relationship[S,T,B]) : Option[ModelCompanion[T,B]] = {
      daos.find{ _ match {
        case d : ModelCompanion[T,B] => true
        case _ => false
      }
      }.map{ d => d.asInstanceOf[ModelCompanion[T,B]]}
    }
}
