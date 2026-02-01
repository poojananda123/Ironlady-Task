
package com.ironlady.ai.controller;

//import org.springframework.web.bind.annotation.*;
//
//import com.ironlady.ai.model.ChatRequest;
//import com.ironlady.ai.service.OpenAiService;
//
//
//
//@RestController
//@CrossOrigin
//public class ChatController {
//
//    private final OpenAiService service;
//
//    public ChatController(OpenAiService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/chat")
//    public String chat(@RequestBody ChatRequest request) throws Exception {
//        return service.ask(request.getMessage());
//    }
//}
import org.springframework.web.bind.annotation.*;
import com.ironlady.ai.model.ChatRequest;
import com.ironlady.ai.service.OpenAiService;

import java.util.Map;

@RestController
@CrossOrigin
public class ChatController {

    private final OpenAiService service;

    public ChatController(OpenAiService service) {
        this.service = service;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody ChatRequest request) {
        String reply = service.ask(request.getMessage());

        // ✅ return JSON
        return Map.of("reply", reply);
    }
}
