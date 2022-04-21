package br.com.hst.bcjorge.mainbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.hst.bcjorge.chblock.ChBlock;


public class Main {	
	public static void main(String[] args) {

		List<ChBlock> blockchain = new LinkedList<ChBlock>();
		blockchain.add(new ChBlock("Bloco 1", "0"));
		blockchain.add(new ChBlock("Bloco 2", blockchain.get(blockchain.size() -1).hash));
		blockchain.add(new ChBlock("Bloco 3", blockchain.get(blockchain.size() -1).hash));
		blockchain.add(new ChBlock("Bloco 5", blockchain.get(blockchain.size() -1).hash));
		blockchain.add(new ChBlock("Bloco 6", blockchain.get(blockchain.size() -1).hash));
		blockchain.add(new ChBlock("Bloco 7", blockchain.get(blockchain.size() -1).hash));
		
		String blockchainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJSON);
		
		criaArquivoBlocosJSON(blockchain);
	}
	
	public static void criaArquivoBlocosJSON(List<ChBlock> blockchain)
	{
		String path = "C:\\Users\\jorge_mira\\eclipse-blockchain\\Blockchain\\src\\br\\com\\hst\\bcjorge\\blockchainarquivos\\blockchain.txt";		
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
