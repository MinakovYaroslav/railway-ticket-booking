package com.minakov.railwayticketbooking.repository.localfile;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.User;
import com.minakov.railwayticketbooking.repository.UserRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.minakov.railwayticketbooking.config.DateFormatConfig.userBirthdayFormat;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users;

    public UserRepositoryImpl() {
        users = users();
    }

    private List<User> users() {
        List<User> users = new ArrayList<>();
        UUID id;
        String firstName;
        String lastName;
        Date birthday;

        for (String[] data : IOUtil.read(FilePaths.USERS.get())) {
            id = UUID.fromString(data[0]);
            firstName = data[1];
            lastName = data[2];
            try {
                birthday = userBirthdayFormat.parse(data[3]);
            } catch (ParseException e) {
                e.printStackTrace();
                birthday = null;
            }
            users.add(new User.UserBuilder()
                    .setId(id)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setBirthday(birthday)
                    .build());
        }
        return users;
    }

    @Override
    public User findById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    private void objToFile(List<User> users) {
        List<String[]> data = users.stream()
                .map(user -> new String[]{
                        String.valueOf(user.getId()),
                        user.getFirstName(),
                        user.getLastName(),
                        userBirthdayFormat.format(user.getBirthday())
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.USERS.get());
    }

    @Override
    public User create(User user) {
        user.setId(UUID.randomUUID());
        users.add(user);
        objToFile(users);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public User update(User user) {
        return null;
    }
}
