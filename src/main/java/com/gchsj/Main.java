package com.gchsj;

import com.gchsj.config.SpringConfiguration;
import com.gchsj.dao.PersonDao;
import com.gchsj.dao.StudentDao;
import com.gchsj.entity.Person;
import com.gchsj.entity.Student;
import com.gchsj.service.HelloService;
import com.gchsj.types.Gender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        HelloService helloService = ctx.getBean(HelloService.class);
        helloService.printMessage("hello world");
        PersonDao personDao = ctx.getBean(PersonDao.class);
        personDao.printMessage();
        personDao.persist(Person.builder().name("John").build());
        personDao.persist(Person.builder().name("hong").build());


        StudentDao studentDao = ctx.getBean(StudentDao.class);
        Student student = Student.builder().name("seok").birthDay(LocalDateTime.now()).build();
        studentDao.workplace(student);
        student.setName("changed2");
        studentDao.flush();
        studentDao.workplace(Student.builder().name("jin").gender(Gender.MALE).build());
        studentDao.delete(student);
        student.setName("changed1");

    }
}
