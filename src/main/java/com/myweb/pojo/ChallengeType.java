package com.myweb.pojo;
public enum ChallengeType {
    /**
     * 对应三种难度
     */
    EASY(1),
    MEDIUM(2),
    HARD(3),
    OTHER(0),
    SOME(4),
    SIX(6),
    FIVE(5);

    private int typecode;
    ChallengeType(int typecode){
        this.typecode=typecode;
    }

    public int getTypecode() {
        return typecode;
    }


}
