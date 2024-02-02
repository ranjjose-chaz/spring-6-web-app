package guru.springframework.spring6webapp;

import guru.springframework.spring6webapp.controllers.AuthorController;
import guru.springframework.spring6webapp.controllers.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringContextWebApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringContextWebApplication.class, args);
        AuthorController authorController = ctx.getBean(AuthorController.class);
        authorController.hello();
        BookController bookController = ctx.getBean(BookController.class);
        bookController.hello();



    }
}
