package com.example.demo.controllers;

import com.example.demo.models.CatFact;
import com.example.demo.services.CatFactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class CatFactController
{
    // localhost:8080/
    @GetMapping("/")
    public String WelcomeCatFact()
    {
       return "index";
    }
    
    public String arrayListToString(ArrayList<CatFact> catFactList)
    {
        String arrayListString = "";
        for(CatFact cf : catFactList)
        {
            arrayListString += cf.toString();
        }
        return arrayListString;
    }
    
    // localhost:8080/getSingle
    @GetMapping("/getSingle")
    @ResponseBody
    public String singleCatFact() throws IOException
    {
        CatFactService singleFact = new CatFactService();

        return singleFact.fetchCatFact().toString();
    }
    
    // localhost:8080/getTen
    @GetMapping("/getTen")
    @ResponseBody
    public String tenCatFact() throws  IOException
    {
        CatFactService tenFact = new CatFactService();
        ArrayList<CatFact> catFactList = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            catFactList.add(tenFact.fetchCatFact());
        }

        return arrayListToString(catFactList);
    }
    
    // localhost:8080/getTenSortByDate
    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String tenSortByDateCatFact() throws IOException
    {
        CatFactService tenFact = new CatFactService();
        ArrayList<CatFact> catFactList = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            catFactList.add(tenFact.fetchCatFact());
        }

        Collections.sort(catFactList);

        return arrayListToString(catFactList);
    }

    // localhost:8080/contains?c=CHAR&amount=ANTAL
    @GetMapping("/contains")
    @ResponseBody
    public String contain(@RequestParam char c, @RequestParam int amount) throws IOException
    {
        CatFactService catFactService = new CatFactService();
    
        CatFact catFact;
        
        int counter = 0;
        while(counter < 75) // vi ved ikke hvordan vi får den til at tjekke ALLE catfacts - så vi tjekker 75
        {
           catFact = catFactService.fetchCatFact();
           
           String catFactText = catFact.getText();
           
           int amountOfChar = 0;
           
           for(int i = 0; i < catFactText.length(); i++)
           {
               if(Character.toLowerCase(catFactText.charAt(i)) == Character.toLowerCase(c))
               {
                   amountOfChar++;
               }
           }
           
           if(amountOfChar >= amount)
           {
               return catFact.toString() + "amountofchar: " + amountOfChar + "c: " + c + "amount: " + amount;
           }
           counter++;
        }
       
        return "Sorry, no luck :'( (in the first 75 cat facts)";
    }
    
}
