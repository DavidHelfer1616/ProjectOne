package daos;

import models.Reimbursements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementsDaoImplIT {

    ReimbursementsDao reimbDaoInstance;

    public ReimbursementsDaoImplIT(){
        this.reimbDaoInstance = new ReimbursementsDaoImpl(H2Util.url, H2Util.username, H2Util.password);
    }

    @BeforeEach
    void setUp() {
        H2Util.createTablesAndValues();
    }

    @AfterEach
    void tearDown() {
        H2Util.dropTables();
    }

    @Test
    void getAllReimbursements() {
        List<Reimbursements> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursements(1, 1500.56, null, null,
                "Marriot Hotel", null, "David", "Helfer",
                null, null, 2, 1));
        expectedResult.add(new Reimbursements(2, 65.0, null, null,
                "Lakewood Steakhouse", null, "David", "Helfer",
                null, null, 2, 3));

        List<Reimbursements> actualResult = reimbDaoInstance.getAllReimbursements();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getAllReimbursementsForEmployee() {
        List<Reimbursements> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursements(1, 1500.56, null, null,
                "Marriot Hotel", null, "David", "Helfer",
                null, null, 2, 1));
        expectedResult.add(new Reimbursements(2, 65.0, null, null,
                "Lakewood Steakhouse", null, "David", "Helfer",
                null, null, 2, 3));

        List<Reimbursements> actualResult = reimbDaoInstance.getAllReimbursementsForEmployee(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getReimbursement() {
        List<Reimbursements> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursements(1, 1500.56, null, null,
                "Marriot Hotel", null, "David", "Helfer",
                null, null, 2, 1));
        expectedResult.add(new Reimbursements(2, 65.0, null, null,
                "Lakewood Steakhouse", null, "David", "Helfer",
                null, null, 2, 3));

        Reimbursements actualResult = reimbDaoInstance.getReimbursement(1);

        assertEquals(expectedResult.get(0), actualResult);
    }

    @Test
    void createReimbursement() {
        Reimbursements passedValues = new Reimbursements(51.15,
                "Japanese candy shaped like cat girls", 4,1);

        Boolean actualResult = reimbDaoInstance.createReimbursement(passedValues);

        assertTrue(actualResult);
    }

    @Test
    void updateReimbursement() {
        Reimbursements passedValues = new Reimbursements(1, 3, 2);

        Boolean actualResult = reimbDaoInstance.updateReimbursement(passedValues);

        assertTrue(actualResult);
    }
}