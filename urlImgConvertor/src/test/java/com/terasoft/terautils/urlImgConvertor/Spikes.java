package com.terasoft.terautils.urlImgConvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class Spikes {

	@Test
	public void testGetExt() throws Exception {
		String url = "http://www.hdwallpapersimages.com/wp-content/uploads/2014/01/Winter-Tiger-Wild-Cat-Images.jpg";		
		UrlImgConv img = new UrlImgConv(url);
		System.out.println(img.getExt());
	}
	
}
