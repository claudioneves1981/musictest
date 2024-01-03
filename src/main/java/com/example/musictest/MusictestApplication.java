package com.example.musictest;

import com.example.musictest.models.Consulta;
import com.example.musictest.service.Service;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static com.example.musictest.util.JsonReader.readJsonFromUrl;

public class MusictestApplication {

	public static void main(String[] args) throws JSONException, IOException {

		   Scanner entrada = new Scanner(System.in);

		//https://api.vagalume.com.br/search.php?apikey=660a4395f992ff67786584e238f501aa&art=U2&mus=One&extra=relmus&nolyrics=1

		    System.out.println("Programa que obtem os dados musicais de uma musica e seu artista");
			System.out.println("Digite o nome do artista:");
			String art = entrada.nextLine();
			System.out.println("Digite o nome da musica:");
			String mus = entrada.nextLine();
			Consulta consulta = new Consulta();
			Service service = new Service();

			consulta = service.retornaConsulta(art,mus);
			System.out.println("Informaçoes da Musica");
			String artista = consulta.getArt().getName();
			String letra = consulta.getMus().getMusprop().get(0).getText();
			String album = consulta.getMus().getMusprop().get(0).getAlb().getName();
			String ano = consulta.getMus().getMusprop().get(0).getAlb().getYear();
			System.out.println("Artista:" +artista);
			System.out.println("Letra:" +letra);
			System.out.println("Album:"+album);
			System.out.println("Ano:"+ano);

		}

}
