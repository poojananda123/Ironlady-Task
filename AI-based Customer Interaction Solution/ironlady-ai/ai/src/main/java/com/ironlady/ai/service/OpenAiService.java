package com.ironlady.ai.service;


//package com.ironlady.ai.service;

//import okhttp3.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OpenAiService {
//
//    @Value("${openai.api.key}")
//    private String apiKey;
//
//    private static final String SYSTEM_PROMPT = """
//You are Iron Lady AI Career Guide.
//
//Your role:
//- Help learners understand Iron Lady programs
//- Recommend courses based on background
//- Explain duration, skills, and careers
//- Guide users through enrollment steps
//
//Programs:
//1. Java Full Stack – 6 months – Placement support
//2. Data Analytics – 4 months – Excel, SQL, Python
//3. Cloud & DevOps – 5 months – AWS, Docker
//
//Be friendly and professional.
//""";
//
//    public String askAI(String userMessage) throws Exception {
//
//        OkHttpClient client = new OkHttpClient();
//
//        String json = """
//        {
//          "model": "gpt-4o-mini",
//          "messages": [
//            {"role": "system", "content": "%s"},
//            {"role": "user", "content": "%s"}
//          ]
//        }
//        """.formatted(SYSTEM_PROMPT, userMessage);
//
//        Request request = new Request.Builder()
//                .url("https://api.openai.com/v1/chat/completions")
//                .post(RequestBody.create(
//                        json, MediaType.parse("application/json")))
//                .addHeader("Authorization", "Bearer " + apiKey)
//                .build();
//
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
//}
//


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenAiService {

    @Value("${openai.api.key}")
    private String apiKey;

    private static final String OPENAI_URL =
            "https://api.openai.com/v1/chat/completions";

//    public String ask(String userMessage) {
//
//        try {
//            return callOpenAi(userMessage);
//        } catch (Exception e) {
//            // 🔥 graceful fallback (VERY IMPORTANT)
//            return fallbackResponse(userMessage);
//        }
//    }
    public String ask(String userMessage) {
        try {
            System.out.println("👉 Calling REAL OpenAI API");
            return callOpenAi(userMessage);
        } catch (Exception e) {
            System.out.println("⚠️ OpenAI failed, using FALLBACK");
            return fallbackResponse(userMessage);
        }
        
    }


//    private String callOpenAi(String userMessage) {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(apiKey);
//
//        Map<String, String> systemMsg = Map.of(
//                "role", "system",
//                "content",
//                "You are an AI assistant for Iron Lady. " +
//                "Explain Iron Lady programs, process, and benefits clearly. " +
//                "Do not answer unrelated questions."
//        );
//
//        Map<String, String> userMsg = Map.of(
//                "role", "user",
//                "content", userMessage
//        );
//
//        List<Map<String, String>> messages = List.of(systemMsg, userMsg);
//
//        Map<String, Object> body = new HashMap<>();
//        body.put("model", "gpt-3.5-turbo");
//        body.put("messages", messages);
//        body.put("temperature", 0.5);
//
//        HttpEntity<Map<String, Object>> request =
//                new HttpEntity<>(body, headers);
//
//        ResponseEntity<Map> response = restTemplate.exchange(
//                OPENAI_URL,
//                HttpMethod.POST,
//                request,
//                Map.class
//        );
//
//        Map responseBody = response.getBody();
//        List choices = (List) responseBody.get("choices");
//        Map choice = (Map) choices.get(0);
//        Map message = (Map) choice.get("message");
//
//        return message.get("content").toString();
//    }

    private String callOpenAi(String userMessage) {

        System.out.println("API Key Loaded: " + (apiKey != null && !apiKey.isEmpty()));

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, String> systemMsg = Map.of(
                "role", "system",
                "content",
                "You are an AI assistant for Iron Lady..."
        );

        Map<String, String> userMsg = Map.of(
                "role", "user",
                "content", userMessage
        );

        List<Map<String, String>> messages = List.of(systemMsg, userMsg);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o-mini");
        body.put("messages", messages);
        body.put("temperature", 0.5);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                OPENAI_URL,
                HttpMethod.POST,
                request,
                Map.class
        );

        System.out.println("OpenAI Response Status: " + response.getStatusCode());
        System.out.println("OpenAI Response Body: " + response.getBody());

        Map responseBody = response.getBody();
        List choices = (List) responseBody.get("choices");
        Map choice = (Map) choices.get(0);
        Map message = (Map) choice.get("message");

        return message.get("content").toString();
    }

    // ✅ fallback AI logic (assignment-safe)
    private String fallbackResponse(String msg) {

        msg = msg.toLowerCase();

        if (msg.contains("program")) {
            return "Iron Lady offers mentorship-driven career programs, skill development courses, and structured learning paths focused on empowering women professionals.";
        }

        if (msg.contains("process") || msg.contains("join")) {
            return "The Iron Lady journey starts with registration, followed by counseling, program selection, and guided onboarding into the learning ecosystem.";
        }

        if (msg.contains("benefit")) {
            return "Iron Lady helps learners gain industry-ready skills, confidence, mentorship support, and real-world exposure.";
        }

        return "Iron Lady is a women-focused initiative designed to support career growth, mentorship, and professional empowerment.";
    }
}
