package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.oceanview.dao.StaffDAO;
import com.oceanview.model.Staff;

public class StaffDAOTest {

    @Test
    public void testAddStaff() {

        Staff staff = new Staff();

        staff.setName("JUnit Staff");
        staff.setRole("Receptionist");
        staff.setContact("0751112233");
        staff.setEmail("staff@test.com");

        StaffDAO dao = new StaffDAO();

        dao.addStaff(staff);

        assertNotNull(staff);
    }
}