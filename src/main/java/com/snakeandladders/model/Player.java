package com.snakeandladders.model;

public class Player {

    private final String firstName;
    private final String lastName;
    private final Integer age;

    Player(String firstName, String lastName, Integer age) {
        if (firstName == null || lastName == null || age == null) {
            throw new AssertionError();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getShortName() {
        return String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0));
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {
        private String firstName;
        private String lastName;
        private Integer age;

        public PlayerBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PlayerBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PlayerBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Player build() {
            return new Player(firstName, lastName, age);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
