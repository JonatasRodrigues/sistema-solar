package br.com.meli.sistema.solar.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.meli.sistema.solar.app.Application;
import br.com.meli.sistema.solar.model.Meteorologia;
import br.com.meli.sistema.solar.service.MeteorologiaService;

@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RunWith(SpringRunner.class)
public class MeteorologiaControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	MeteorologiaService service;

	private MockMvc mockMvc;
	
	@Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        
        Meteorologia meteorologia = new Meteorologia();
        meteorologia.setId(1);
        meteorologia.setDia(1);
        meteorologia.setClima("chuva");
        service.salvar(meteorologia);
        
        Meteorologia meteorologia2 = new Meteorologia();
        meteorologia2.setId(2);
        meteorologia2.setDia(2);
        meteorologia2.setClima("seca");
        service.salvar(meteorologia2);
    }
	
	 @Test
	 public void testFindClimaPorDiaSucesso() throws Exception {
		mockMvc.perform(get("/api/v1/clima?dia=1")) 
			.andExpect(status().isOk())
            .andExpect(content().json("{\"dia\":1,\"clima\":\"chuva\"}"));
     }
	 
	 @Test
	 public void testFindClimaPorDiaErro400() throws Exception {
		mockMvc.perform(get("/api/v1/clima")) 
			.andExpect(status().isBadRequest());
     }
	 
	 @Test
	 public void testFindClimaPorDiaErro500() throws Exception {
		mockMvc.perform(get("/api/v1/clima?dia=a")) 
			.andExpect(status().isBadRequest());
     }

}
