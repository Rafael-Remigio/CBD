## OLTP - Online Transaction Processing

oltp -> term transactions processing mean that the client can make very fast read and write; all databases we worked with do this

## Data Analytics

the access patters are quite diferent from oltp
usually analytic query needs to scan over huge ammounts of data to calculate and aggregate statitcs

Data analytics is usually not for the end user but for the managment team and business analytics

## OLAP - Online Analytic Processing

RDBMS and SQL work well for OLTP-type queries as well as OLAP-type queries

OLAP use a separate database

OLAP will most likely be read Only
data is usually extracted from OLPT databases, transformed, cleaned up and loaded to a data warehouse

### Extract-Transform-Load (ETL)
we need to extract and trasnform data from diferent sources all to the same warehouse, and combining all of it.

### Why separate and combining

For small companies it does not make sense to separete data, since there is not so much data, and seperating takes extra cost

Why seperate

* missing data, it supports long historical data, that other dbs wont maintain
* data consilidation 
* data quality because of the transformation proccess

### For data analytics we usually have different DBMS

### Schemas for Analytics

We usually have only one Table, a big Fact Table

No normalization, just one big table we giant rows.

Advantage of this is that if we want to study a single attribute it makes it much faster and easier to traverse it;

This model is not for time efficiency but for analytics

## How to store all theese petabytes of data

Fact tables are sometimes over 100 columns and have billions of rows


### Collumn Oriented storage

* Usually to organize this we just store each collumn in a single row. To write this is very bad but we usually write very litle and usually we do it in batch

* Since there is alot of data and values, column data can be compressed, with stuff like bitmap encoding, we collapse data to bitmap so it is faster
* column sorting, columns are usually sorted by insert order, however we can choose another other as like a indexing mechanism. It makes compression better as well

* Writing problem -> way slower for writing


The midleground to column Oriented storage for writing we use: **LMS-Trees (Log Structured Merge)**


## Materialized Views

