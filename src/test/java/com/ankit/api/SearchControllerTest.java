package com.ankit.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ankit.api.controller.SearchController;
import com.ankit.api.model.AjaxResponseBody;
import com.ankit.api.model.News;
import com.ankit.api.services.NewsService;

/**
 * @author Josh Long
 */
// import statements

@RunWith(SpringRunner.class)
@WebMvcTest(SearchController.class)
public class SearchControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	NewsService newsService;

	@Test
	public void testNewsResult() throws Exception {

		// prepare data and mock's behaviour
		List<News> NewsStub = new ArrayList<News>();
		News News1 = new News(1l, "12 May 2017", "title1", "/content/lloys/dam/1/2/1.png", "news excerpt1");
		News News2 = new News(2l, "12 May 2017", "title2", "/content/lloys/dam/1/2/2.png", "news excerpt2");
		News News3 = new News(3l, "12 May 2017", "title3", "/content/lloys/dam/1/2/3.png", "news excerpt3");

		NewsStub.add(News1);
		NewsStub.add(News2);
		NewsStub.add(News3);

		when(newsService.getNews(any(String.class))).thenReturn(NewsStub);

		// execute

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/news")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8).content("en"))
				.andReturn();

		// verify
		// verify
		int status = result.getResponse().getStatus();
		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

		AjaxResponseBody newsResults = TestUtils.jsonToObject(result.getResponse().getContentAsString(),
				AjaxResponseBody.class);
		assertNotNull(newsResults);
		assertEquals(3l, newsResults.getResult().size());
		assertEquals("title1", newsResults.getResult().get(0).getTitle());

	}

}