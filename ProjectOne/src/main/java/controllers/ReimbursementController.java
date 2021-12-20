package controllers;

import io.javalin.http.Context;
import models.Reimbursements;
import models.Users;
import org.apache.log4j.Logger;
import services.ReimbursementsService;

import java.util.List;

public class ReimbursementController {

    final static Logger Log = Logger.getLogger(ReimbursementController.class);

    static ReimbursementsService reimbursementsService = new ReimbursementsService();

    public static void getAllReimbursements(Context ctx){
        List<Reimbursements> reimbursements = reimbursementsService.getAllReimbursements();
        ctx.json(reimbursements);
        Log.info("Got all reimbursements");
        ctx.status(200);
    }

    public static void getAllReimbursementsForEmployee(Context ctx){
        Integer authorId = Integer.parseInt(ctx.pathParam("empId"));
        List<Reimbursements> reimbursements = reimbursementsService.getAllReimbursementsForEmployee(authorId);
        ctx.json(reimbursements);
        Log.info("Got all reimbursements");
        ctx.status(200);
    }


    public static void getReimbursement(Context ctx){
        Integer reimbId = Integer.parseInt(ctx.pathParam("reimbId"));
        Reimbursements reimbursements = reimbursementsService.getReimbursement(reimbId);
        ctx.json(reimbursements);
        Log.info("Got reimbursement");
        ctx.status(200);
    }

    public static void createReimbursement(Context ctx){
        Reimbursements reimbDTO = ctx.bodyAsClass(Reimbursements.class);
        if(reimbursementsService.createReimbursement(reimbDTO)){
            Log.info("Reimbursement created.");
            ctx.status(200);
            ctx.json(true);
        } else{
            Log.error("Reimbursement creation failed.");
            ctx.status(500);
            ctx.json(false);
        }
    }

    public static void updateReimbursement(Context ctx){
        Reimbursements reimbDTO = ctx.bodyAsClass(Reimbursements.class);
        if(reimbursementsService.updateReimbursement(reimbDTO)){
            Log.info("Reimbursement resolved.");
            ctx.status(200);
            ctx.json(true);
        } else{
            Log.error("Reimbursement resolving failed.");
            ctx.status(500);
            ctx.json(false);
        }
    }

    public static void checkSession(Context ctx) {
        Users user = ctx.sessionAttribute("usersession");
    }
}
