package br.com.hst.bcjorge.sha256;

import java.security.MessageDigest;


public class StringUtil {
	
	// 2° CLASSE RESPONSAVEL EM APLICAR A FUNÇÃO MATEMATICA SHA25 NO OBJETO RECEBIDO E DEVOLVER O RESULTADO
	
	public static String aplicarSha256(String data) 
	{
		
		try 
		{	
			MessageDigest functionInstance;
			functionInstance = MessageDigest.getInstance("SHA-256");

			//APLICA ALGORIFIMO E CAPTURA OS BYTES DOS DADOS
			byte[] hash = functionInstance.digest(data.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();	
			
			//CONVERTENDO BYTE A BYTE PARA HEX
			for (int i = 0; i < hash.length; i++) {
				
				String toHex = Integer.toHexString(0xff & hash[i]);
				if(toHex.length() == 1)
				{
					hexString.append('0');
				}
				//CONCATENA HEX A HEX
				hexString.append(toHex);
			
			}
			//RETORNA A HASH COMPLETA
			return hexString.toString();
			
		} 
		catch (Exception e) {throw new RuntimeException();}
	}
}
