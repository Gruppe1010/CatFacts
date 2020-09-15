package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CatFact implements Comparable<CatFact>
{
    private String text;
    private Date createdAt;
    private Date updatedAt;
    
    // constructor
    public CatFact() {}

    // get + set
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
    
    // Andre metoder
    public int compareTo(CatFact catFact)
    {
        //TODO: parse to Int og sammenlign de to int-værdier
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        
        // simpleDateFormat.format(createdAt) == dato i yyyyMMdd
        // Integer.parseInt(simpleDateFormat.format(createdAt)) == Integer.parseInt(yyyyMMdd)
        
        int date1 = Integer.parseInt(simpleDateFormat.format(createdAt));
        int date2 = Integer.parseInt(simpleDateFormat.format(catFact.createdAt));
        
        // return -1 = this.obj < param.obj
        // return 1 = this.obj > param.obj
        // return 0 = this.obj == param.obj
    
        if(date1 > date2)
        {
            return 1;
        }
        else if(date1 < date2)
        {
            return -1;
        }
        
        return 0;
    }
    
    @Override
    public String toString()
    {
        return "<br><b>Cat Fact: </b>" + text + "</br>" + "<br><b>Created: </b>" + createdAt + "</br>" + "<br><b>Updated: </b>" + updatedAt + "</br><br></br>";
    }
}
