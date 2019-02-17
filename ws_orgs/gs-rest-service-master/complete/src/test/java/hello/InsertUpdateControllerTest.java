package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InsertUpdateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void updateUserNoValuePostTest() throws Exception {
        this.mockMvc.perform(post("/api/user/update")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "  \"id\":\"1\",\n" +
                        "  \"firstName\":\"fn\", \n" +
                        "  \"secondName\":\"sn\",\n" +
                        "  \"middleName\":\"mn\",\n" +
                        "  \"position\":\"pr\", \n" +
                        "  \"phone\":\"ph\",\n" +
                        "  \"docCode\":\"111\",\n" +
                        "  \"docName\":\"it's a name\",\n" +
                        "  \"docNumber\":\"224662\",\n" +
                        "  \"docDate\":\"130183\",\n" +
                        "  \"citizenshipCode\":\"121\",\n" +
                        "  \"isIdentified\":\"true\" \n" +
                        "}\n")
        )
                .andDo(print())
                .andExpect(status().is5xxServerError()).andExpect(jsonPath("$.error")
                .value("java.util.NoSuchElementException: No value present"))
        ;
    }

    @Test
    public void updateUserPostTest() throws Exception {
        this.mockMvc.perform(post("/api/user/update")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "  \"id\":\"2\",\n" +
                        "  \"firstName\":\"fn\", \n" +
                        "  \"secondName\":\"sn\",\n" +
                        "  \"middleName\":\"mn\",\n" +
                        "  \"position\":\"pr\", \n" +
                        "  \"phone\":\"ph\",\n" +
                        "  \"docCode\":\"111\",\n" +
                        "  \"docName\":\"it's a name\",\n" +
                        "  \"docNumber\":\"224662\",\n" +
                        "  \"docDate\":\"130183\",\n" +
                        "  \"citizenshipCode\":\"121\",\n" +
                        "  \"isIdentified\":\"true\" \n" +
                        "}\n")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("{\"result\":\"success\"}")))
                .andExpect(jsonPath("$.result")
                        .value("success")
                )
                .andExpect(jsonPath("$.data[0].name")
                        .doesNotExist())
        ;
    }

    @Test
    public void insertUserPostTest() throws Exception {
        this.mockMvc.perform(post("/api/user/save")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "  \"officeId\":\"2\",\n" +
                        "  \"firstName\":\"fn\", \n" +
                        "  \"secondName\":\"sn\",\n" +
                        "  \"middleName\":\"mn\",\n" +
                        "  \"position\":\"pr\", \n" +
                        "  \"phone\":\"ph\",\n" +
                        "  \"docCode\":\"111\",\n" +
                        "  \"docName\":\"it's a name\",\n" +
                        "  \"docNumber\":\"224662\",\n" +
                        "  \"docDate\":\"130183\",\n" +
                        "  \"citizenshipCode\":\"121\",\n" +
                        "  \"isIdentified\":\"true\" \n" +
                        "}\n")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("{\"result\":\"success\"}")))
                .andExpect(jsonPath("$.result")
                        .value("success")
                )
                .andExpect(jsonPath("$.data[0].name")
                        .doesNotExist())
        ;
    }

    @Test
    public void updateOfficePostTest() throws Exception {
        this.mockMvc.perform(post("/api/office/update")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\"id\":\"1\",\n" +
                        "\"orgId\":\"1\",\n" +
                        "\"name\":\"ame\",\n" +
                        "\"address\":\"ddress\",\n" +
                        "\"phone\":\"22222\",\n" +
                        "\"isActive\":\"true\"\n" +
                        "}\n")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("{\"result\":\"success\"}")))
                .andExpect(jsonPath("$.result")
                        .value("success")
                )
                .andExpect(jsonPath("$.data[0].name")
                        .doesNotExist())
        ;
    }

    @Test
    public void insertOfficePostTest() throws Exception {
        this.mockMvc.perform(post("/api/office/save")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\"orgId\":\"1\",\n" +
                        "\"name\":\"ame\",\n" +
                        "\"address\":\"ddress\",\n" +
                        "\"phone\":\"22222\",\n" +
                        "\"isActive\":\"true\"\n" +
                        "}\n")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("{\"result\":\"success\"}")))
                .andExpect(jsonPath("$.result")
                        .value("success")
                )
                .andExpect(jsonPath("$.data[0].name")
                        .doesNotExist())
        ;
    }

    @Test
    public void updateOrganizationPostTest() throws Exception {
        this.mockMvc.perform(post("/api/organization/update")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\"id\":\"1\",\n" +
                        "\"name\":\"ame\",\n" +
                        "\"fullName\":\"ullName\",\n" +
                        "\"inn\":\"55\",\n" +
                        "\"kpp\":\"99\",\n" +
                        "\"address\":\"ddress\",\n" +
                        "\"phone\":\"22222\",\n" +
                        "\"isActive\":\"true\"" +
                        "}\n"
                )
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("{\"result\":\"success\"}")))
                .andExpect(jsonPath("$.result")
                        .value("success")
                )
                .andExpect(jsonPath("$.data[0].name")
                        .doesNotExist())
        ;
    }

    @Test
    public void insertOrganizationPostTest() throws Exception {
        this.mockMvc.perform(post("/api/organization/save")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\"name\":\"ame\",\n" +
                        "\"fullName\":\"ullName\",\n" +
                        "\"inn\":\"55\",\n" +
                        "\"kpp\":\"99\",\n" +
                        "\"address\":\"ddress\",\n" +
                        "\"phone\":\"22222\",\n" +
                        "\"isActive\":\"true\"" +
                        "}\n")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("{\"result\":\"success\"}")))
                .andExpect(jsonPath("$.result")
                        .value("success")
                )
                .andExpect(jsonPath("$.data[0].name")
                        .doesNotExist())
        ;
    }
}
