package client;

import restinterface.RestInterface;

public class ClearFile {
	private static final String URL_FILM_WRITER = "http://localhost:8080/CQRSFilmsWriter_cor/events/";

	public static void main(String[] args) throws Exception {
		
		new RestInterface().deleteAllRemoteObject(URL_FILM_WRITER);
	}
}
