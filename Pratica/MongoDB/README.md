# Mongo

Mongo makes me think of the mango fruit and that is good enougth to make me use it

# Indexes

Fundamentally, indexes in MongoDB are similar to indexes in other database systems. MongoDB defines indexes at the collection level and supports indexes on any field or sub-field of the documents in a MongoDB collection.




## Default _id Index
MongoDB creates a unique index on the _id field during the creation of a collection. The _id index prevents clients from inserting two documents with the same value for the _id field. You cannot drop this index on the _id field.



To create an index in the Mongo Shell, use db.collection.createIndex()
Example:

```
    db.collection.createIndex( { name: -1 } ) 
```

### Index Types

* Single Field -> In addition to the MongoDB-defined _id index, MongoDB supports the creation of user-defined ascending/descending indexes on a single field of a document.

* Compound Index -> MongoDB also supports user-defined indexes on multiple fields, i.e. compound indexes.

* Multikey Index -> MongoDB uses multikey indexes to index the content stored in arrays. If you index a field that holds an array value, MongoDB creates separate index entries for every element of the array. These multikey indexes allow queries to select documents that contain arrays by matching on element or elements of the arrays. 

* Geospatial Index -> To support efficient queries of geospatial coordinate data, MongoDB provides two special indexes: 2d indexes that uses planar geometry when returning results and 2dsphere indexes that use spherical geometry to return results.
 
* Text Indexes -> MongoDB provides a text index type that supports searching for string content in a collection. These text indexes do not store language-specific stop words (e.g. "the", "a", "or") and stem the words in a collection to only store root words.

* Hashed Indexes -> To support hash based sharding, MongoDB provides a hashed index type, which indexes the hash of the value of a field.

* Clustered Indexes -> Starting in MongoDB 5.3, you can create a collection with a clustered index. Collections created with a clustered index are called clustered collections. See [Clustered Collections](https://www.mongodb.com/docs/manual/core/clustered-collections/#std-label-clustered-collections).

