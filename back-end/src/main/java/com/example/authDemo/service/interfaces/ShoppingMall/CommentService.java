package com.example.authDemo.service.interfaces.ShoppingMall;

import com.example.authDemo.pojo.Comment;
import com.example.authDemo.pojo.DataObject.CommentItem;

import java.util.List;

public interface CommentService {
    public List<CommentItem> listComments(int serviceId);

    public boolean createComment(int serviceId, int clientId);

    public boolean deleteComment(int serviceId, int clientId);

}
