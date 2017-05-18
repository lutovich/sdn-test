package org.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Movie
{
    @GraphId
    private Long id;

    private String title;
    private int released;

    public Movie()
    {
    }

    public Movie( String title, int released )
    {
        this.title = title;
        this.released = released;
    }

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getReleased()
    {
        return released;
    }

    @Override
    public String toString()
    {
        return "Movie{" +
               "title='" + title + '\'' +
               ", released=" + released +
               '}';
    }
}
