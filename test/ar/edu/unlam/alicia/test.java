package ar.edu.unlam.alicia;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void queSePuedaCrearAAlicia() {
		Personaje alicia = new Personaje(180, 60, "alicia", 18, 5000);
		assertNotNull(alicia);
	}

	@Test
	public void queAliciaPuedaComprarAlimentosEnUnSupermercado() throws NoTeAlcanzaElDinero {
		Personaje alicia = new Personaje(180, 60, "alicia", 18, 500);
		Supermercado supermercado = new Supermercado("esquina");

		supermercado.agregarAlimento(new Masita("masita", 50));
		supermercado.agregarAlimento(new Alfajores("alfajor", 50));
		supermercado.agregarAlimento(new Bagels("bagel", 50));
		supermercado.agregarAlimento(new BocanidosDeChocolate("bocadito de chocolate", 50));
		supermercado.agregarAlimento(new Caramelos("caramelo", 50));
		supermercado.agregarAlimento(new Gomitas("gomita", 50));

		supermercado.venderAlimento("masita", alicia);
		supermercado.venderAlimento("alfajor", alicia);
		supermercado.venderAlimento("bagel", alicia);
		supermercado.venderAlimento("bocadito de chocolate", alicia);
		supermercado.venderAlimento("caramelo", alicia);
		supermercado.venderAlimento("gomita", alicia);

		assertEquals((Integer) 0, (Integer) supermercado.getAlimentosEnStock().size());
		assertEquals((Integer) 6, (Integer) alicia.getCompraAlimento().size());

	}

	@Test
	public void queAliciaPuedaConsumirAlimentosYEncojerse()
			throws NoTeAlcanzaElDinero, NoPuedeCrecerMas, NoSePuedeEncojer, AlimentoInexistente {
		Personaje alicia = new Personaje(180, 60, "alicia", 18, 500);
		Supermercado supermercado = new Supermercado("esquina");

		supermercado.agregarAlimento(new Masita("masita", 50));
		supermercado.agregarAlimento(new Alfajores("alfajor", 50));
		supermercado.agregarAlimento(new Bagels("bagel", 50));
		supermercado.agregarAlimento(new BocanidosDeChocolate("bocadito de chocolate", 50));
		supermercado.agregarAlimento(new Caramelos("caramelo", 50));
		supermercado.agregarAlimento(new Gomitas("gomita", 50));

		supermercado.venderAlimento("masita", alicia);
		supermercado.venderAlimento("alfajor", alicia);
		supermercado.venderAlimento("bagel", alicia);
		supermercado.venderAlimento("bocadito de chocolate", alicia);
		supermercado.venderAlimento("caramelo", alicia);
		supermercado.venderAlimento("gomita", alicia);

		alicia.consumirAlimento("masita"); // 50
		alicia.consumirAlimento("alfajor");
		assertEquals((Integer) 80, alicia.getAltura());
	}

	@Test
	public void queAliciaPuedaConsumirAlimentosYCrecer()
			throws NoTeAlcanzaElDinero, NoPuedeCrecerMas, NoSePuedeEncojer, AlimentoInexistente {
		Personaje alicia = new Personaje(180, 60, "alicia", 18, 500);
		Supermercado supermercado = new Supermercado("esquina");

		supermercado.agregarAlimento(new Masita("masita", 50));
		supermercado.agregarAlimento(new Alfajores("alfajor", 50));
		supermercado.agregarAlimento(new Bagels("bagel", 50));
		supermercado.agregarAlimento(new BocanidosDeChocolate("bocadito de chocolate", 50));
		supermercado.agregarAlimento(new Caramelos("caramelo", 50));
		supermercado.agregarAlimento(new Gomitas("gomita", 50));

		supermercado.venderAlimento("masita", alicia);
		supermercado.venderAlimento("alfajor", alicia);
		supermercado.venderAlimento("bagel", alicia);
		supermercado.venderAlimento("bocadito de chocolate", alicia);
		supermercado.venderAlimento("caramelo", alicia);
		supermercado.venderAlimento("gomita", alicia);

		alicia.consumirAlimento("caramelo"); // 50
		alicia.consumirAlimento("gomita");
		assertEquals((Integer) 260, alicia.getAltura());
	}

	@Test(expected = NoPuedeCrecerMas.class)
	public void queAliciaNoPuedaConsumirAlimentosYCrecer()
			throws NoTeAlcanzaElDinero, NoPuedeCrecerMas, NoSePuedeEncojer, AlimentoInexistente {
		Personaje alicia = new Personaje(180, 60, "alicia", 18, 500);
		Supermercado supermercado = new Supermercado("esquina");

		supermercado.agregarAlimento(new Masita("masita", 50));
		supermercado.agregarAlimento(new Alfajores("alfajor", 50));
		supermercado.agregarAlimento(new Bagels("bagel", 50));
		supermercado.agregarAlimento(new BocanidosDeChocolate("bocadito de chocolate", 50));
		supermercado.agregarAlimento(new Caramelos("caramelo", 50));
		supermercado.agregarAlimento(new Gomitas("gomita", 50));

		supermercado.venderAlimento("masita", alicia);
		supermercado.venderAlimento("alfajor", alicia);
		supermercado.venderAlimento("bagel", alicia);
		supermercado.venderAlimento("bocadito de chocolate", alicia);
		supermercado.venderAlimento("caramelo", alicia);
		supermercado.venderAlimento("gomita", alicia);

		alicia.consumirAlimento("caramelo"); // 50
		alicia.consumirAlimento("gomita");
		alicia.consumirAlimento("bocadito de chocolate");

	}

	@Test(expected = NoSePuedeEncojer.class)
	public void queAliciaNoPuedaConsumirAlimentosYEncojerse()
			throws NoTeAlcanzaElDinero, NoPuedeCrecerMas, NoSePuedeEncojer, AlimentoInexistente {
		Personaje alicia = new Personaje(180, 60, "alicia", 18, 500);
		Supermercado supermercado = new Supermercado("esquina");

		supermercado.agregarAlimento(new Masita("masita", 50));
		supermercado.agregarAlimento(new Alfajores("alfajor", 50));
		supermercado.agregarAlimento(new Bagels("bagel", 50));
		supermercado.agregarAlimento(new BocanidosDeChocolate("bocadito de chocolate", 50));
		supermercado.agregarAlimento(new Caramelos("caramelo", 50));
		supermercado.agregarAlimento(new Gomitas("gomita", 50));

		supermercado.venderAlimento("masita", alicia);
		supermercado.venderAlimento("alfajor", alicia);
		supermercado.venderAlimento("bagel", alicia);
		supermercado.venderAlimento("bocadito de chocolate", alicia);
		supermercado.venderAlimento("caramelo", alicia);
		supermercado.venderAlimento("gomita", alicia);

		alicia.consumirAlimento("masita"); // 50
		alicia.consumirAlimento("alfajor");
		alicia.consumirAlimento("bagel");

	}

}
