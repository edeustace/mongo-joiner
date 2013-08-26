package com.ee.mongo.joiner.models

import org.bson.types.ObjectId

case class Item(name: String, subject : ObjectId, id : ObjectId = ObjectId.get)

case class Subject(name: String, category: String, id : ObjectId = ObjectId.get)



