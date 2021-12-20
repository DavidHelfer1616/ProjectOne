package daos;

import models.Reimbursements;

import java.util.List;

public interface ReimbursementsDao {
    List<Reimbursements> getAllReimbursements();
    List<Reimbursements> getAllReimbursementsForEmployee(Integer authorId);
    Reimbursements getReimbursement(Integer reimbId);
    Boolean createReimbursement(Reimbursements reimbDTO);
    Boolean updateReimbursement(Reimbursements reimbDTO);
}
