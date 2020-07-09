package springmongo.mongocrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class MongocrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongocrudApplication.class, args);
    }

}
