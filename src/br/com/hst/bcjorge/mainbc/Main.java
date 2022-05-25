package br.com.hst.bcjorge.mainbc;

import java.util.LinkedList;
import java.util.List;
import com.google.gson.GsonBuilder;

import br.com.hst.bcjorge.blockchainarquivos.CriaArquivoBlocosJSON;
import br.com.hst.bcjorge.chblock.ChBlock;


public class Main {	
	public static void main(String[] args) {
		
		List<ChBlock> blockchain = new LinkedList<ChBlock>();
		blockchain.add(new ChBlock("Bloco 1", "0"));
		blockchain.add(new ChBlock("usuario:Jorge Mira | coins:5000", blockchain.get(blockchain.size() -1).hash));
		blockchain.add(new ChBlock("usuario:Beatriz | coins:5000", blockchain.get(blockchain.size() -1).hash));
		
		
		String blockchainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		CriaArquivoBlocosJSON.criaArquivoBlocosJSON(blockchain);
		System.out.println(blockchainJSON);
	}
}
