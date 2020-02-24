package com.YCapplicatie.demo.controllor;

import com.YCapplicatie.demo.domein.Klas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KlasService {

    @Autowired
    public KlasRepository kr;


    public void proberen(Klas klas){
        kr.save(klas);

    }

}
