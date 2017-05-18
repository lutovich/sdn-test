package org.neo4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.neo4j.domain.Movie;
import org.neo4j.repositories.MovieRepository;

@Service
public class MovieService
{
    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void save( Movie movie )
    {
        movieRepository.save( movie );
    }

    @Transactional
    public List<Movie> findByTitle( String title )
    {
        return movieRepository.findByTitle( title );
    }
}
