package aa.fr.catservice;

import aa.fr.catservice.dao.ProduitRepository;
import aa.fr.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication  implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;


	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"iphone3", 400, 33));
		//produitRepository.save(new Produit(null, "iphone3", 400, 2));

	produitRepository.findAll().forEach( p-> {
		System.out.println(p.toString());
	});

	}
}
