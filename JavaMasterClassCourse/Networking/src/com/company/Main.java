package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

//URI - universal resource identifier
    // an identifier that might not provide enough information to access the resource it identifies
    // specific a relative path
//url - universal resource locator
    // identifier that includes information about how to access the resource it identifies.
    // has to be an absolute path

// easy to convert between

// recommended practice in java.net; use a URI until you actually want to access a resource, and then to convert the URI to a URL
    // However, sometimes there is no need to access a URI, because the need the URL after the bat

// Scheme is part of URI or URL before colon like http
    // another way to describe a URL is a http URI for example

/**
 * URI contains 9 components:
 * 1. scheme
 * 2. scheme-specific part
 * 3. authority
 * 4. user-info
 * 5. host
 * 6. port
 * 7. path
 * 8. query
 * 9. fragment
 *
 * EG:
 * scheme: [//[user[:password]@]host[:port]][/path][?query][#fragment]
 */

//URI doesn't need to be valid to work with it. Only valid when you want to convert it to an absolute path (URL)

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
//        try {
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());
//
//        }catch (URISyntaxException var5) {
//            System.out.println("URI Bad Syntax: " + var5.getMessage());
//        }


        try {
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = baseUri.resolve(uri);
            URL url = resolvedUri.toURL();
            System.out.println("URL = " + url);
        } catch (URISyntaxException var5) {
            System.out.println("URI Bad Syntax: " + var5.getMessage());
        } catch (MalformedURLException var6) {
            System.out.println("URL Malformed: " + var6.getMessage());
        }


        try {
            URL url = new URL("http://example.org");

//            URI uri = url.toURI();
//            System.out.println ("Scheme = " + uri.getScheme ());
//            System.out.println ("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println ("Authority = " + uri.getAuthority());
//            System.out.println ("User Info = " + uri.getUserInfo());
//            System.out.println ("Host = " + uri.getHost());
//            System.out.println ("Port = " + uri.getPort());
//            System.out.println ("Path = " + uri.getPath());
//            System.out.println ("Query = " + uri.getQuery());
//            System.out.println ("Fragment = " + uri.getFragment());


            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line = "";
            while(line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } //catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
    }
}
