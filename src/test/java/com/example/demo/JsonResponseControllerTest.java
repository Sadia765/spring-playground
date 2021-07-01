package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JsonResponseController.class)
public class JsonResponseControllerTest {

    @Autowired
    private MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testObject() throws Exception {
        RequestBuilder request = get("/json/person").contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.firstName", is("Dwayne")))
                        .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testArray() throws Exception {
        this.mvc.perform(
                get("/json/people")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")));
    }

    @Test
    public void testObjectParams() throws Exception {
        MockHttpServletRequestBuilder request = post("/json/object-example")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"q\": \"other\", \"from\": \"2010\"}");
//        {"q" : "other", "from": "other"}
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Search: q=something from=2008"));
    }

    @Test
    public void testCreate() throws Exception {
        HashMap<String, Object> data = new HashMap<String, Object>(){  // 2
            {
                put("name", "Hercules");
                put("age", 57);
            }
        };

        String json = objectMapper.writeValueAsString(data);            // 3

        MockHttpServletRequestBuilder request = post("/json/objmapper")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);                                         // 4
        System.out.println(json);
        this.mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    public void testRawBody() throws Exception {
        String json = getJSON("src/main/resources/data.json");

        MockHttpServletRequestBuilder request = post("/json/fileObject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(json));
    }

    private String getJSON(String path) throws Exception {
//        URL url = this.getClass().getResource(path);
//        System.out.println(url);
//        System.out.println(this.getClass());
//        System.out.println(path);
        return new String(Files.readAllBytes(Paths.get(path)));
    }


}

