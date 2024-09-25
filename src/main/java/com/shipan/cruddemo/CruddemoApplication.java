package com.shipan.cruddemo;

import com.shipan.cruddemo.dao.AccountDAO;
import com.shipan.cruddemo.dao.CourseDAO;
import com.shipan.cruddemo.dao.InstructorDAO;
import com.shipan.cruddemo.entity.Course;
import com.shipan.cruddemo.entity.Instructor;
import com.shipan.cruddemo.entity.InstructorDetails;
import com.shipan.cruddemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shipan.cruddemo.dao.StudentDAO;
import com.shipan.cruddemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            System.out.println("Hello World");
//            demoTheBeforeAdvice(accountDAO);
            demoAroundAdvice(trafficFortuneService);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO)
    {
        accountDAO.addAccount();

        System.out.println("=========Again Add Account");

        accountDAO.addAccount();
    }
 private void demoAroundAdvice(TrafficFortuneService fortuneService)
    {
        System.out.println("\nMain Program: demoAroundAdvice");
        System.out.println("\nCalling getFortune()");
        String data=fortuneService.getFortune();
        System.out.println(data);

    }

}
