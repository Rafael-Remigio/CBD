/* EX:B:1 */
select JSON * from user;

/* EX:B:2 */
select JSON * from video;

/* EX:B:3 */
select JSON * from Comment_per_author; 

/* EX:B:4 */
select JSON * from Comment_per_video;

/* EX:B:5 */
select JSON * from Follower;

/* EX:B:6 */
select JSON * from Event;

/* EX:B:7 */
select JSON * from Rating;

/* EX:C:7 */
SELECT * FROM Video WHERE author = 'user13@ua.pt'ALLOW FILTERING;

/* EX:C:8 */
SELECT * FROM Comment_per_author WHERE author = 'clau@sof.pt' ORDER BY upload_timestamp DESC;

/* EX:C:9 */
SELECT * FROM Comment_per_video WHERE video_id =19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d;

/* EX:C:10 */
SELECT avg(value) as Average_rating, count(value) as Reviews FROM Rating WHERE video_id = 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d;

/* EX:D:1 */
SELECT * FROM Comment_per_video WHERE video_id = 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d  ORDER BY upload_timestamp DESC LIMIT 3;

/* EX:D:2 */
select tags from Video where id = 98b38bd0-70f7-11ed-ab27-35c20f9ddb86;

/* EX:D:3 */
SELECT * FROM Video WHERE tags CONTAINS 'Tag1' ALLOW FILTERING;

/* EX:D:4 */
SELECT * FROM Event WHERE user = 'clau@sof.pt' AND video_id = 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d LIMIT 5;

/* EX:D:5 */
cqlsh:cbd_102435_ex2> SELECT * FROM Video WHERE author = 'user1@ua.pt' AND upload_timestamp < '2024-02-03 12:26:00' allow filtering;

/* EX:D:6 */
SELECT * from Video LIMIT 10;
 

/* EX:D:7 */
SELECT * FROM Follower WHERE video_id=19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d ALLOW FILTERING;

/* EX:D:7 */
