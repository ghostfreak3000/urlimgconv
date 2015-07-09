package com.terasoft.terautils.urlImgConvertor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class UrlImgConv {

	private URL url;
	private String mimeType = "";
	
	public UrlImgConv(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public String toB64() {		
		
		File file = null;
		String tDir = System.getProperty("java.io.tmpdir"); 
		String path = tDir + genUuid() + getExt(); 
		file = new File(path); 
		file.deleteOnExit(); 
		
		try {
			FileUtils.copyURLToFile(url, file);
			String b64 = Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
			mimeType = getMimeType(file);			
			return b64;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String genUuid()
	{
		return UUID.randomUUID().toString();		
	}
	
	public String getExt()
	{		
		String[] tokens = url.getFile().split("\\.");
		return "."+tokens[tokens.length-1];	
	}
	
	public String getMimeType(File file)
	{
		try {
			String mimeType = Files.probeContentType(file.toPath());
			return mimeType;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String toB64DataUri() {
		String b64 = toB64();
		return "data:"+mimeType+";base64,"+b64;
	}
	
}
