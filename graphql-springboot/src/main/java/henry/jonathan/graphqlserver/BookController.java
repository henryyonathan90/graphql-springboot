package henry.jonathan.graphqlserver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class BookController {
    @QueryMapping
    public Mono<Book> bookById(@Argument String id) {
        return Mono.just(Book.getById(id));
    }

    @SchemaMapping
    public Mono<Author> author(Book book) {
        return Mono.just(Author.getById(book.authorId()));
    }
}
