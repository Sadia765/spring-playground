package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

   @Autowired
private MockMvc mvc;

// @Test
// public void testTotalTicketPrice() throws Exception{
//     MockHttpServletRequestBuilder request = post("/flights/tickets/total")
//                             .contentType(MediaType.APPLICATION_JSON)
//                             .content("{\"tickets\": [{{\"passenger\": { \"firstName\": \"Some name\", \"lastName\": \"Some other name\" }, \"price\": 200 }," +
//                                     "{\"passenger\": { \"firstName\": \"Name B\", \"lastName\": \"Name C\" }, \"price\": 150 }]}");
//      this.mvc.perform(request)
//      .andExpect(status().isOk());
////      .andExpect(content().string("Total is $350"));
//
// }

}
