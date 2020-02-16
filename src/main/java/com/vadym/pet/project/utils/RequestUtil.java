package com.vadym.pet.project.utils;

        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.entity.StringEntity;

        import java.io.UnsupportedEncodingException;

public class RequestUtil {

    private static final String APPLICATION_JSON = "application/json";

    public HttpPost generatePostRequest(String body, String path, boolean clinicType) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost("https://ous.test.clpro.me/hcp/clinics/" + path);
        StringEntity entity = new StringEntity(body);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", APPLICATION_JSON);
        httpPost.setHeader("Content-type", APPLICATION_JSON);
        if(clinicType) {
            httpPost.setHeader("X-Clinic-Type", "POW");
        }
        return httpPost;
    }
}
