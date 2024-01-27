package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = createEricAuthor();
        Book ddd = createDDDBook();
        eric.getBooks().add(ddd);


        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = createRodAuthor();
        Book noEJB = createNoEJBBook();
        rod.getBooks().add(noEJB);

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        /* for(Author author: authorRepository.findAll()){
            System.out.println(author);
        }*/

        Publisher addisonWesley = createPublisher(
                "Addison-Wesley Professional",
                "1900 E Lake Ave Glenview, IL 60025 United States",
                "Glenview",
                "Illinois",
                "IL 60025"
                );

        Publisher addisonWesleySaved = publisherRepository.save(addisonWesley);


        Publisher wiley = createPublisher(
                "Wiley",
                "New Jersey John Wiley & Sons, Inc. Corporate Headquarters 111 River Street Hoboken, NJ 07030-5774 · California zyBooks & Atypon 54 N Central Ave",
                "111 River Street Hoboken",
                "California",
                "NJ 07030-5774"
        );
        Publisher wileySaved = publisherRepository.save(wiley);


        System.out.println(rodSaved);
        System.out.println(dddSaved);

        System.out.println(addisonWesleySaved);
        System.out.println(wileySaved);


        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }

    private Publisher createPublisher(
                String publisherName,
                String address,
                String city,
                String state,
                String zip) {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherName);
        publisher.setAddress(address);
        publisher.setCity(city);
        publisher.setState(state);
        publisher.setZip(zip);

        return publisher;

    }

    private static Book createNoEJBBook() {
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("5457585");
        return noEJB;
    }

    private static Author createRodAuthor() {
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        return rod;
    }

    private static Book createDDDBook() {
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        return ddd;
    }

    private static Author createEricAuthor() {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        return eric;
    }

}
