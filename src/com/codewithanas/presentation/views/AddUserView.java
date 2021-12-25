package com.codewithanas.presentation.views;

import com.codewithanas.entites.User;
import com.codewithanas.metier.UserManager;
import com.codewithanas.presentation.controllers.ControllerUser;
import com.kitfox.svg.Use;

public class AddUserView extends AddView<User, Integer>{

    public AddUserView() {
        super(new User(2,"anas"));
        this.setController(new ControllerUser());
        this.getController().setManager(new UserManager());
    }

    @Override
    public User initBean() {
        User user = new User();
        user.setId(Integer.valueOf(this.textFieldHashMap.get("id").getText()));
        user.setName(this.textFieldHashMap.get("name").getText());
        return user;
    }
}
