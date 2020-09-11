package com.example.demo.controllers;

import com.example.demo.models.CatFact;
import com.example.demo.services.CatFactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class CatFactController
{
    @GetMapping("/")
    @ResponseBody
    public String WelcomeCatFact()
    {
        return "Halli Hallo and welcome to Cat Facts!";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String singleCatFact() throws IOException
    {
        CatFactService singleFact = new CatFactService();

        return singleFact.fetchCatFact();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public ArrayList<String> tenCatFact() throws  IOException
    {
        CatFactService tenFact = new CatFactService();
        ArrayList<String> catFactList = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            catFactList.add(tenFact.fetchCatFact());
        }

        return catFactList;
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public ArrayList<String> tenSortByDateCatFact() throws IOException
    {
        CatFactService tenFact = new CatFactService();
        ArrayList<String> catFactList = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            catFactList.add(tenFact.fetchCatFact());
        }

        Collections.sort(catFactList);

        return catFactList;
    }
}
