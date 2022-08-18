# Movie Lens Assignment

 Movie Lens Assignment is a REST API developed using Spring Boot, H2 Database with sample data from movielens.

It has few APIs to fetch the movies based on year, genre and rating.

It contains a data pipeline to load all the required information.

## Installation

Use the pom.xml to download all the required libraries for this project.

## Data structure

SnowFlake scheme is used to structure the data after cleaning it. The detailed ER diagram is available in the folder /ER.

Since there was a necessity to create multi level DIMENSION Tables away from FACT Table.

https://en.wikipedia.org/wiki/Snowflake_schema


In the real world, Apache Spark would be a suitable approach in processing these huge datasets.
Since it has the benefits of both real-time and batch processing the data.


## Swagger

```
GET /api/getMoviesByDateRange
GET /api/getMoviesByGenre
GET /api/getMoviesByRating
GET /api/load
```

## Feedback
Feedbacks are welcome. 


## License
[None]
