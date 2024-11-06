package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ControllerSteam;
import controller.IControllerSteam;

public class PrincipalSteam {
	public static void main (String[] args) {
		
		IControllerSteam steamCont = new ControllerSteam();
		
		String year = JOptionPane.showInputDialog("Digite o ano para consulta:");
		String month = JOptionPane.showInputDialog("Digite o mês para consulta: "); 
		String avg = JOptionPane.showInputDialog("Digite a média esperada: ");
		
		String path = "C:\\TEMP";
		String arqName = "SteamCharts.csv";
		
		String arquivoCriado = "nome.csv";
		
		try {
			steamCont.consultaUsuario(year, month, avg, path, arqName);
			steamCont.createFile(arqName, path, arquivoCriado, year, month);
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
	}

}
