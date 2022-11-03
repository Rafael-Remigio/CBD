# Encoding and Evolution

Applications will change over time. A change to an application’s features also requires a change to data that it stores.

Diferent data models deal with this change in different ways

* **Relational Databases** for example assume that all data in the database conforms to one schema: although that schema can be change (through schema migrations; i.e., ALTER statements)

* **Schemaless** Databases, DBs that don't enforce a Schema, the database may contain the older and newer formats written at different times


### When a change does happen

When a data format or schema changes the application code usually also changes

* With server-side applications you may want to perform a rolling upgrade (also known as a staged rollout), deploying the new version to a few nodes at a time, checking whether the new version is running smoothly, and gradually working your way through all the nodes.

* With client-side applications you’re at the mercy of the user, who may not install
the update for some time.

We need then to maintain **Compatibility**, both:
* Backward (Newer code can read data that was written by older code)
* Foward (Older code can read data that was written by newer code)

## Formats for Encoding Data

Programs usually work with data in two different representations:

* In memory, data is kept in objects, structs, lists, arrays, hash tables, trees, (...)

* Over the Network we usually encode objects in a specific format (for example JSON). Because of pointers and the fact that they only hold value in a single machine, the representation and the  data Structures need to change a lot, and are very different from what is normally used in memory.

We then need some sort of translation between the two representations

* **encoding** -> The translation from ***in-memory*** representation into a ***byte-Sequence*** representation (also known as serialization or marshalling)
* **decoding** -> The reverse operation (also known as parsing, deserialization, unmarshalling)


## Language-Specific Formats // Serialization

Many programming languages come with built-in support for encoding in-memory. Java has java.io.Serializable, Python has pickle, Ruby has marshal (...)

These encoding libraries are very convenient, because they allow in-memory objects to be saved and restored with minimal additional code. This can be very advantagious but also it not used because of the problems it carries.

**Problems** 
* The encoding usually **corresponds to a specific programming Language**, and reading it in another language is almost impossible. 
* In order to read and use this data **we need to instantiate the object**, this is **cumbersome** and also it could be a very big **Security Flaw**
* They are meant for easy and fast encoding and decoding, so they they are **not good to ensure forward and backward compatibility**
* **Some are not efficient in terms of size and Decode and Encode time** (ie. Java's built-in serialization)

## Other encoding Formats

* ### Textual Formats
    * **CSV**
    * **JSON**
    * **XML**
    * **RDF**
    * The advantage of Textual Formats is that they are human-readable
    * Ambiguity between numbers and Strings
    * Some are Schemaless
    * Are Good and used in most Systems
* ### Binary Encoding
    * **BSON** (there are others)
    * More compact, faster to parse
    * None are as widely adopted as the Textual Versions JSON and XML


### CSV - Comma-Separated Values

Not fully standardized
* Different field separators (commas, semicolons) 
* Different escaping sequences
* No encoding information
* you cannot distinguish between a number and a string that happens to consist of digits

### XML - Extensible Markup Language
* Representation of semi-structured data
* Simplicity, generality and usability across the Internet
* Very good and still widely used
* you cannot distinguish between a number and a string that happens to consist of digits
```
<?xml version="1.0" encoding="UTF-8"?>
<note>
  <from>Jani</from>
  <to>Tove</to>
  <message>Remember me this weekend</message>
</note>
```
### JSON – JavaScript Object Notation
* Open standard for data interchange
* Simplicity: text-based, easy to read and write
* Universality: object and array data structures
* language independent
```
{"menu": {
  "id": "file",
  "value": "File",
  "popup": {
    "menuitem": [
      {"value": "New", "onclick": "CreateNewDoc()"},
      {"value": "Open", "onclick": "OpenDoc()"},
      {"value": "Close", "onclick": "CloseDoc()"}
    ]
  }
}}
```

### BSON – Binary JSON
* Binary-encoded serialization of JSON documents
* lightweight, traversable, efficient
* convenient storage of binary information
* fast in-memory manipulation
* Used by MongoDB

### RDF – Resource Description Framework
* Language for representing information about
resources in the World Wide Web
* RDF is written in XML
* Examples of use
    * Describing properties for shopping items, such as price and availability
    * Describing time schedules for web events
    * Describing content for search engines

```
<?xml version="1.0"?>

<RDF>
  <Description about="https://www.w3schools.com/rdf">
    <author>Jan Egil Refsnes</author>
    <homepage>https://www.w3schools.com</homepage>
  </Description>
</RDF>
```

## Apache Thrift and Protocol Buffers

Apache Thrift and Protocol Buffers (protobuf) are binary encoding libraries that are based on the same principle.

A binary encoding library that
require a schema for any data that is encoded

To encode the data in Protocol Buffers, you first describe the schema of the data:
```
message Person {
    required string user_name = 1;
    optional int64 favorite_number = 2;
    repeated string interests = 3;
}
```

* Language-neutral, platform-neutral
* Small, fast, simple

Intended usage
* Schema creation
* automatic source code generation 
* sending messages between applications 
