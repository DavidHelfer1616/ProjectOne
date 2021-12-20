package services;

import daos.ReimbursementsDao;
import daos.ReimbursementsDaoImpl;
import models.Reimbursements;

import java.util.List;

public class ReimbursementsService {

    ReimbursementsDao reimbDaoInstance;

    public ReimbursementsService(ReimbursementsDao passedReimbDao){this.reimbDaoInstance = passedReimbDao;}

    public ReimbursementsService(){this.reimbDaoInstance = new ReimbursementsDaoImpl();}

    public List<Reimbursements> getAllReimbursements(){
        return reimbDaoInstance.getAllReimbursements();
    }

    public List<Reimbursements> getAllReimbursementsForEmployee(Integer authorId){
        return reimbDaoInstance.getAllReimbursementsForEmployee(authorId);
    }

    public Reimbursements getReimbursement(Integer reimbId){
        return reimbDaoInstance.getReimbursement(reimbId);
    }

    public Boolean createReimbursement(Reimbursements reimbDTO){
        return reimbDaoInstance.createReimbursement(reimbDTO);
    }

    public Boolean updateReimbursement(Reimbursements reimbDTO){
        return reimbDaoInstance.updateReimbursement(reimbDTO);
    }
}
