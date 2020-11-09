package com.example.authDemo.controller;


import com.example.authDemo.model.ResultMap;
import com.example.authDemo.pojo.ApplyItem;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/{userName}/HealthSteward")
public class HealthStewardController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResultMap resultMap;

    @Autowired
    public HealthStewardController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @RequestMapping(path = "/SubmitApplyItem", method=RequestMethod.POST)
    public String submitApplyItem(@RequestBody ApplyItem item, @PathVariable String userName){
        return null;
    }

    // TalkLink
    @RequestMapping("/StaffTalkConfirm")
    public String staffTalkConfirm(@RequestParam String clientUserName,
                                   @PathVariable String userName){

        return null;
    }

    // ContractLink
    @RequestMapping("/ClientContractConfirm")
    public String clientContractConfirm(@RequestParam Boolean confirm,
                                        @RequestParam String staffUserName,
                                        @PathVariable String userName){

        return null;
    }

    @RequestMapping("/StaffContractConfirm")
    public String staffContractConfirm(@RequestParam Boolean confirm,
                                       @RequestParam String clientUserName,
                                       @PathVariable String userName){

        return null;
    }

    @RequestMapping("/ContractFlowLevel")
    public String getContractFlowLevel(@PathVariable String userName){

        return null;
    }

    // manage signed clients
    @RequestMapping("/SignedClients")
    public String getAllSignedClients(@PathVariable String userName){

        return null;
    }


    @RequestMapping("/talkingNote")
    public ResultMap getStaffNote(@PathVariable String userName, @RequestParam String clientName){
        if(!userName.equals(SecurityUtils.getSubject().getPrincipal().toString())){
            // token合法，只要再验证token里的userName和PathVariable里的userName是否相等啦！
            logger.info("AuthenticationException: 用户名错误");
            throw new AuthenticationException("用户名错误");
        }

        String tmpNote = "doctor "+ userName + " said " + clientName +" is a funny";
        return resultMap.success().code(200).message("note", tmpNote);
    }

//    @RequestMapping("/talkingNote")
//    public ResultMap getStaffNote(@PathVariable String userName){
//        if(!userName.equals(SecurityUtils.getSubject().getPrincipal().toString())){
//            logger.info("AuthenticationException: 用户名错误");
//            throw new AuthenticationException("用户名错误");
//        }
//        String tmpNote = "doctor "+ userName + "'s memory is bad";
//        return resultMap.success().code(200).message("note", tmpNote);
//    }



    @RequestMapping("/RepealContract/{staffUserName}")
    public ResultMap repealContract(@RequestParam String clientUserName,
                                 @PathVariable String staffUserName){
        return null;
    }


    @RequestMapping(path = "/EditStaffNote/{staffUserName}",
                    method = RequestMethod.POST)
    public String setStaffNote(@PathVariable String staffUserName,
                               @RequestBody String note,
                               @RequestParam String clientUserName){

        return null;
    }

    // ApplyItems
    @RequestMapping("/showApplyItems")
    public String listAllApplyItems(){

        return null;
    }
}
