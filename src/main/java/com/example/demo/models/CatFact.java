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
        
        // int dato1 = Integer.parseInt(simpleDateFormat.format(createdAt))
        // int dato2 = Integer.parseInt(simpleDateFormat.format(catFact.createdAt))
        
        // return dato1.compareTo(dato2); // ELLER skal man lave if??? - det skal vi nok
    
        String date1 = simpleDateFormat.format(createdAt);
        String date2 = simpleDateFormat.format(catFact.createdAt);
        
        return date1.compareTo(date2);
        
        // return createdAt.compareTo(catFact.createdAt);
    }
    
    @Override
    public String toString()
    {
        return "Cat Fact: " + text + "      Created: " + createdAt + "      Updated: " + updatedAt + "          ";
    }
}
