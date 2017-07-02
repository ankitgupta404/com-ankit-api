package com.ankit.api.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.api.model.AjaxResponseBody;
import com.ankit.api.model.News;
import com.ankit.api.services.NewsService;

@RestController
public class SearchController {
	private final Logger logger = LoggerFactory.getLogger(SearchController.class);

	NewsService newsService;

	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@PostMapping("/api/v1/news")
	public ResponseEntity<AjaxResponseBody> getNewsResult(@RequestParam(value = "loc", defaultValue = "en") String loc) {
		String METHOD_NAME = "getResultViaAjax";
		logger.debug("Inside Method::" + METHOD_NAME);
		AjaxResponseBody result = new AjaxResponseBody();

		logger.debug("input recieved - " + loc);
		List<News> news;
		try {
			news = newsService.getNews(loc);

			if (news.isEmpty()) {
				result.setMsg("no results found!");
			} else {
				result.setMsg("success");
			}
			result.setResult(news);
		} catch (IOException e) {
			logger.error(METHOD_NAME + " :: System Exception talking to backend system " + e);
			result.setMsg("no results- try after sometime");

		}

		return ResponseEntity.ok(result);

	}

}
