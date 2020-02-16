package com.vadym.pet.project.clients;

import com.google.gson.Gson;
import com.vadym.pet.project.model.clinicCreate.ClinicCreateResponse;
import com.vadym.pet.project.model.regKey.RegKeyRequest;
import com.vadym.pet.project.model.regKey.RegKeyResponse;
import com.vadym.pet.project.utils.ClinicRequestUtil;
import com.vadym.pet.project.utils.DataParser;
import com.vadym.pet.project.utils.RequestUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ClinicClient {
    private CloseableHttpClient client = HttpClients.createDefault();
    private RequestUtil requestUtil = new RequestUtil();
    private Gson gson = new Gson();

    public String getRegKey() throws IOException, ParseException {

        RegKeyRequest regKeyRequest = buildRegKey();

        String json = gson.toJson(regKeyRequest);
        final HttpPost clinicPostRequest = requestUtil.generatePostRequest(json, "generateRegKey", false);
        CloseableHttpResponse response = client.execute(clinicPostRequest);

        HttpEntity httpEntity = response.getEntity();
        String content = DataParser.parseContent(httpEntity.getContent());
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(content);

        RegKeyResponse regKeyResponse = gson.fromJson(jsonObject.toJSONString(), RegKeyResponse.class);
        String regKeyResult = regKeyResponse.getRegistrationKey();
        System.out.println("finalResult " + regKeyResult);
        return regKeyResult;
    }

    public void createClinic(String registrationKey) throws IOException, ParseException {
        String json = gson.toJson(ClinicRequestUtil.generateRequest(registrationKey));

        final HttpPost clinicPostRequest = requestUtil.generatePostRequest(json, "createClinic", true);
        CloseableHttpResponse response = client.execute(clinicPostRequest);
        HttpEntity httpEntity = response.getEntity();

        String content = DataParser.parseContent(httpEntity.getContent());
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(content);

        System.out.println("jsonObject " + jsonObject);
        ClinicCreateResponse clinicCreateResponse = gson.fromJson(jsonObject.toJSONString(), ClinicCreateResponse.class);
        System.out.println("Value: " + clinicCreateResponse.getValue());

        System.out.println(response);
    }

    private RegKeyRequest buildRegKey() {
        return RegKeyRequest.builder()
                .CREATED_FOR("KuaNeeds")
                .CREATED_BY("test")
                .TYPE("POW")
                .build();
    }
}
