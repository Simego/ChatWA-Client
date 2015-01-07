package com.thesimego.senacrs.sistemasdistribuidos.waclient.util;

import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.ResponseEN;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;

/**
 *
 * @author Simego
 */
public class RequestClient {

    private static final Logger LOG = Logger.getLogger("RequestClient");
    private static HttpClient httpClient = null;
    private static final HttpClientContext httpContext = new HttpClientContext();

    public static void createHttpClient() {
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        
        String ip = System.getProperty("com.thesimego.proxy.ip");
        String port = System.getProperty("com.thesimego.proxy.port");
        String login = System.getProperty("com.thesimego.proxy.login");
        String password = System.getProperty("com.thesimego.proxy.password");
        
        if(ip != null && port != null && !ip.trim().isEmpty() && !port.trim().isEmpty()) {
            
            if(login != null && password != null && !login.trim().isEmpty() && !password.trim().isEmpty()) {
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(
                        new AuthScope(ip, Integer.parseInt(port)),
                        new UsernamePasswordCredentials(login, password));
                clientBuilder.setDefaultCredentialsProvider(credsProvider);
            }
            
            clientBuilder.useSystemProperties();
            clientBuilder.setProxy(new HttpHost(ip, Integer.parseInt(port)));
            clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());
        }
        
        httpClient = clientBuilder.build();

        BasicCookieStore cookieStore = new BasicCookieStore();
        httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
    }

    public static ResponseEN post(String url) {
        if(httpClient == null) {
            createHttpClient();
        }
        try {
            HttpPost post = new HttpPost(url);
            HttpResponse response = httpClient.execute(post);
            StringBuilder stb = new StringBuilder();
            InputStream is = response.getEntity().getContent();
            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    stb.append(line);
                }
            }

            post.abort();
            ResponseEN res = new ResponseEN(url, response.getStatusLine().getStatusCode(), stb.toString());
            outputResponse("[POST] " + res.toString());
            return res;
        } catch (IOException ex) {
            Logger.getLogger(RequestClient.class.getName()).log(Level.SEVERE, "post " + url, ex);
            return null;
        }
    }

    public static ResponseEN get(String url) {
        if(httpClient == null) {
            createHttpClient();
        }
        try {
            HttpGet get = new HttpGet(url);
            HttpResponse response = httpClient.execute(get);
            StringBuilder stb = new StringBuilder();
            InputStream is = response.getEntity().getContent();
            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    stb.append(line);
                }
            }

            get.abort();
            ResponseEN res = new ResponseEN(url, response.getStatusLine().getStatusCode(), stb.toString());
            outputResponse("[GET] " + res.toString());
            return res;
        } catch (IOException ex) {
            LOG.log(Level.FINER, "get " + url, ex);
            return null;
        }
    }

    private static void outputResponse(String response) {
        if (Util.getIsDebugRequest()) {
            System.out.println(response);
        }
    }

}
