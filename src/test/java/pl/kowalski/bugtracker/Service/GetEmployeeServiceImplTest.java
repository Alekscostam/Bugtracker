package pl.kowalski.bugtracker.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kowalski.bugtracker.Dao.JdbcTemplate.EmployeeDaoImpl;
import pl.kowalski.bugtracker.Dao.Repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

class GetEmployeeServiceImplTest {

    EmployeeDaoImpl employeeDao;
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup()
    {
       employeeDao = Mockito.mock(EmployeeDaoImpl.class);
       employeeRepository = Mockito.mock(EmployeeRepository.class);
    }

    @Test
    void shouldGenerateInstitutionCode() {

        GetEmployeeServiceImpl getEmployeeService = new GetEmployeeServiceImpl(employeeDao,employeeRepository);

        String institutionCode = getEmployeeService.generateInstitutionCode();

        assertFalse(institutionCode.isEmpty());

    }
}