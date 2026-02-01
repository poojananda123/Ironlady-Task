package com.ironlady.ai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

//package com.ironlady.ai.service;

//import okhttp3.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class OpenAiService {
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


//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@Service
//public class OpenAiService {
//
//    @Value("${openai.api.key}")
//    private String apiKey;
//
//    private static final String OPENAI_URL =
//            "https://api.openai.com/v1/chat/completions";
//
////    public String ask(String userMessage) {
////
////        try {
////            return callOpenAi(userMessage);
////        } catch (Exception e) {
////            // 🔥 graceful fallback (VERY IMPORTANT)
////            return fallbackResponse(userMessage);
////        }
////    }
//    public String ask(String userMessage) {
//        try {
//            System.out.println("👉 Calling REAL OpenAI API");
//            return callOpenAi(userMessage);
//        } catch (Exception e) {
//            System.out.println("⚠️ OpenAI failed, using FALLBACK");
//            return fallbackResponse(userMessage);
//        }
//        
//    }
//
//
////    private String callOpenAi(String userMessage) {
////
////        RestTemplate restTemplate = new RestTemplate();
////
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.setBearerAuth(apiKey);
////
////        Map<String, String> systemMsg = Map.of(
////                "role", "system",
////                "content",
////                "You are an AI assistant for Iron Lady. " +
////                "Explain Iron Lady programs, process, and benefits clearly. " +
////                "Do not answer unrelated questions."
////        );
////
////        Map<String, String> userMsg = Map.of(
////                "role", "user",
////                "content", userMessage
////        );
////
////        List<Map<String, String>> messages = List.of(systemMsg, userMsg);
////
////        Map<String, Object> body = new HashMap<>();
////        body.put("model", "gpt-3.5-turbo");
////        body.put("messages", messages);
////        body.put("temperature", 0.5);
////
////        HttpEntity<Map<String, Object>> request =
////                new HttpEntity<>(body, headers);
////
////        ResponseEntity<Map> response = restTemplate.exchange(
////                OPENAI_URL,
////                HttpMethod.POST,
////                request,
////                Map.class
////        );
////
////        Map responseBody = response.getBody();
////        List choices = (List) responseBody.get("choices");
////        Map choice = (Map) choices.get(0);
////        Map message = (Map) choice.get("message");
////
////        return message.get("content").toString();
////    }
//
//    private String callOpenAi(String userMessage) {
//
//        System.out.println("API Key Loaded: " + (apiKey != null && !apiKey.isEmpty()));
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
//                "You are an AI assistant for Iron Lady..."
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
//        body.put("model", "gpt-4o-mini");
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
//        System.out.println("OpenAI Response Status: " + response.getStatusCode());
//        System.out.println("OpenAI Response Body: " + response.getBody());
//
//        Map responseBody = response.getBody();
//        List choices = (List) responseBody.get("choices");
//        Map choice = (Map) choices.get(0);
//        Map message = (Map) choice.get("message");
//
//        return message.get("content").toString();
//    }
//
//    // ✅ fallback AI logic (assignment-safe)
//    private String fallbackResponse(String msg) {
//
//        msg = msg.toLowerCase();
//
//        // Greeting
//        if (msg.contains("hi") || msg.contains("hello") || msg.contains("hey")) {
//            return "Hello 👋 Welcome to Iron Lady! I’m here to help you explore our programs, learning journey, and career support.";
//        }
//
//        // Programs
//        if (msg.contains("program") || msg.contains("course")) {
//            return """
//    Iron Lady offers career-focused programs designed to empower women:
//
//    1️⃣ Java Full Stack Development – 6 months  
//       Skills: Java, Spring Boot, SQL, React  
//       Careers: Software Developer, Full Stack Engineer
//
//    2️⃣ Data Analytics – 4 months  
//       Skills: Excel, SQL, Python, Power BI  
//       Careers: Data Analyst, Business Analyst
//
//    3️⃣ Cloud & DevOps – 5 months  
//       Skills: AWS, Docker, CI/CD  
//       Careers: Cloud Engineer, DevOps Engineer
//    """;
//        }
//
//        // Duration
//        if (msg.contains("duration") || msg.contains("how long")) {
//            return "Our programs range from 4 to 6 months, depending on the course, with structured learning and mentorship support.";
//        }
//
//        // Enrollment process
//        if (msg.contains("join") || msg.contains("enroll") || msg.contains("process")) {
//            return """
//    The Iron Lady enrollment process is simple:
//
//    1️⃣ Register on our platform  
//    2️⃣ Attend counseling & guidance session  
//    3️⃣ Choose your program  
//    4️⃣ Start learning with mentor support
//    """;
//        }
//
//        // Placement / Career
//        if (msg.contains("placement") || msg.contains("job") || msg.contains("career")) {
//            return "Iron Lady provides career guidance, mentorship, resume support, and interview preparation to help learners become industry-ready.";
//        }
//
//        // Fees
//        if (msg.contains("fee") || msg.contains("cost") || msg.contains("price")) {
//            return "Program fees vary based on the course. Our counselors will guide you with flexible payment options and support.";
//        }
//
//        // Benefits
//        if (msg.contains("benefit") || msg.contains("why iron lady")) {
//            return """
//    Iron Lady stands out because of:
//    ✔ Women-focused mentorship  
//    ✔ Industry-relevant curriculum  
//    ✔ Career guidance & confidence building  
//    ✔ Supportive learning community
//    """;
//        }
//
//        // Default fallback
//        return "I can help you with Iron Lady programs, enrollment steps, duration, and career guidance. Please ask me about any of these 😊";
//    }
//
//}


    @Value("${openai.api.key}")
    private String apiKey;

    private static final String OPENAI_URL =
            "https://api.openai.com/v1/chat/completions";

    public String ask(String userMessage) {
        try {
            return callChatGPT(userMessage);
        } catch (Exception e) {
            return fallbackResponse(userMessage);
        }
    }

    private String callChatGPT(String userMessage) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        headers.add("Content-Type", "application/json");

        Map<String, Object> system = new HashMap<>();
        system.put("role", "system");
        system.put("content", "You are Iron Lady AI assistant.");

        Map<String, Object> user = new HashMap<>();
        user.put("role", "user");
        user.put("content", userMessage);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", List.of(system, user));

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                "https://api.openai.com/v1/chat/completions",
                HttpMethod.POST,
                entity,
                Map.class
        );

        Map responseBody = response.getBody();
        List choices = (List) responseBody.get("choices");
        Map message = (Map) ((Map) choices.get(0)).get("message");

        return message.get("content").toString();
    }


    // ✅ Fallback AI (ASSIGNMENT SAFE)
    private String fallbackResponse(String msg) {

        msg = msg.toLowerCase();

        if (msg.contains("hi") || msg.contains("hello")) {
            return "Hello 👋 Welcome to Iron Lady! How can I help you today?";
        }

        if (msg.contains("course") || msg.contains("program")) {
            return """
Iron Lady Programs:
1️⃣ Java Full Stack – 6 months – Placement support
2️⃣ Data Analytics – 4 months – Excel, SQL, Python
3️⃣ Cloud & DevOps – 5 months – AWS, Docker
""";
        }

        if (msg.contains("join") || msg.contains("enroll")) {
            return """
Enrollment Process:
1️⃣ Register
2️⃣ Counseling session
3️⃣ Choose program
4️⃣ Start learning
""";
        }

        return "I can help with programs, duration, enrollment, and careers at Iron Lady 😊";
    }
}
