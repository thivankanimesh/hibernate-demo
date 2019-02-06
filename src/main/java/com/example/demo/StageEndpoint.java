package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "stage")
public class StageEndpoint {

	private Map<String, Stage> stages = new ConcurrentHashMap<>();

	@ReadOperation
	public Map<String, Stage> getStages() {
		return stages;
	}

	@ReadOperation
	public Stage getStage(@Selector String name) {
		return stages.get(name);
	}

	@WriteOperation(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void setStage(@Selector String name, int stage) {
		stages.put(name, new Stage(stage));
	}

	private static class Stage {
		private int value;

		public Stage(int value) {
			super();
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

}
