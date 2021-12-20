package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Users;
import org.apache.log4j.Logger;
import services.UserService;


public class UserController {

    final static Logger Log = Logger.getLogger(UserController.class);

    static UserService userServiceInstance = new UserService();

    public static void getUser(Context ctx){
        String username = ctx.queryParam("username");
        String password = ctx.queryParam("password");
        Users user = userServiceInstance.getUser(username, password);
        ctx.sessionAttribute("user-session", user);
        if (user == null){
            ctx.json(new JsonResponse(false, "user not found", null));
            Log.error("could not find user");
            ctx.status(404);
        } else {
            ctx.json(new JsonResponse(true, "login successful", new Users(user.getUsersId(), user.getUserRole())));
            Log.info("Got user");
            ctx.status(200);
        }

    }

    public static void checkSession(Context ctx){
        Users user = ctx.sessionAttribute("user-session");

        if(user == null){
            ctx.json(new JsonResponse(false, "no session found", null));
        } else{
            ctx.json(new JsonResponse(true, "session found", new Users(user.getUsersId(), user.getUserRole())));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("user-session", null);
        ctx.json(new JsonResponse(true, "Logged out successfully", null));
    }
}