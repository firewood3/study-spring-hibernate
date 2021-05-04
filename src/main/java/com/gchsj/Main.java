package com.gchsj;

import com.gchsj.config.SpringConfiguration;
import com.gchsj.dao.PersonDao;
import com.gchsj.entity.Person;
import com.gchsj.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        HelloService helloService = ctx.getBean(HelloService.class);
        helloService.printMessage("hello world");
        PersonDao personDao = ctx.getBean(PersonDao.class);
        personDao.printMessage();
        personDao.persist(Person.builder().name("John").build());
        personDao.persist(Person.builder().name("hong").build());
    }
}
