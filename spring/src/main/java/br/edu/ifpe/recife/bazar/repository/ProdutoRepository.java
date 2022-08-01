package br.edu.ifpe.recife.bazar.repository;

import br.edu.ifpe.recife.bazar.domains.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
