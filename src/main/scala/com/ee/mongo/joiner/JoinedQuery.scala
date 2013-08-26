package com.ee.mongo.joiner


case class Relationship[SOURCE <: AnyRef,TARGET <: AnyRef,BINDING](property:String)
