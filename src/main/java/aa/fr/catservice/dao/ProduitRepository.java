package aa.fr.catservice.dao;

import aa.fr.catservice.entities.Produit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @RestResource ( path = "/byDesignation")
    public List<Produit> findBydesignationContains ( @Param("mc") String des);

    @RestResource ( path = "/byDesignationPage")
    public List<Produit> findBydesignationContains (@Param("mc") String des, Pageable pageable);
}
