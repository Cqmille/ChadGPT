package fr.chadgpt.backend.security;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LoginAttemptService {
    private final int MAX_ATTEMPTS = 5;
    private final ConcurrentMap<String, AtomicInteger> attemptsCache = new ConcurrentHashMap<>();

    public void loginFailed(String key) {
        attemptsCache.putIfAbsent(key, new AtomicInteger(0));
        attemptsCache.get(key).incrementAndGet();
    }

    public void loginSucceeded(String key) {
        attemptsCache.remove(key);
    }

    public boolean isBlocked(String key) {
        return attemptsCache.containsKey(key) && attemptsCache.get(key).get() >= MAX_ATTEMPTS;
    }
}