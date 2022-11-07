package com.eric.file_management.model;

public class User {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;

    public User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.age = userBuilder.age;
        this.address = userBuilder.address;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;

        // B1. builder() : convert to UserBuilder
        public UserBuilder() {}

        // B2. set data for user object
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        // B3. build() : return User;
        public User build() {
            User user = new User(this);
            return user;
        }
    }
}
