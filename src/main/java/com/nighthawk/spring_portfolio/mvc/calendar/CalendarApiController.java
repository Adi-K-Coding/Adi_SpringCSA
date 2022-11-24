// package com.nighthawk.spring_portfolio.mvc.calendar;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.JsonMappingException;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// /** Calendar API
//  * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns: {"year":2020,"isLeapYear":false}
//  */
// @RestController
// @RequestMapping("/api/calendar")
// public class CalendarApiController {

//     /** GET isLeapYear endpoint
//      * ObjectMapper throws exceptions on bad JSON
//      *  @throws JsonProcessingException
//      *  @throws JsonMappingException
//      */
//     @GetMapping("/isLeapYear/{year}")
//     public ResponseEntity<JsonNode> getIsLeapYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
//       // Backend Year Object
//       Year year_obj = new Year();
//       year_obj.setYear(year);  // evaluates Leap Year

//       // Turn Year Object into JSON
//       ObjectMapper mapper = new ObjectMapper(); 
//       JsonNode json = mapper.readTree(year_obj.isLeapYearToString()); // this requires exception handling

//       return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
//     }

//     @GetMapping("/firstDayOfYear/{year}")
//     public ResponseEntity<JsonNode> getFirstDayOfYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
//       // Backend Year Object
//       Year year_obj = new Year();
//       year_obj.setYear(year);  // evaluates Leap Year

//       // Turn Year Object into JSON
//       ObjectMapper mapper = new ObjectMapper(); 
//       JsonNode json = mapper.readTree(year_obj.firstDayOfYearToString()); // this requires exception handling

//       return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
//     }
//     // add other methods

//     @GetMapping("/dayOfYear/{year}")
//     public ResponseEntity<JsonNode> getDayOfYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
//       // Backend Year Object
//       Year year_obj = new Year();
//       year_obj.setYear(year);  // evaluates Leap Year

//       // Turn Year Object into JSON
//       ObjectMapper mapper = new ObjectMapper(); 
//       JsonNode json = mapper.readTree(year_obj.dayOfYearToString()); // this requires exception handling

//       return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
//     }
//     // add other methods

// }

package com.nighthawk.spring_portfolio.mvc.calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Calendar API
 * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns:
 * {"year":2020,"isLeapYear":false}
 */
@RestController
@RequestMapping("/api/calendar")
public class CalendarApiController {

  /**
   * GET isLeapYear endpoint
   * ObjectMapper throws exceptions on bad JSON
   *
   * @throws JsonProcessingException
   * @throws JsonMappingException
   */
  @GetMapping("/isLeapYear/{year}")
  public ResponseEntity<JsonNode> getIsLeapYear(@PathVariable int year)
      throws JsonMappingException, JsonProcessingException {
    // Backend Year Object
    Year year_obj = new Year();
    year_obj.setYear(year); // evaluates Leap Year

    // Turn Year Object into JSON
    ObjectMapper mapper = new ObjectMapper();
    JsonNode json = mapper.readTree(year_obj.isLeapYearToString()); // this requires exception handling

    return ResponseEntity.ok(json); // JSON response, see ExceptionHandlerAdvice for throws
  }

  @GetMapping("/numberOfLeapYears/{year1}/{year2}")
  public ResponseEntity<JsonNode> numberOfLeapYears(@PathVariable int year1, @PathVariable int year2)
      throws JsonMappingException, JsonProcessingException {

    // Turn Year Object into JSON
    ObjectMapper mapper = new ObjectMapper();
    JsonNode json = mapper.readTree("{ \"count\": " + APCalendar.numberOfLeapYears(year1, year2) + " } "); // handling

    return ResponseEntity.ok(json); // JSON response, see ExceptionHandlerAdvice for throws
  }

  @GetMapping("/date/{year}/{month}/{day}")
  public ResponseEntity<JsonNode> dayInfo(@PathVariable int year, @PathVariable int month, @PathVariable int day)
      throws JsonMappingException, JsonProcessingException {

    // Turn Year Object into JSON
    Day dayobj = new Day(month, year, day);
    // dayobj.setStuff(month, year, day);

    ObjectMapper mapper = new ObjectMapper();
    JsonNode json = mapper.readTree(dayobj.jSONFormat()); // handling

    return ResponseEntity.ok(json); // JSON response, see ExceptionHandlerAdvice for throws
  }



}