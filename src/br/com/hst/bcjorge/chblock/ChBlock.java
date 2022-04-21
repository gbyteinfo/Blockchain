package br.com.hst.bcjorge.chblock;

import java.util.Date;

import br.com.hst.bcjorge.sha256.StringUtil;

public class ChBlock {

	// 1° CLASSE RESPONSAVEL POR REPRESENTAR O BLOCO
	
	
	private Object data;      // DADOS DA TRANSAÇÃO
	private String timeStamp; // TIMESTAMP DA TRANSAÇÃO
	public String hash;       // ASSINATURA DO BLOCO 
	public String prevHash;   // ASSINATURA BLOCO ANTERIOR
	
	
	public ChBlock(Object data, String prevHash) 
	{
		this.timeStamp = new Date().toString();
		this.prevHash  = prevHash;
		this.data      = data;
		this.hash      = calculaHash();
	}
	
	public String calculaHash()
	{
		String calculaHash = StringUtil.aplicarSha256(prevHash + timeStamp + data);
		return calculaHash;
	}	
}
