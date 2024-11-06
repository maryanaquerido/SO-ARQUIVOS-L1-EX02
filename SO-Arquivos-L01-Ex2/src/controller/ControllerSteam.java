package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ControllerSteam implements IControllerSteam{

	public void consultaUsuario(String year, String month, String avg, String path, String name) throws IOException {
		File arq = new File (path, name);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader (leitor);
			String linha = buffer.readLine();
			System.out.printf("%-40s\t%-25s%n", "NOME DO JOGO", "MÉDIA DE JOGADORES ATIVOS");
			System.out.print("\n");
			while (linha != null) {
				String[] separacao = linha.split(",");
			
				if (separacao[1].equals(year) && separacao[2].equals(month) && Double.parseDouble(separacao[3]) >= Double.parseDouble(avg)) {
					System.out.printf("%-40s\t%-25s%n", separacao[0], separacao[3]);
					
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close(); 	
			
			} else {
				throw new IOException ("Arquivo Inválido!");
				}
		}
	
	public void createFile(String arqName, String path, String arquivoCriado, String year, String month) throws IOException {
		File dir = new File (path);
		File arq = new File (path, arqName);
		File arqCriado = new File (path, arquivoCriado);
		
		
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			FileWriter fileWriter = new FileWriter(arqCriado, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			
			String linha = buffer.readLine();
			while (linha != null) {
				String[] separacao = linha.split(",");
				
				 if (separacao[1].equals(year) && separacao[2].equals(month)) {
					 String conteudo = gerarConteudo(separacao[0], separacao[3]);
					 
					 print.write(conteudo);
				 }
				 
				 linha = buffer.readLine();
			}
			print.flush();
			print.close(); 
			fileWriter.close(); 
			System.out.println("Arquivo Criado!");
		} else {
			throw new IOException ("Diretório Inválido!");
		}
	}
	
	private String gerarConteudo(String gameName, String avgPlayers) {
        return gameName + " ; " + avgPlayers + "\n";
	}
	
	
}
