package br.com.quantati.cnco.service;

import br.com.quantati.cnco.domain.Base;
import br.com.quantati.cnco.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by carlos on 01/06/2017.
 */
@Service
public class BaseService {

    @Autowired
    private BaseRepository repository;

    @Transactional
    @CacheEvict(value = "listaBase", allEntries = true)
    public Base save(Base Base) {
        return repository.save(Base);
    }

    @Transactional
    @CacheEvict(value = "listaBase", allEntries = true)
    public void delete(Base base) {
        repository.delete(base);
    }

    @Cacheable(value = "listaBase")
    public List<Base> findAll() {
        return repository.findAll();
    }

}
