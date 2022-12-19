package com.mono.lesson.sub;

public enum BookStatus {
    DRAFT("Draft"), PUBLISHED("Published");

    private String name;

    private BookStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookStatus{" +
                "name='" + name + '\'' +
                '}';
    }
}
