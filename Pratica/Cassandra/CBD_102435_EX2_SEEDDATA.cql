
USE cbd_101043_ex2;

INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user1@ua.pt', dateof(now()), 'Description1', 'Video1_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user2@ua.pt', dateof(now()), 'Description2', 'Video2_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user3@ua.pt', dateof(now()), 'Description3', 'Video3_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user4@ua.pt', dateof(now()), 'Description4', 'Video4_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user5@ua.pt', dateof(now()), 'Description5', 'Video5_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user6@ua.pt', dateof(now()), 'Description6', 'Video6_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user7@ua.pt', dateof(now()), 'Description7', 'Video7_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user8@ua.pt', dateof(now()), 'Description8', 'Video8_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user9@ua.pt', dateof(now()), 'Description9', 'Video9_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user10@ua.pt', dateof(now()), 'Description10', 'Video10_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user11@ua.pt', dateof(now()), 'Description11', 'Video11_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user12@ua.pt', dateof(now()), 'Description12', 'Video12_name', ['Tag1', 'Tag2','Tag3']);
INSERT INTO Video (id, author, upload_timestamp, description, name, tags) VALUES (now(), 'user13@ua.pt', dateof(now()), 'Description13', 'Video13_name', ['Tag1', 'Tag2','Tag3']);


INSERT INTO User (email, name, reg_timestamp, username) VALUES ('NathanLBarlow@dayrep.com', 'NathanLBar', dateof(now()), 'FenixDS');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('ThomasPKilpatrick@teleworm.us', 'Thomas', dateof(now()), 'EhHeHe');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('MarciaMMiller@rhyta.com', 'Marcia', dateof(now()), 'ClauSof');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('Williammmm@teleworm.us', 'William', dateof(now()), 'TotsAHuman1');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('WillHemphill@teleworm.us', 'William', dateof(now()), 'TotsAHuman2');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('Williamempll@teleworm.us', 'William', dateof(now()), 'TotsAHuman3');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('WillDHemphill@teleworm.us', 'William', dateof(now()), 'TotsAHuman4');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('WilliamDHemphill@telorm.us', 'William', dateof(now()), 'TotsAHuman5');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('WilliamDHemphill@teleworm.us', 'William', dateof(now()), 'TotsAHuman6');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('WilliamDHemphill@telewo.us', 'William', dateof(now()), 'TotsAHuman7');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('William@teleworm.us', 'William', dateof(now()), 'TotsAHuman8');
INSERT INTO User (email, name, reg_timestamp, username) VALUES ('WilDHemphill@telewo.us', 'William', dateof(now()), 'TotsAHuman9');




INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'FIRST', dateof(now())) ;
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'Also Second :)', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user1@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user3@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user2@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'Wait wtf?', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user4@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user5@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'WHATS HAPPENING', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user6@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'clau@sof.pt', 'Friggin Pleb', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user9@bot.com', 'Us Bots couldve done better', dateof(now()));
INSERT INTO Comment_per_author (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d , 'pedro@f.ag', 'WTF Dude did you actually?!', dateof(now()));

INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'FIRST', dateof(now())) ;
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'Also Second :)', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user1@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user3@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user2@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'Wait wtf?', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user4@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user5@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'ds@test.com', 'WHATS HAPPENING', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user6@bot.com', 'Hello DS', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'clau@sof.pt', 'Friggin Pleb', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'user9@bot.com', 'Us Bots couldve done better', dateof(now()));
INSERT INTO Comment_per_video (id, video_id, author, comment, upload_timestamp) VALUES ( now(), 1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d , 'pedro@f.ag', 'WTF Dude did you actually?!', dateof(now()));

INSERT INTO Follower (user,video_id) VALUES ('user2@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user3@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user4@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user5@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user6@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user7@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user8@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('user9@bot.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('ds@test.com', 1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d);
INSERT INTO Follower (user,video_id) VALUES ('ds@test.com', 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d);

INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com', 3ffcc5a0-0d4b-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 0);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com', 3ffcc5a0-0d4b-11ea-9d48-0b1cc2ad2f9d, 'Pause', dateof(now()), 310);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com', 3ffcc5a0-0d4b-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 310);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'user7@bot.com ',19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 0);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'clau@sof.pt',1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 0);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'clau@sof.pt',1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Stop', dateof(now()), 69);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com',1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 0);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com',1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 150);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com',1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Pause', dateof(now()), 200);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com',1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Play', dateof(now()), 200);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'ds@test.com',1f1a11e0-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Stop', dateof(now()), 349);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'pedro@f.ag',20a1ea60-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Start', dateof(now()), 0);
INSERT INTO Event (id, user, video_id, action, real_timestamp, video_timestamp) VALUES (now(),'pedro@f.ag',20a1ea60-0d6d-11ea-9d48-0b1cc2ad2f9d, 'Stop', dateof(now()), 50);
                     
INSERT INTO Rating (id, video_id, value) VALUES (now(), 20a1ea60-0d6d-11ea-9d48-0b1cc2ad2f9d, 1);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 19e006d0-0d6d-11ea-9d48-0b1cc2ad2f9d, 5);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d , 2);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d , 4);
INSERT INTO Rating (id, video_id, value) VALUES (now(), 1baab4b0-0d6d-11ea-9d48-0b1cc2ad2f9d , 3);