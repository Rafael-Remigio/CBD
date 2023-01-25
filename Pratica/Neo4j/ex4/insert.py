from neo4j import GraphDatabase

driver = GraphDatabase.driver("bolt://localhost:7687")

AUTH = ("neo4j", "mynewpass")

firstQuery = "CREATE CONSTRAINT FOR (book:Book) REQUIRE book.ISBN IS UNIQUE; CREATE CONSTRAINT FOR (p:Publisher) REQUIRE p.c IS UNIQUE; CREATE CONSTRAINT FOR (aut:Author) REQUIRE aut.Name IS UNIQUE; CREATE CONSTRAINT FOR (user:User) REQUIRE user.Name IS UNIQUE;"

""" 
with driver.session(database="neo4j") as session:
    for i in firstQuery.split(";")[:-1]:
        output = session.execute_write(lambda tx: tx.run(i).data())
    

print('Inserting data')


with open("BookReviewDataSet/books.csv", 'r') as file:
    with driver.session(database="neo4j") as session:

        file.readline()
        for line in file:
            if line.split(";").__len__() == 8:
                ISBN,Title,Author,Year,Publisher,f,f1,f2 = line.split(";")[:8]
                query = ' CREATE (book:Book {ISBN: ' + ISBN + ', Title: '+ Title + ' })' + ' MERGE (pub:Publisher {Name:' + Publisher + '}) ' + 'MERGE (aut:Author {Name: ' + Author + ' }) '

                output = session.execute_write(lambda tx: tx.run(query).data())
 

print('Inserting data')


with open("BookReviewDataSet/books.csv", 'r') as file:
    with driver.session(database="neo4j") as session:

        file.readline()
        for line in file:
            if line.split(";").__len__() == 8:
                ISBN,Title,Author,Year,Publisher,f,f1,f2 = line.split(";")[:8]
                query = ' Match (book:Book {ISBN: ' + ISBN + ' }) ,' + ' (pub:Publisher {Name:' + Publisher + '}) ' + 'CREATE (pub)-[:published]->(book) ' 
                output = session.execute_write(lambda tx: tx.run(query).data())
                query = '\n Match (book:Book {ISBN: ' + ISBN + ' }) ,' + '(aut:Author {Name:'+ Author + '}) ' + 'CREATE (aut)-[:wrote]->(book) ' 
                output = session.execute_write(lambda tx: tx.run(query).data())

print('Inserting data')


with open("BookReviewDataSet/users.csv", 'r') as file:
    with driver.session(database="neo4j") as session:

        file.readline()
        for line in file:
            if line.split(";").__len__() == 3:
                id,location,age = line.split(";")[:3]
                query = ' Create (book:User {name: ' + id + ' , location: '+location+', age: ' + age + '  })'
                output = session.execute_write(lambda tx: tx.run(query).data())

print('Inserting data')


"""
with open("BookReviewDataSet/ratings.csv", 'r') as file:
    with driver.session(database="neo4j") as session:

        file.readline()
        for line in file:
            if line.split(";").__len__() == 3:
                id,isbn,score = line.split(";")[:3]
                if id == '"115490"' or id == '"115537"':
                    print("here")
                    query = ' Match (user:User {name: ' + id + ' }) ,' + ' (book:Book {ISBN:' + isbn + '}) ' + 'CREATE (user)-[:read {rating: ' + score + '}]->(book) ' 
                    output = session.execute_write(lambda tx: tx.run(query).data())


driver.close() 