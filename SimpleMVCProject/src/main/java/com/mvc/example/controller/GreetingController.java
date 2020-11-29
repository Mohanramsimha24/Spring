package com.mvc.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.example.model.Member;

@RestController
public class GreetingController {
	List<Member> list = null;

	public GreetingController() {
		if (list == null)
			list = new ArrayList<>();

	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		StringBuilder stb = new StringBuilder();
		int i = 1;
		if (!list.isEmpty()) {
			for (Member mem : list) {
				stb.append(i);
				stb.append(mem.getFirstName());
				stb.append(mem.getLastName());
				stb.append(mem.getAddress());
				i++;
			}
		}
		return stb.toString();
	}

	@PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
	public void addMember(@RequestBody Member member) {
		list.add(member);
	}
}