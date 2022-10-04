package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.simple.parser.ParseException;

import org.springframework.ui.Model;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller // HTTP requests are handled as a controller, using the @Controller annotation
public class Schedule {

    // CONTROLLER handles GET request for /birds, maps it to birds() method
    @GetMapping("/schedule")
    public String schedule(Model model) throws IOException, InterruptedException, ParseException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://nfl-schedule.p.rapidapi.com/v1/schedules"))
		.header("X-RapidAPI-Key", "2deba3c7c5msh59e591f91803406p14659ajsn14474595701e")
		.header("X-RapidAPI-Host", "nfl-schedule.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
// System.out.println(response.body());

        // alternative #2: convert response.body() to JSON object
        Object obj = new JSONParser().parse(response.body());
        JSONObject jObj = (JSONObject) obj;
        System.out.println(jObj);

        // pass stats to view
        model.addAttribute("jObj", jObj);

        return "schedule";

    }
}

// HttpRequest request = HttpRequest.newBuilder()
// .uri(URI.create("https://nfl-schedule.p.rapidapi.com/v1/schedules"))
// .header("X-RapidAPI-Key",
// "2deba3c7c5msh59e591f91803406p14659ajsn14474595701e")
// .header("X-RapidAPI-Host", "nfl-schedule.p.rapidapi.com")
// .method("GET", HttpRequest.BodyPublishers.noBody())
// .build();
// HttpResponse<String> response = HttpClient.newHttpClient().send(request,
// HttpResponse.BodyHandlers.ofString());
// System.out.println(response.body());