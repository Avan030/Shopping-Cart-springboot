package com.indusnet.ums.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.UserModel;

import jakarta.validation.Valid;

public interface IUserService {

	ResponseModel add(@Valid UserModel model);

	List<UserModel> getUsers();

	UserModel getUserById(String userId);

	void deleteUser(String userId);

	ResponseModel updateUser(UserModel user);
}
  