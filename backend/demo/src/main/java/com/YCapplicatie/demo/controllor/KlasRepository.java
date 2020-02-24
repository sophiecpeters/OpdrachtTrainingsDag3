package com.YCapplicatie.demo.controllor;

import com.YCapplicatie.demo.domein.Klas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface KlasRepository extends CrudRepository<Klas,Long> {
}
