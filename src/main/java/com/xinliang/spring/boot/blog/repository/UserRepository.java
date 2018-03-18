package com.xinliang.spring.boot.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.xinliang.spring.boot.blog.domain.User;

/**
 * User Repository接口
 * @author liangxin
 *
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
