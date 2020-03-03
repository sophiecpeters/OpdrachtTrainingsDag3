package com.YCapplicatie.demo.controllor;

import com.YCapplicatie.demo.domein.Klas;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class KlasService {

    @Autowired
    public KlasRepository kr;


    public void addRow(Klas klas){
        kr.save(klas);

    }

    public void deleteRow(Klas klas){
        kr.delete(klas);
    }

    public List<Klas> getData(){
            return Lists.newArrayList(kr.findAll());
        }
}
