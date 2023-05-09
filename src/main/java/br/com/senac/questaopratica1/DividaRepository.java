package br.com.senac.questaopratica1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {

    List<Divida> findAll();
}
