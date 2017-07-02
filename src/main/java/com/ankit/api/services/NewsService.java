package com.ankit.api.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ankit.api.model.BackendModel;
import com.ankit.api.model.News;

@Service
public class NewsService {

	private final Logger logger = LoggerFactory.getLogger(NewsService.class);

	private String URL = "http://localhost/{loc}/news/newslist.json";
	private BackendModel backendModel;
	private List<News> news = new ArrayList<News>();

	public List<News> getNews(String locale) throws IOException {
		String METHOD_NAME = "getNews";
		logger.debug("Inside Method::" + METHOD_NAME);
		
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("loc", locale);
		
		
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		RestTemplate restTemplate = new RestTemplate();

		String backendResp = restTemplate.getForObject(URL, String.class, uriParams);

		try {
			jsonObject = (JSONObject) parser.parse(backendResp);
			Boolean status = (Boolean) jsonObject.get("success");
			if (status) {
				ObjectMapper mapper = new ObjectMapper();
				backendModel = mapper.readValue(backendResp, BackendModel.class);
				news = backendModel.getDocs();

			}

		} catch (ParseException e) {
			logger.error(METHOD_NAME + " :: Error Parsing backend response - " + backendResp);
		} catch (JsonParseException e) {
			logger.error(METHOD_NAME + " :: Error Parsing backend response - " + backendResp);

		} catch (JsonMappingException e) {
			logger.error(METHOD_NAME + " :: Error Parsing backend response, Issue with JSON Mapping - " + backendResp);
		}

		return news;

	}

}
