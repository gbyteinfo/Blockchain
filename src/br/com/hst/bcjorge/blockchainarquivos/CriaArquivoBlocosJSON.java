package br.com.hst.bcjorge.blockchainarquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.GsonBuilder;

import br.com.hst.bcjorge.chblock.ChBlock;

public class CriaArquivoBlocosJSON {
	
	
	public static void criaArquivoBlocosJSON(List<ChBlock> blockchain)
	{
		String path;
		path = new File("").getAbsolutePath().trim();
		path = path.concat("\\src\\br\\com\\hst\\bcjorge\\blockchainarquivos\\blockchain.txt");
		
		String json = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		
		try 
		{
			FileWriter writer = new FileWriter(path);
			writer.write(json);
			writer.close();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}