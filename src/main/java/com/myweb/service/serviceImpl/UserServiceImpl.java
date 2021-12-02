package com.myweb.service.serviceImpl;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.mapper.Usermapper;
import com.myweb.pojo.User;
import com.myweb.service.UserService;
import com.myweb.util.TypeChallengeResultHandler;

@Service(value = "UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private Usermapper usermapper;
    /**
     *
     * @param id
     * @return 完整的user信息，包括其各种类型的题目的解题情况
     */
    @Override
    public User getUserById(Integer id) {
        User user=usermapper.getUserById(id);
        ResultHandler resultHandler=new TypeChallengeResultHandler();
        Map<Integer, List<Integer>> typeSolvedChallenges=((TypeChallengeResultHandler) resultHandler).getResults();
        user.setSolvedChallenge(typeSolvedChallenges);
        return user;
    }

    /**
     * @param user 插入的用户
     * @return 改变的行数
     */
    @Override
    public Integer insertUser(User user) {
        return usermapper.insertUser(user);
    }

    @Override
    public Integer getUserNumber() {
        return usermapper.SelectUserNumber();
    }
}
