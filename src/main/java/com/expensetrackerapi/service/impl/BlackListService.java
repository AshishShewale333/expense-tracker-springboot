package com.expensetrackerapi.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class BlackListService {
	
	private Set<String> blacklist = new HashSet<>();
	
	public void addTokenToBlacklist(String token) {
		blacklist.add(token);
	}

	public boolean isTokenBlacklisted(String token) {
		return blacklist.contains(token);
	}
}
