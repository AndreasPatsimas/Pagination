package org.patsimas.pagination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=NoteControllerTest",
        "spring.jmx.default-domain=NoteControllerTest"})
public class NoteControllerTest extends BasicWiremockTest {

    @Test
    public void findNotesByPageAndSize() throws Exception {
        this.mockMvc.perform(get("/conditionalPagination?orderBy=id&direction=ASC&page=0&size=10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
