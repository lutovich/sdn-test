package org.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import org.neo4j.domain.Movie;

public interface MovieRepository extends GraphRepository<Movie>
{
    @Query( "MATCH (m:Movie) WHERE m.title = {0} RETURN m AS movie, 10/0 AS other" )
    Movie findByTitle( String title );
}
