package wf.bitcoin.krotjson;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

	private static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
	}

	public static Object parse(String jsonString) {
		try {
			return objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>(){});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String stringify(Map<String, Object> map) {
		try {
			return objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}

