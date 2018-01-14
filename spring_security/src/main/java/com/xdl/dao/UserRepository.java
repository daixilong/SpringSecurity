package com.xdl.dao;

import com.xdl.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2017/12/31.
 */
//@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Long> {

   // @Cacheable(key = "#p0")
    User findByName(String name);

    User findByNameAndAge(String name,Integer age);

    @Query(" from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
