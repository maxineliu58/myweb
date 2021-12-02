package com.myweb.service;

import java.util.List;

import com.myweb.pojo.Challenge;
import com.myweb.pojo.ChallengeList;

public interface ChallengeService {
    Challenge getChallengeById(int cid);
    int saveChallenge(Challenge challenge);
    void deleteChallenge(int cid);
    int addChallenge(Challenge challenge);
	List listAllChallenges(Integer type, String isuse, String myuse,String search);
	Challenge getByname(String name);

}
