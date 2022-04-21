package br.com.hst.bcjorge.mainbc;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.hst.bcjorge.chblock.ChBlock;


public class Main {
	
	public static List<ChBlock> blockchain = new LinkedList<ChBlock>();
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		//ChBlock blocoGenesis = new ChBlock("jorge", "0");
		//System.out.println("Hash Bloco 0 = " + blocoGenesis.hash);
		blockchain.add(new ChBlock("Bloco 1", "0"));
		
		//ChBlock bloco1 = new ChBlock("jorge", blocoGenesis.hash);
		//System.out.println("Hash Bloco 1 = " + bloco1.hash);
		blockchain.add(new ChBlock("Bloco 2", blockchain.get(blockchain.size() -1).hash));
		
		//ChBlock bloco2 = new ChBlock("jorge", bloco1.hash);
		//System.out.println("Hash Bloco 2 = " + bloco2.hash);
		blockchain.add(new ChBlock("Bloco 3", blockchain.get(blockchain.size() -1).hash));
		
		//ChBlock bloco3 = new ChBlock("jorge", bloco2.hash);
		//System.out.println("Hash Bloco 3 = " + bloco3.hash);
		blockchain.add(new ChBlock("Bloco 4", blockchain.get(blockchain.size() -1).hash));
		
		String blockchainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJSON);
		
	}
}
