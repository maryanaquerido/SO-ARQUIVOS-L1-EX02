package controller;

import java.io.IOException;

public interface IControllerSteam {
	
	public void consultaUsuario(String year, String month, String avg, String path, String name) throws IOException;
	public void createFile(String arqName,String path, String arquivoCriado, String year, String month) throws IOException;
	
}
