package com.gmail.aba;

import com.gmail.aba.data.AppleFactoryData;
import com.gmail.aba.data.IphoneData;
import com.gmail.aba.dto.IphoneDetailsDTO;
import com.gmail.aba.dto.IphoneSearchDTO;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = HomeworkWeek91011Application.class)
@AutoConfigureMockMvc
class HomeworkWeek91011ApplicationTests extends AbstractTest {

    private static final int INCORRECT_ID = 999;
    private static final int CORRECT_ID = 1;


    @Test
    public void getAllFactories() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/factory/getAll")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        AppleFactoryData[] appleFactory = mapFromJson(content, AppleFactoryData[].class);
        assertTrue(appleFactory.length > 0);
    }

    @Test
    public void testCreateIphone() throws Exception {
        IphoneData iphone = new IphoneData("iphone145", "black", "23.00000", 1);

        String inputJson = mapToJson(iphone);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/iphone/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"result\":\"Created\"}");
    }

    @Test
    public void testUpdateIphone() throws Exception {
        IphoneData iphone = new IphoneData("iphoneUpdate", "black", "23.00000", 1);

        String inputJson = mapToJson(iphone);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/api/iphone/update/" + CORRECT_ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"result\":\"Iphone updated\"}");
    }

    @Test
    public void testUpdateIphoneNotFoundId() throws Exception {
        IphoneData iphone = new IphoneData("iphoneUpdate", "black", "23.00000", 1);

        String inputJson = mapToJson(iphone);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/api/iphone/update/" + INCORRECT_ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"result\":\"method 'updateIphone': id not found\"}");
    }

    @Test
    public void testDeleteIphone() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/api/iphone/delete/" + CORRECT_ID)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"result\":\"Iphone deleted from the database\"}");
    }

    @Test
    public void testDeleteIphoneNotFoundId() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/api/iphone/delete/" + INCORRECT_ID)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"result\":\"method 'deleteIphoneById': id not found\"}");
    }

    @Test
    public void getPhonesLimit() throws Exception {
        IphoneSearchDTO iphoneSearch = new IphoneSearchDTO("iphone13", "black", 0, 5);
        String inputJson = mapToJson(iphoneSearch);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/iphone/_search")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        IphoneData[] appleFactory = mapFromJson(content, IphoneData[].class);
        assertTrue(appleFactory.length > 0 && appleFactory.length == 5 );
    }

    @Test
    public void getIphoneById() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/iphone/2")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        IphoneDetailsDTO iphoneDetails = mapFromJson(content, IphoneDetailsDTO.class);

        assertEquals(2, iphoneDetails.getIphoneId());
        assertEquals("iphone12", iphoneDetails.getName());
        assertEquals("white", iphoneDetails.getColor());
        assertEquals("37,000", iphoneDetails.getPrice());
        assertEquals(1, iphoneDetails.getFactoryId());
        assertEquals("China", iphoneDetails.getCountry());
    }
}
