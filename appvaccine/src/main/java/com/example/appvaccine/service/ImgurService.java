package com.example.appvaccine.service;

import org.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImgurService {
    private final String clientId = "b1dc1556f38ec3f"; // Thay thế với Client ID của bạn từ Imgur
    private final RestTemplate restTemplate = new RestTemplate();

    public String uploadImage(MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + clientId);

        ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes()){
            @Override
            public String getFilename(){
                return file.getOriginalFilename();
            }
        };

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", byteArrayResource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://api.imgur.com/3/upload", requestEntity, String.class);

        // Phân tích phản hồi để lấy URL ảnh
        JSONObject jsonResponse = new JSONObject(response.getBody());

        String imageUrl = jsonResponse.getJSONObject("data").getString("link");
        // ...

        return imageUrl; // Trả về URL của ảnh
    }

}
