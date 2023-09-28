package ventas.cheffify.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ventas.cheffify.jpa.entity.Author;
import ventas.cheffify.jpa.service.DaoFactory;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	@Autowired
	private DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Lista Autores inicial");
			daoFactory.getAuthors().forEach((author) -> {
				System.out.println(author.getName());
			});
			System.out.println("Lista Autores con nuevo autor");
			Author author = new Author(null, "Estebandido");
			author.setId((long) 4);
			daoFactory.create(author);
			daoFactory.getAuthors().forEach((author2) -> {
				System.out.println(author2.getName());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
