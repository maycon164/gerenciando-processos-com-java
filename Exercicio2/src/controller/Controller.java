package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {

	public Controller() {
		super();
	}

	public String indentificaSO() {
		return System.getProperty("os.name");
	}

	public void listarProcessos(String os) {
		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("lsof");
			} else {
				process = Runtime.getRuntime().exec("tasklist");
			}

			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			fluxo.close();
			buffer.close();
			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}