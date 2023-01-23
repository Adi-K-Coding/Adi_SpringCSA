package com.nighthawk.spring_portfolio.mvc.person1;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

import com.vladmihalcea.hibernate.type.json.JsonType;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/*
Person is a POJO, Plain Old Java Object.
First set of annotations add functionality to POJO
--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
The last annotation connect to database
--- @Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
public class Person1 {

    // automatic unique identifier for Person record
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    @Email
    private String email;

    @NotEmpty
    private String password;

    // @NonNull, etc placed in params of constructor: "@NonNull @Size(min = 2, max =
    // 30, message = "Name (2 to 30 chars)") String name"
    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private int steps;

    private int weight;

    private int goal_steps;

    /*
     * HashMap is used to store JSON for daily "stats"
     * "stats": {
     * "2022-11-13": {
     * "calories": 2200,
     * "steps": 8000
     * }
     * }
     */
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Map<String, Map<String, Object>> stats = new HashMap<>();

    // Constructor used when building object from an API
    public Person1(String email, String password, String name, Date dob, int steps, int goal_steps, int weight) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.steps = steps;
        this.goal_steps = goal_steps;
        this.weight = weight;
    }

    // A custom getter to return age from dob attribute
    public int getAge() {
        if (this.dob != null) {
            LocalDate birthDay = this.dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthDay, LocalDate.now()).getYears();
        }
        return -1;
    }

    public String getAgeToString() {
        return ("{ \"name\": " + this.name + " ," + "\"age\": " + this.getAge() + " }");
    }

    public String getPercentToString() {
        float percent = this.steps / (float) this.goal_steps;
        percent = percent*100;
        return percent + "%";
    }

    public String toString() {
        return ("{ \"Name\": " + this.name + ", " + "\"DOB\": " + this.dob + ", " + "\"Weight\": " + this.weight + ", "
                + "\"Steps\": " + this.steps + " }");
    }

    public static void main(String[] args) {
        // tester method
        Person1 person1 = new Person1();
        Person1 person2 = new Person1("AdiKhandelwal@gmail.com", "password", "Adi Khandelwal", new Date(2006 - 06 - 02),
                0, 10000, 160);

        System.out.println(person1);
        System.out.println(person2);
    }

}