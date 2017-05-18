package org.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.neo4j.domain.Movie;
import org.neo4j.ogm.authentication.UsernamePasswordCredentials;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.services.MovieService;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableNeo4jRepositories( value = "org.neo4j.repositories" )
public class SampleMovieApplication
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run( SampleMovieApplication.class, args );
        MovieService movieService = (MovieService) context.getBean( "movieService" );

        movieService.save( new Movie( "Logan", 2017 ) );

        Movie movie = movieService.findByTitle( "Logan" );
        System.out.println( movie );
    }

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration()
    {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        config.driverConfiguration()
                .setDriverClassName( "org.neo4j.ogm.drivers.bolt.driver.BoltDriver" )
                .setCredentials( new UsernamePasswordCredentials( "neo4j", "test" ) )
                .setURI( "bolt://localhost" );
        return config;
    }

    @Bean
    public Neo4jTransactionManager transactionManager()
    {
        return new Neo4jTransactionManager( sessionFactory() );
    }

    @Bean
    public SessionFactory sessionFactory()
    {
        return new SessionFactory( getConfiguration(), "org.neo4j.domain" );
    }
}
