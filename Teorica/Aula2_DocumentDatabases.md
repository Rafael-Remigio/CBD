Aula 30/09

Document Oriented databases (ie mongo db)

	Many to many relationship
		-> last year the solution was a relational db, with 3 tables: Users, contract, users-contract with 2 foreign keys; 3 distnct data structures/tables
	
		-> document databases is similar to Hierarchical db; Sometimes it is important to have aggregated information. mostly for distributed db it usually user document db, because joins operations are not possible (doing a join over a network is very cumbersome). There for it is sometimes better to have data in an aggregated way, even if that leads to duplication; also a problem can be changes to information, because we need to change it in multiple documents; in a relational db it makes it very hard to refactor and change during production, and while there is already data stored; Document db are without schema witch makes it easier to restructure and redesing;
		
	In a production scenario a database model needs to be specific to the problem we are trying to solve

		
	Usually like json or xml; JSON is more used today;

	in mongo we will have an ID by default (like an index), but we can have secondary indexes

	Different documents may have diferent attributes, because there is schema flexibility; this makes it easier to redesing

	Good for one-to-many, not so good for many-to-many, (no joins)

	Some models and database allow convergence of document and relational databases

	


Mongo DB

	JSON document database 
	(it is open source)
	eventual consistency ->
		Eventual consistency, also called optimistic replication, is widely deployed in distributed systems and has origins in early mobile computing projects. A system that has achieved eventual consistency is often said to have converged, or achieved replica convergence. Eventual consistency is a weak guarantee – most stronger models, like linearizability, are trivially eventually consistent.

		data integrety and consitency:
			Integrity means that the data is correct. Consistency means that the data format is correct, or that the data is correct in relation to other data. consistency ensures that data in diferent places is the same; in a relational database data is always consistant because there is only one entity; in distributed databases consistency is a very big problem; Then we must have an eventual consistency, we need to replicate and change data in all the nodes


	master-slave replication, master is in charge of replication and changing the slaves

	
	indexes use binary trees like sql
