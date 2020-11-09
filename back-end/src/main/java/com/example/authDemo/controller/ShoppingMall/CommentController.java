package com.example.authDemo.controller.ShoppingMall;

import com.example.authDemo.pojo.Comment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/details/{servId}/Comment")
public class CommentController {

    @RequestMapping("/Show")
    public String listAllComments(@PathVariable String servId){

        return null;
    }

    @RequestMapping(path = "/{userName}/PostComment",
                    method = RequestMethod.POST)
    public String postComment(@PathVariable String servId,
                              @PathVariable String userName,
                              @RequestBody Comment cmt){

        return null;
    }

}
