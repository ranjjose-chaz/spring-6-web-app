package guru.springframework.spring6webapp;

import guru.springframework.spring6webapp.controllers.AuthorController;
import guru.springframework.spring6webapp.controllers.BookController;
import guru.springframework.spring6webapp.services.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SpringContextWebApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    AuthorController authorController;

    @Test
    void testControllerAutowiring(){
        System.out.println("************************    ");
        authorController.hello();
    }

    @Test
    void testGetControllerFromContext(){
        BookController bookController = applicationContext.getBean(BookController.class);
        bookController.hello();

    }




    @Test
    void contextLoads(){

    }
}
