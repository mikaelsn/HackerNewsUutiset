
package com.mycompany.hackernewsuutiset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


public class HTTPClient {
    public static String callURL(String URLString) {
                System.out.println("");
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
                System.out.println("");
		InputStreamReader in = null;
		try {
			URL url = new URL(URLString);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
                in = checkConn(urlConn, in, sb);
		in.close();
                System.out.println("");
		} catch (Exception e) {
			throw new RuntimeException("Virhe hakiessa osoitteesta: "+ URLString, e);
		} 
		return sb.toString();
	}

    private static InputStreamReader checkConn(URLConnection urlConn, InputStreamReader in, StringBuilder sb) throws IOException {
        if (urlConn != null && urlConn.getInputStream() != null) {
            in = new InputStreamReader(urlConn.getInputStream(),
                    Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
        return in;
    }
}
