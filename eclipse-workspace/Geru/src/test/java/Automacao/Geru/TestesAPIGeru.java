package Automacao.Geru;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

public class TestesAPIGeru {

	public TestesAPIGeru(){
		baseURI = "www.urlficticia.com.br/api/v1/token";
	}

	@Test
	public void gerarTokenUsuario() {
		String myJson = "{\"username\":\"jcoimbra\",\"password\": \"Teste123\"}";

		given()
		.contentType("application/json")
		.body(myJson)
		.when()
		.post("/")
		.then()
		.statusCode(200)
		.body("message", containsString("Usuario Cadastrado!"));	 
	}
	
	@Test
	public void consultaEmprestimo() {
		
		 given()
		 .when()
		    .get("/1")
		 .then()
		    .statusCode(200)
		    .body("id", is(1))
		    .body("token", equalTo("b2c6f757eb9d49f4b2dace3aab9b1566"))
		    .body("username", equalTo("jcoimbra"))
		    .assertThat()
		       .body(matchesJsonSchemaInClasspath("schema.json"));
	}
}

