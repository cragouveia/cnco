package br.com.quantati.cnco.repository;

import br.com.quantati.cnco.domain.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by carlos on 31/05/2017.
 */
@Repository
public interface BaseRepository extends JpaRepository<Base, String> {


}
