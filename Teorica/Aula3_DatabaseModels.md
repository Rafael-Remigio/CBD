Database Models beyond RDBMS

(RDBMS -> relational databases managment systems)

Data Models

	Nowadays data is one of the most important aspects
	Data changes 
		how the software is written
		how we think about the problem that we are solving. 

	Relational database is mostly used because it solves most problems

		Data bases can be shared among diferent applications

		SQL is very Standard and very good 
	

		ACID Properties -> 
			Atomic 
			Consistent 
			Isolated 
			Double

	In Computer science and computing histories techonologies dont last long but sql is very old and used for more than 40 years




	Nowadays there is a NOSQL movement:
		Why?
			Changes in techonology
			changes in use case

			Big increase in data volume and traffic

			Impendance Mismatch
				the information might be to scatterd, and maybe there are better solutions to a certain problem

	Normalization 
		consistency 
		no ambiguity
		one place so it is easy to update
		symplify tranlations to other languages

	Increased Data Volume
		There is way to much data nowadays, so it is hard to organize it, and should we even do it?

		Dealing with this
			Build Bigger Database machines
				-> This can be expensive
				-> Fundamental limits to machine size
			Build Clusters of smaller machines
				->Lots of small machines (commodity machines)
				->Each machine is cheap, potentially unreliable
				->Needs a DBMS which understands clusters
			(vertical vs horizontal scalling)

				sql server is hard to use on more distributed machines

	NoSQL movement
		
		-> non relation 
		-> simple api
		-> no schema 
		-> no acid requirments
		-> Inherently Distributed
		-> Open Source
	
	
		Uses BASE transactions

		CAP theorem
			in distributed databases we cannot have ACID, we must then have CAP
				
				Consistent -> writes are atomic
				Available -> will always return something
				Partition Tolerant -> allows to partition the cluster network

			CAP can only ensure 2 of the things 

				we must choose if we want consistency or availability
					CP
						If there is no consensus i will receive an Error
				
					AP
						We return the value even if we dont have certanty about all data in partition
				
					https://www.educative.io/blog/what-is-cap-theorem


		Core types
			– Key-value stores
			– Document stores
			– Column stores
			- Graph databases
