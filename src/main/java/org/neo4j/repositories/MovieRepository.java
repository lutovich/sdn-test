package org.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

import org.neo4j.domain.Movie;

public interface MovieRepository extends GraphRepository<Movie>
{
    @Query( "MATCH (m:Movie) WHERE m.title = {0} AND 10/0=1 RETURN m" )
    List<Movie> findByTitle( String title );
}
