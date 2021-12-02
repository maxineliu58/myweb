package com.myweb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myweb.pojo.Challenge;

@Mapper
public interface Challengemapper {
    @Select("Select title,cid,flag,type,link,description,solved_number,pic_address,name,platform,isuse,subtype,myuse,isopen,address From tools where type=#{type}")
    public List<Challenge> listChallengesByType(int type);
    @Select("Select title,cid,flag,type,link,description,solved_number,pic_address,name,platform,isuse,subtype,myuse,isopen,address From tools where (#{type} is null || type=#{type}) && (#{isuse} is null || isuse=#{isuse}) && (#{myuse} is null ||myuse=#{myuse}) && (#{search} is null || name like '%${search}%' || isopen like '%${search}%' || platform like '%${search}%')")
    public List<Challenge> listChallengesByTypeUseMyuse(Integer type,String isuse,String myuse,String search);
    @Select("Select title,cid,flag,type,link,description,solved_number,pic_address,name,platform,isuse,subtype,myuse,isopen,address From tools where cid=#{cid}")
    public Challenge getChallengeById(int cid);
    @Update("UPDATE tools set title=#{title},flag=#{flag},description=#{description},link=#{link},pic_address=#{picAddress},name=#{name},platform=#{platform},isuse=#{isuse},subtype=#{subtype},myuse=#{myuse},isopen=#{isopen},address=#{address},type=#{type} WHERE cid=#{cid}")
    public int updateChallenge(Challenge challenge);
    @Delete("DELETE  FROM tools where cid =#{cid}")
    public int deleteChallengeById(int cid);
    @Insert("Insert into tools(title,flag,description,link,type,pic_address,name,platform,isuse,subtype,myuse,isopen,address) values (#{title},#{flag},#{description},#{link},#{type},#{picAddress},#{name},#{platform},#{isuse},#{subtype},#{myuse},#{isopen},#{address})")
    public int insertChallenge(Challenge challenge);
    public List selectByCol(Map param);
    @Select("Select title,cid,flag,type,link,description,solved_number,pic_address,name,platform,isuse,subtype,myuse,isopen,address From tools where name=#{name}")
    public Challenge getByname(String name);
}
