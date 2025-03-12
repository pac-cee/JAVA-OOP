package com.oopmastery.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern example demonstrating event handling and notifications.
 * Shows:
 * 1. Subject-Observer relationship
 * 2. Event notification
 * 3. Loose coupling
 */
public class NewsAgency {
    private final List<NewsSubscriber> subscribers;
    private String latestNews;

    public NewsAgency() {
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(NewsSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(NewsSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNews(String news) {
        this.latestNews = news;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (NewsSubscriber subscriber : subscribers) {
            subscriber.update(latestNews);
        }
    }
}

interface NewsSubscriber {
    void update(String news);
}

class NewsChannel implements NewsSubscriber {
    private final String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.printf("%s received news: %s%n", name, news);
    }
}

class NewsWebsite implements NewsSubscriber {
    private final String url;

    public NewsWebsite(String url) {
        this.url = url;
    }

    @Override
    public void update(String news) {
        System.out.printf("Website %s updated with news: %s%n", url, news);
    }
}

class MobileApp implements NewsSubscriber {
    private final String appId;

    public MobileApp(String appId) {
        this.appId = appId;
    }

    @Override
    public void update(String news) {
        System.out.printf("Mobile app %s pushing notification: %s%n", appId, news);
    }
} 