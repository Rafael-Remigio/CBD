# Advanced Databases

Many Applications nowadays are more **data-intensive** than **compute-intensive**. This means that, for a lot of applications, CPU Power is not a lmiting factor. A lot of problems consist of:
* The ammount of data
* Complexity of data
* Speed of data changes

### Common operations in Data Systems
* (***DataBases***) Store data so that it can be found later
* (***Caching***) Remember the result of an expensive operation
* (***Search Index***) Allow users to search data by keywords or filters
* (***Message Queues***) Send message to another proccess to be handled asynchronously
* (***Stream Processing***) Observer what is happening and act on events as they occur
* (***Batch Processing***) Periodically crunch a large ammount of accumulated data

## Data Systems

More and more, applications have wide-ranging requirements. Many times these requirements are broken down into diferent tasks using different tools. They may need **caching**, a **text Search Server**(Solr), **main database**(MySQL), etc.

**Example of an architecture for a data System involving serveral components**
<img src="images/architecture.png"></img>
<sub>(image from Designing Data-Intensive Applications by Martin Kleppmann)<sub>

## Data Systems Challenges and Requirements

### Challenges
* How to ensure data remains correct and complete
* Provide constantly good performance
* How do you scale and handle bigger loads
* What is a good Api for a service

### Requirements
- **Reliability** -> should continue performing the correct function at the desired performance (even if there are issues)
- **Scalability** -> As the system grows, there should be ways to handle that growth
- **Maintainability** -> Many people, overtime, should be able to work with the System. (Maintaining the current behaviour and adopting the systems to new use cases)


---------------------------------------------


# Database Systems (brief introduction)
A **Database** is normally refered as a set of related data and it's organization

**DBMS(DataBase Managment System)** controls access to this data. Allows:
* writting 
* searching
* updating 
* retrieving 
* removing

From the **1980s until now today**, Relational Databases have been domination the market. They achived this because they are:
* Fast
* A normalized DB has no redundant data
* Developers are very familiar with Relational DBs
* The querie language for SQL is very well known and very good

In the **2000's** we have alse seen the start and growth of **OLAP(OnLine Analytical Processing)** and with this other models have been created

## Database Models

Database Models play a very important role in the development of software. They change:
* how software is written 
* how we think about the problems we are solving

A **Database Model** shows the logical structure of a database, including relanstioships and constrains that determine how data can be stored and accesses.

**Types of Database Models**:
* Hierarchical database model
* Relational model
* Network model
* Object-oriented database model
* Entity-relationship model
* Document model
* Entity-attribute-value model
* Star schema

-------------------

## ACID Properties in DBMS

A **Transaction** are single logical unit of work that access and possibly modifies contents in a Database.
Transactions access data using **read/write** operations. To maintain consistency in a Database we must follow certain properties. They are called **ACID**. 

### ACID
* **A** -> **Attomic** All changes to data are performed as if they are a single/atomic operation. This also means that if a transaction takes more than one operation to be completed, then all operations complete and commit or none do.  
* **C** -> **Consistency** A transaction transforms the database from one consistent state to anothe consistent state. Data is consistent when a transaction starts and when it ends
* **I** -> **Isolation** The intermideate state of transactions is invisible to other transactions. The results of a transaction are not visible until the transaction is completed
* **D** -> **Durable** The result of a failure transaction suvive failures. After a transaction is completed, even in the event of a crash or failure, transactions and changes won't be undone

----------------------------------
