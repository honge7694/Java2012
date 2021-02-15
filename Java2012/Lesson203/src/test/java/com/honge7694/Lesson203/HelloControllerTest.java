package com.honge7694.Lesson203;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/*
 * MockMvc는 Spring Test에서 제공되며 편리한 빌더 클래스 세트를 통해 HTTP Request를
 * DispatcherServlet으로 보내고 결과를 받아볼 수 있다.
 * @AutoConfigureMockMvc와 @SpringBootTest를 사용하여 MockMvc 인스턴스를 삽입.
 */

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(value = "user", roles = "USER") // scr/main/resources의 application.properties에 추가한 USER규칙으로 user값을 줌.
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    //@Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello, World!")));
    }
}