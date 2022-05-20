package com.tiff.tffnserachservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiff.tffnserachservice.model.*;
import com.tiff.tffnserachservice.repository.TiffnerRepository;
import com.tiff.tffnserachservice.service.TiffnerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TiffnerController.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
class TiffnerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private TiffnerRepository tiffnerRepository;

    @MockBean
    private TiffnerService tiffnerService;

    ContactInformation contactInformation = new ContactInformation("7326891995", "avanirpattel");

    Tags tag1 = new Tags(1L,"Indian");
    Tags tag2 = new Tags(2L,"Gujarati");
    Set<Tags> tagsSet = new HashSet<>(){
        {
            add(tag1);
            add(tag2);
        }
    };

    Reviews review1 = new Reviews(1L, "Great");
    Reviews review2 = new Reviews(2L, "Amazing");
    Set<Reviews> reviewsSet = new HashSet<>(){
        {
            add(review1);
            add(review2);
        }
    };
    BusinessHours businessHours1 = new BusinessHours(DayOfWeek.MONDAY,DayOfWeek.FRIDAY, Time.valueOf("12:00:00"),Time.valueOf("7:00:00"));

    ContactInformation contactInformation2 = new ContactInformation("9085662674", "sohanpatel96");

    Tags tag3 = new Tags(1L,"Indian");
    Tags tag4 = new Tags(2L,"Bombay");
    Set<Tags> tagsSet2 = new HashSet<>(){
        {
            add(tag3);
            add(tag4);
        }
    };

    Reviews review3 = new Reviews(1L, "Superb");
    Reviews review4 = new Reviews(2L, "Fabulous");
    Set<Reviews> reviewsSet2 = new HashSet<>(){
        {
            add(review3);
            add(review4);
        }
    };
    BusinessHours businessHours2 = new BusinessHours(DayOfWeek.SUNDAY,DayOfWeek.SATURDAY, Time.valueOf("10:00:00"),Time.valueOf("7:00:00"));

    Tiffner tiffn_one = new Tiffner(1L, "Patel's", contactInformation,"W Warren St", tagsSet,reviewsSet,businessHours1,"Great Price","***",3);
    Tiffner tiffn_two = new Tiffner(2L,"Sopo's", contactInformation2,"Diaz Ct", tagsSet2,reviewsSet2,businessHours2,"Owner is too kind","****",4);

    @Test
    void findTiffns() throws Exception {
        List<Tiffner> tiffnerList = new ArrayList<>();
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        tiffnerList.add(tiffn_one);
        tiffnerList.add(tiffn_two);
        Mockito.when(tiffnerRepository.findAll()).thenReturn(tiffnerList);
        mvc.perform(MockMvcRequestBuilders.get("/tffn-search/tffns")).andExpect(ok);
    }

    @Test
    void findTffn() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();


        //tiffnerRepository.findById()
        Mockito.when(tiffnerRepository.findByTiffnerId(tiffn_one.getTiffnerId())).thenReturn(java.util.Optional.of(tiffn_one));

        mvc.perform(MockMvcRequestBuilders.get("/tffn-search/tffns/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTffn() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status().isNoContent();

        Mockito.when(tiffnerRepository.findByTiffnerId(tiffn_two.getTiffnerId())).thenReturn(java.util.Optional.of(tiffn_two));
        mvc.perform(MockMvcRequestBuilders.delete("/tffn-search/tffns/2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }

    @Test
    void addTffn() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        ContactInformation contactInformation = new ContactInformation("1234567890", "mamtapatel");
        BusinessHours businessHours = new BusinessHours(DayOfWeek.SUNDAY,DayOfWeek.SATURDAY,Time.valueOf("11:00:00"),Time.valueOf("5:00:00"));
        Tags tag1 = new Tags(1L, "Mexican");
        Set<Tags> tags = new HashSet<>(){
            {
                add(tag1);
            }
        };
        Reviews review = new Reviews(1L, "Nice");
        Set<Reviews> reviews = new HashSet<>(){
            {
                add(review);
            }
        };

        Tiffner addTiff = Tiffner.builder()
            .tiffnerId(1L)
            .name("Mamu")
            .contactInformation(contactInformation)
            .businessHours(businessHours)
            .tags(tags)
            .reviews(reviews)
            .address("Warren")
            .description("Fabulous")
            .price(4)
            .rating("**").build();

        Mockito.when(tiffnerRepository.save(addTiff)).thenReturn(addTiff);



        mvc.perform(MockMvcRequestBuilders.post("/tffn-search")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addTiff)))
                .andExpect(ok);

    }

//    @Test
//    void updateTffn() throws Exception {
//        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
//
//        ContactInformation contactInformation = new ContactInformation("1234567890", "mamtapatel");
//        BusinessHours businessHours = new BusinessHours(DayOfWeek.SUNDAY,DayOfWeek.SATURDAY,Time.valueOf("11:00:00"),Time.valueOf("5:00:00"));
//        Tags tag1 = new Tags(1L, "Mexican");
//        Set<Tags> tags = new HashSet<>(){
//            {
//                add(tag1);
//            }
//        };
//        Reviews review = new Reviews(1L, "Nice UD");
//        Set<Reviews> reviews = new HashSet<>(){
//            {
//                add(review);
//            }
//        };
//
//        Tiffner updateTiff = Tiffner.builder()
//                .tiffnerId(2L)
//                .name("MAMU - UPDATED")
//                .contactInformation(contactInformation)
//                .businessHours(businessHours)
//                .tags(tags)
//                .reviews(reviews)
//                .address("Warren")
//                .description("Fabulous")
//
//                .price(4)
//                .rating("**").build();
//
//        Mockito.when(tiffnerRepository.findByTiffnerId(tiffn_two.getTiffnerId())).thenReturn(Optional.of(tiffn_one));
//        Mockito.when(tiffnerRepository.save(updateTiff)).thenReturn(updateTiff);
//
//        MockHttpServletRequestBuilder mockreq = MockMvcRequestBuilders.put("/tffn-search/tffns/2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(updateTiff));
//
//        mvc.perform(mockreq).andExpect(ok);
//
//    }
}