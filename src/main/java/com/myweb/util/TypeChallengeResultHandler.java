package com.myweb.util;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import com.myweb.pojo.ChallengeType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TypeChallengeResultHandler implements ResultHandler {
    private Map<Integer, List<Integer>> results=new HashMap<>();
    public TypeChallengeResultHandler(){
        List<Integer> EasyList=new LinkedList<>();
        List<Integer> MediumList=new LinkedList<>();
        List<Integer> HardList=new LinkedList<>();
        this.results.put(ChallengeType.EASY.getTypecode(),EasyList);
        this.results.put(ChallengeType.MEDIUM.getTypecode(),MediumList);
        this.results.put(ChallengeType.HARD.getTypecode(),HardList);
    }
    @Override
    public void handleResult(ResultContext resultContext) {

        Map<String,Object> resultObject=(Map<String,Object>)resultContext.getResultObject();
        results.get((Integer) resultObject.get("type")).add((Integer) resultObject.get("cid"));
    }

    public Map<Integer, List<Integer>> getResults() {
        return results;
    }

    public void setResults(Map<Integer, List<Integer>> results) {
        this.results = results;
    }
}
