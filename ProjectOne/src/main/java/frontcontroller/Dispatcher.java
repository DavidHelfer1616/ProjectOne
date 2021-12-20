package frontcontroller;

import controllers.ReimbursementController;
import controllers.UserController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {
    public Dispatcher(Javalin app){

        app.routes(() -> {
            path("login", () -> {
                post(UserController::getUser);
                path("managerdashboard", () -> {
                    get(ReimbursementController::getAllReimbursements);
                    put(ReimbursementController::updateReimbursement);
                    path("{reimbId}", () ->{
                        get(ReimbursementController::getReimbursement);
                    });
                });
                path("empdashboard", () -> {
                    path("{empId}", () -> {
                        get(ReimbursementController::getAllReimbursementsForEmployee);
                        post(ReimbursementController::createReimbursement);
                    });
                    path("test/{reimbId}", () ->{
                        get(ReimbursementController::getReimbursement);
                    });
                });
            });
            path("check-session", () -> {
                get(UserController::checkSession);
            });
            path("logout", () -> {
                delete(UserController::logout);
            });
        });
    }
}
