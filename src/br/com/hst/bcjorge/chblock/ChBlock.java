package br.com.hst.bcjorge.chblock;

import java.util.Date;

import br.com.hst.bcjorge.sha256.StringUtil;

public class ChBlock {

	// 1° CLASSE RESPONSAVEL POR REPRESENTAR O BLOCO
	
	public String hash;       // ASSINATURA DO BLOCO 
	public String prevHash;   // ASSINATURA BLOCO ANTERIOR
	private String data;      // DADOS DA TRANSAÇÃO
	private String timeStamp; // TIMESTAMP DA TRANSAÇÃO
	
	
	public ChBlock(String data, String prevHash) 
	{
		this.hash      = calculaHash();
		this.prevHash  = prevHash;
		this.data      = data;
		this.timeStamp = new Date().toString();
		//this.data    = new Date().getTime();
	}
	
	public String calculaHash()
	{
		String calculaHash = StringUtil.aplicarSha256(prevHash + timeStamp + data);
		return calculaHash;
	}	
}
