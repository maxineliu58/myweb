package com.myweb.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.mapper.Challengemapper;
import com.myweb.pojo.Challenge;
import com.myweb.service.ChallengeService;

@Service("ChallengeService")
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private Challengemapper challengemapper;
    @Autowired
    private ChallengeService challengeService;
    @Override
    public List listAllChallenges(Integer type,String isuse,String myuse,String search) {
    	Map maps = new HashMap();
    	maps.put("type", type);
    	maps.put("isuse", isuse);
    	maps.put("myuse", myuse);
    	maps.put("search", search);
    	List list = challengemapper.selectByCol(maps);
//    	List list = challengemapper.listChallengesByTypeUseMyuse(type,isuse,myuse,search);
        return list;
    }

    @Override
    public Challenge getChallengeById(int cid) {
        return challengemapper.getChallengeById(cid);
    }
    @Override
    public Challenge getByname(String name) {
        return challengemapper.getByname(name);
    }
    @Override
    public int saveChallenge(Challenge challenge) {
       return challengemapper.updateChallenge(challenge);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteChallenge(int cid) {
        challengemapper.deleteChallengeById(cid);
    }

    @Override
    public int addChallenge(Challenge challenge) {
        return challengemapper.insertChallenge(challenge);

    }
}
