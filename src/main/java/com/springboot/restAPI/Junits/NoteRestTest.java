package com.springboot.restAPI.Junits;
import static org.junit.Assert.*;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class NoteRestTest {

	@Test
	public void testMediaType()  throws ClientProtocolException, IOException {
	  
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/note" );
	 
	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	   
	}
	
	@Test
	public void testStatusCode_404()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String id = RandomStringUtils.randomAlphabetic( 8 );
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/note" + id );
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	   int actual = httpResponse.getStatusLine().getStatusCode();
	   int expected = HttpStatus.SC_NOT_FOUND;
	 
	   assertEquals(expected, actual);
	}
	
	@Test
	public void testStatusCode_200()
	  throws ClientProtocolException, IOException {
	  
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/note/786");
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	   int actual = httpResponse.getStatusLine().getStatusCode();
	   int expected = HttpStatus.SC_OK;
	 
	   assertEquals(expected, actual);
	}
}
