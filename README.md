# Mongo Query

### The problem

* Doing mongo queries on a single collection/document is simple
* Doing joined queries on mongo collections requires work

### The solution

Provide a dsl for handling joined queries


#### Example

    //db.items
    { "name" : "Math + Art thingy", subjectIds: [ "1", "2" ]}
    { "name" : "Art thingy", subjectIds: [ "1", "2" ]}

    //db.subjects
    { "name" : "Math", id : "1"}
    { "name" : "Art", id : "2"}


    find items with string "Math" returns :


    { "name" : "Math + Art thingy", subjectIds: [ "1", "2" ]}


    What one normally does here is:

    def find(query:String) : List[Item] = {
      //direct search
      items = db.items.find({ name : /.*query.*/ })
      //subject search
      subjects = db.subjects.find({ name : /.*query.*/})
      val subjectIds = subjects.distinct.map( _.id)
      subjectItems = db.items.find({subjectIds: { $in: subjectId}})
      (items ++ subjectItems).distinct
    }


    What would be nice is:

    //Declare the relationship
    val relationships = db.items.link("subjectIds" -> "db.subjects.id")
    //Declare whats searchable by the query
    val searchable = db.searchable( "db.items.name", "db.subjects.name")

    def find(query:String) : List[Item] = {
      search(query, relationships, searchaple)
    }




