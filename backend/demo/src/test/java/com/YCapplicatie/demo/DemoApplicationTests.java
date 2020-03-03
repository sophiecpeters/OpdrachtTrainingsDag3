package com.YCapplicatie.demo;

import com.YCapplicatie.demo.controllor.KlasRepository;
import com.YCapplicatie.demo.domein.Klas;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public KlasRepository kr;
	@Test
	void contextLoads() {
	}


	@Test
	void verifyRowIsAdded(){
		Klas klas = addRowToDatabase("240","45","560","Piet");

		Optional<Klas> data = kr.findById(klas.getId());
		assertThat(data.isPresent());
		if(data.isPresent()){
			Klas row = data.get();
			assertThat(klas.getAantalLeerlingen()).isEqualTo(row.getAantalLeerlingen());
			assertThat(klas.getDocentNaam()).isEqualTo(row.getDocentNaam());
		}
	}

	@Test
	void verifyRowIsDeleted(){

		Klas klas = addRowToDatabase("100","34","760","Jan");

		Optional<Klas> data = kr.findById(klas.getId());
		assertThat(data.isPresent());
		if (data.isPresent()){
			Klas row = data.get();
			System.out.println(row.getAantalLeerlingen());
			System.out.println(row.getDocentNaam());
			kr.delete(row);
			Optional<Klas> deletedData = kr.findById(klas.getId());
			assertThat(deletedData.isEmpty());
		}
	}

	@Test
	void getDataCheck(){

		addRowToDatabase("745","12","130","Piet");
		addRowToDatabase("244","23","980","Siem");
		addRowToDatabase("843","34","545","Tom");
		addRowToDatabase("241","45","675","Jip");
			List <Klas> allRows = Lists.newArrayList(kr.findAll());
		for (Klas row: allRows) {
			System.out.println(row);

		}
	}

	Klas addRowToDatabase(String lokaalNummer, String aantalLeerlingen, String afmetingen, String docentNaam){
		Klas klas = new Klas();
		klas.setLokaalNr(lokaalNummer);
		klas.setAantalLeerlingen(aantalLeerlingen);
		klas.setAfmetingen(afmetingen);
		klas.setDocentNaam(docentNaam);
		kr.save(klas);
		return klas;

	}


}
