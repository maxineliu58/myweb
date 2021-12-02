package com.myweb.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.pojo.Challenge;
import com.myweb.pojo.User;
import com.myweb.service.ChallengeService;
import com.myweb.service.UserService;
import com.myweb.util.OpenExe;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class IndexController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    @Autowired
    private ChallengeService challengeService;
    @GetMapping("/addTool")
    public ModelAndView add(String type){
        ModelAndView mv=new ModelAndView("moban/form-elements");
        mv.addObject("challenge", new Challenge());
        mv.addObject("type", type);
        return mv;
    }
    @GetMapping("/uploadPage")
    public ModelAndView upload(){
        ModelAndView mv=new ModelAndView("moban/upload");
        mv.addObject("challenge", new Challenge());
        return mv;
    }
    @PostMapping("/uploadTool")
    public ModelAndView uploadTool(@RequestParam("file") MultipartFile file){
    	if (file.isEmpty()) {
//            return "上传失败，请选择文件";
        }
    	try {
			InputStream input = file.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader in= new BufferedReader(reader);
			String name="";
			String line=null;
			while( (line=in.readLine())!=null ){
				System.out.println(line);
				String[] col = line.split(",");
				
				try {
					Challenge challenge = new Challenge();
					challenge.setSubtype(col[3]);
					challenge.setType(Integer.valueOf(col[2]));
					challenge.setPicAddress("assets/images/tools/"+col[5].replace("/", "")+".jpg");
					challenge.setName(col[5]);
					challenge.setTitle(col[5]);
					challenge.setIsopen(col[6]);
					challenge.setPlatform(col[7]);
					challenge.setDescription(col[8].replace("|", ","));
					challenge.setLink(col[9]);
					challenge.setMyuse(col[10]);
					challenge.setAddress(col[11]);
					challenge.setFlag(col[12]);
					Challenge challengeSelec = challengeService.getByname(col[5]);
					if(null != challengeSelec) {
						challengeService.deleteChallenge(challengeSelec.getCid());
					}
					challengeService.addChallenge(challenge);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					name=name+"|"+line;
					e.printStackTrace();
				}
			}
			System.out.println(name);
			in.close();
			input.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String fileName = file.getOriginalFilename();
        String filePath = "static/assets/images/tools/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
//            LOGGER.info("上传成功");
//            return "上传成功";
        } catch (IOException e) {
//            LOGGER.error(e.toString(), e);
        }
//        return "上传失败！";
        ModelAndView mv=new ModelAndView("moban/upload");
        mv.addObject("challenge", new Challenge());
        return mv;
    }
    @GetMapping("/updateTool")
    public ModelAndView update(int cid,String type1){
    	Challenge challenge = challengeService.getChallengeById(cid);
        ModelAndView mv=new ModelAndView("moban/form-elements");
        mv.addObject("challenge", challenge);
        mv.addObject("type", type1);
        return mv;
    }
    @PostMapping(value="/modifyTool")
    public String modifiyTool(HttpSession session,Challenge challenge,String type){
//    	Challenge update = challengeService.getChallengeById(challenge.getCid());
    	Challenge update = challengeService.getByname(challenge.getName());
    	String isU = "false";
    	if(null == update) {
    		update = new Challenge();
    		isU = "";
    	}
    	update.setAddress(challenge.getAddress());
    	update.setMyuse(challenge.getMyuse());
    	update.setDescription(challenge.getDescription());
    	update.setFlag(challenge.getFlag());
    	update.setIsopen(challenge.getIsopen());
    	update.setName(challenge.getName());
    	update.setPicAddress("assets/images/tools/"+challenge.getName().replace("/", "")+".jpg");
    	update.setPlatform(challenge.getPlatform());
    	update.setSubtype(challenge.getSubtype());
    	update.setType(challenge.getType());
    	update.setLink(challenge.getLink());
    	update.setTitle(challenge.getIsopen());
        try {
        	if("".equals(isU)) {
        		challengeService.addChallenge(update);
        	}else {
        		challengeService.saveChallenge(update);
        	}
        }catch (Exception e){
        }
        return "redirect:/index?type="+type;
//        ModelAndView mv=new ModelAndView("moban/form-elements");
//        mv.addObject("challenge", new Challenge());
//        return mv;
    }
    @PostMapping(value = "/createTool")
    @ResponseBody
    public String createTool(HttpSession session, Challenge challenge){
    	Challenge update = challengeService.getChallengeById(challenge.getCid());
    	if(null != update) {
    		return "exist";
    	}
        try {
            challengeService.addChallenge(challenge);
        }catch (Exception e){
        }
        return "success";
    }
    @GetMapping(value = "/deleteTool")
    @ResponseBody
    public String delete(int cid){
        try {
            challengeService.deleteChallenge(cid);
        }catch (Exception e){
        }
        return "1";
    }
    @GetMapping("/index")
    public ModelAndView getindex(Integer type,String isuse,String myuse,String search){
        ModelAndView mv=new ModelAndView();
        User user=userService.getUserById(((User)session.getAttribute("user")).getUid());
        session.setAttribute("user",user);
        mv.addObject("user",user);
        List list = challengeService.listAllChallenges(type, isuse, myuse,search);
        mv.addObject("tools",list);
        mv.addObject("type",type);
        mv.addObject("myuse",myuse);
        mv.setViewName("moban/index");
        return mv;
    }
    @GetMapping("/openExe")
    @ResponseBody
    public String openExe(String path){
    	Boolean result = OpenExe.openFileOfSys(path);
    	String resultStr = "1";
    	if(result) {
    		resultStr =  "0";
    	}
    	return resultStr;
    }
}
