package services;

import daos.ReimbursementsDao;
import models.Reimbursements;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementsServiceTest {

    ReimbursementsDao reimbDaoInstance = Mockito.mock(ReimbursementsDao.class);
    ReimbursementsService reimbServiceInstance;

    public ReimbursementsServiceTest() {
        this.reimbServiceInstance = new ReimbursementsService(reimbDaoInstance);
    }

    @Test
    void getAllReimbursements() {
        List<Reimbursements> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursements(1, 1500.56, null, null,
                "Marriot Hotel", null, "David", "Helfer",
                null, null, 2, 1));
        expectedResult.add(new Reimbursements(1, 1500.00, null, null,
                "Hotel", null, "sus", "Heer",
                null, null, 2, 1));

        Mockito.when(reimbDaoInstance.getAllReimbursements()).thenReturn(expectedResult);

        List<Reimbursements> actualResult = reimbServiceInstance.getAllReimbursements();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getAllReimbursementsForEmployee() {
        List<Reimbursements> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursements(1, 1500.56, null, null,
                "Marriot Hotel", null, "david", "Helfer",
                null, null, 2, 1));
        expectedResult.add(new Reimbursements(2, 1500.00, null, null,
                "Hotel", null, "sus", "Heer",
                null, null, 2, 1));

        Mockito.when(reimbDaoInstance.getAllReimbursementsForEmployee(1)).thenReturn(expectedResult.subList(0,1));

        List<Reimbursements> actualResult = reimbServiceInstance.getAllReimbursementsForEmployee(1);

        assertEquals(expectedResult.subList(0,1), actualResult);
    }

    @Test
    void getReimbursement() {
        List<Reimbursements> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursements(1, 1500.56, null, null,
                "Marriot Hotel", null, "david", "Helfer",
                null, null, 2, 1));
        expectedResult.add(new Reimbursements(2, 1500.00, null, null,
                "Hotel", null, "sus", "Heer",
                null, null, 2, 1));

        Mockito.when(reimbDaoInstance.getReimbursement(1)).thenReturn(expectedResult.get(0));

        Reimbursements actualResult = reimbServiceInstance.getReimbursement(1);

        assertEquals(expectedResult.get(0), actualResult);
    }

    @Test
    void createReimbursement() {
        Reimbursements passedValues = new Reimbursements(51.15,
                "Japanese candy shaped like cat girls", 4,1);
        Mockito.when(reimbDaoInstance.createReimbursement(passedValues)).thenReturn(true);

        Boolean actualResult = reimbServiceInstance.createReimbursement(passedValues);

        assertTrue(actualResult);
    }

    @Test
    void updateReimbursement() {
        Reimbursements expectedResult = new Reimbursements(1, 3, 2);
        Mockito.when(reimbDaoInstance.createReimbursement(expectedResult)).thenReturn(true);

        Boolean actualResult = reimbServiceInstance.createReimbursement(expectedResult);

        assertTrue(actualResult);
    }
}