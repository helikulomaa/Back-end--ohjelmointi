package k25.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.*;

//mockMvc:n metodit
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class BookRestTests {

    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/books")).andExpect(status().isOk());
    }

    @Test
    public void testGetBook() throws Exception {
        mockMvc.perform(get("/books/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetBookBadRequest() throws Exception {
        mockMvc.perform(get("/books/abc")).andExpect(status().isBadRequest());
    }

    @Test
    public void responseTypeJson() throws Exception {
        mockMvc.perform(get("/books")).andExpect(content().contentType("application/json"));
    }

}
