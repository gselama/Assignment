CREATE TABLE MOVIE(MOVIEID INT PRIMARY KEY, TITLE VARCHAR(255), RELEASE_YEAR INT, GENRES VARCHAR(500));

CREATE TABLE RATING(USERID INT, MOVIEID INT, RATING DOUBLE, UPDATED_ON BIGINT);

ALTER TABLE RATING ADD FOREIGN KEY (MOVIEID) REFERENCES MOVIE(MOVIEID);

CREATE TABLE TAG(USERID INT, MOVIEID INT, TAG VARCHAR(400), UPDATED_ON BIGINT);

ALTER TABLE TAG ADD FOREIGN KEY (MOVIEID) REFERENCES MOVIE(MOVIEID);

CREATE TABLE LINK(MOVIEID INT, IMDB_ID VARCHAR(100), TMDB_ID VARCHAR(100));

ALTER TABLE LINK ADD FOREIGN KEY (MOVIEID) REFERENCES MOVIE(MOVIEID);

CREATE TABLE GENOME_TAGS(TAG_ID INT PRIMARY KEY, TAG_NAME VARCHAR(255));

CREATE TABLE GENOME_SCORES(MOVIEID INT, TAG_ID INT, RELEVANCE DOUBLE);

ALTER TABLE GENOME_SCORES ADD FOREIGN KEY (MOVIEID) REFERENCES MOVIE(MOVIEID);

ALTER TABLE GENOME_SCORES ADD FOREIGN KEY (TAG_ID) REFERENCES GENOME_TAGS(TAG_ID);
