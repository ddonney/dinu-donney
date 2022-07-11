package com.automation.api.helpers;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author dinudonney
 * @Date 07/07/22
 */
public class ApiHelper {
    static URL url;
    static OutputStreamWriter outputStreamWriter;
    static ObjectMapper objectMapper;
    public HttpURLConnection httpURLConnection;
    public String responseString= null;

    public String  submitGetRequest(String endpoint,String param) throws IOException{
        try{
            if(!param.equals(""))
                url=new URL(endpoint+"/"+param);
            else
                url=new URL(endpoint);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            objectMapper =new ObjectMapper();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept","application/json");
            httpURLConnection.connect();
            System.out.println(httpURLConnection.getResponseCode());

            if(httpURLConnection.getResponseCode()>=200 && httpURLConnection.getResponseCode()<400)
                responseString=readStream(httpURLConnection.getInputStream());
            else
                responseString= readStream(httpURLConnection.getErrorStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("got response as "+ responseString);
        return responseString;
    }

    public String  submitPostRequest(String endpoint,Object requestDto) throws IOException {
        try{
            System.out.println("modify endpoint : "+endpoint);
            System.out.println("modify endpoint : "+requestDto);
            url=new URL(endpoint);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            objectMapper =new ObjectMapper();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            String charset = "UTF-8";
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=" + charset);
            httpURLConnection.setRequestProperty("Accept","application/json");
            outputStreamWriter=new OutputStreamWriter(httpURLConnection.getOutputStream());
            outputStreamWriter.write(objectMapper.writeValueAsString(requestDto));
            outputStreamWriter.flush();
            if(httpURLConnection.getResponseCode()>=200 && httpURLConnection.getResponseCode()<400)
                responseString=readStream(httpURLConnection.getInputStream());
            else
                responseString= readStream(httpURLConnection.getErrorStream());
            System.out.println(httpURLConnection.getResponseCode());
            System.out.println("got response as "+ responseString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseString;
    }

    public String  submitPutRequest(String endpoint,Object requestDto,String id) throws IOException {
        try{
            if(id!=null)
                url=new URL(endpoint+"/"+id);
            else
                url=new URL(endpoint);
            System.out.println(url);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            objectMapper =new ObjectMapper();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept","application/json");
            outputStreamWriter=new OutputStreamWriter(httpURLConnection.getOutputStream());
            outputStreamWriter.write(objectMapper.writeValueAsString(requestDto));
            outputStreamWriter.flush();
            if(httpURLConnection.getResponseCode()>=200 && httpURLConnection.getResponseCode()<400)
                responseString=readStream(httpURLConnection.getInputStream());
            else
                responseString= readStream(httpURLConnection.getErrorStream());
            System.out.println("got response as "+ responseString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseString;
        }


        public String  submitDeleteRequest(String endpoint,String id){
        try{
            url=new URL(endpoint+id);
            System.out.println("got delete url :"+ url);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            objectMapper =new ObjectMapper();
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setRequestProperty("Accept","*/*");
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=200 && httpURLConnection.getResponseCode()<400)
                responseString=readStream(httpURLConnection.getInputStream());
            else
                responseString= readStream(httpURLConnection.getErrorStream());
            System.out.println(httpURLConnection.getResponseCode());
            System.out.println("got response as "+ responseString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseString;
   }

    static String readStream(InputStream stream){
        StringBuilder response=new StringBuilder();
        BufferedReader in =null;
        try{
            in =new BufferedReader((new InputStreamReader(stream)));
            String line;
            while((line=in.readLine()) != null){
               response.append(line);
            }
            in.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
        return response.toString();
    }
}
