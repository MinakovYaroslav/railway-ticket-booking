package com.minakov.railwayticketbooking.model;

import java.util.Date;
import java.util.UUID;

public class User extends AbstractIdentifiable {

    private String firstName;

    private String lastName;

    private Date birthday;

    public User(UserBuilder userBuilder) {
        super(userBuilder.id);
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.birthday = userBuilder.birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public static  class UserBuilder {

        private UUID id;

        private String firstName;

        private String lastName;

        private Date birthday;

        public UserBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
