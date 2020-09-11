package com.example.demo.models;

import java.util.Date;

public class CatFact implements Comparable<CatFact>
{
    private String text;
    private Date createdAt;
    private Date updatedAt;

    public int compareTo(CatFact catFact)
    {
        return createdAt.compareTo(catFact.createdAt);
    }

    public CatFact()
    {

    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        return "Cat Fact: " + text + "      Created: " + createdAt + "      Updated: " + updatedAt + "          ";
    }
}
