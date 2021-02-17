package restinterface;


import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestInterface { 
	
	public String putRemoteObject(String url,String type,String event)  { 
		try {
			//REST service query
			HttpPut request = new HttpPut(url);
			request.setHeader(HttpHeaders.CONTENT_TYPE, type);
			request.setEntity(new StringEntity(event, "UTF-8"));
			HttpResponse response = HttpClientBuilder.create().build().execute(request);
			System.out.println(response.getStatusLine().getStatusCode());	
			System.out.println(response);	

		    } catch (Exception e) {e.printStackTrace();}
		return "";
	}
	
	public String deleteAllRemoteObject(String url)  { 
		try {
			//REST service query
			HttpDelete request = new HttpDelete(url);
			HttpResponse response = HttpClientBuilder.create().build().execute(request);
			System.out.println(response.getStatusLine().getStatusCode());			
		    } catch (Exception e) {e.printStackTrace();}
		return "";}

}


