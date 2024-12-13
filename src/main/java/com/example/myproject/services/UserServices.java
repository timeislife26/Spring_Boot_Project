package com.example.myproject.services;

import com.example.myproject.entities.MyUser;
import com.example.myproject.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserServices implements UserDetailsService, UserRepository {
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),user.isCredentialsNonExpired(),user.isAccountNonLocked(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }

    @Override
    public MyUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public MyUser createUser(MyUser user) {
        return userRepository.save(user);
    }

    @Override
    public MyUser updatePasswordByUsername(String username, String password) {
        return userRepository.updatePasswordByUsername(username, password);
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends MyUser> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends MyUser> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<MyUser> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public MyUser getOne(Integer integer) {
        return null;
    }

    @Override
    public MyUser getById(Integer integer) {
        return null;
    }

    @Override
    public MyUser getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends MyUser> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MyUser> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends MyUser> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends MyUser> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MyUser> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MyUser> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends MyUser, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends MyUser> S save(S entity) {
        return null;
    }

    @Override
    public <S extends MyUser> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<MyUser> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<MyUser> findAll() {
        return List.of();
    }

    @Override
    public List<MyUser> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(MyUser entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends MyUser> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<MyUser> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<MyUser> findAll(Pageable pageable) {
        return null;
    }
}
