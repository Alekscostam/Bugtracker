package pl.kowalski.bugtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.JdbcTemplate.EmployeeDaoImpl;
import pl.kowalski.bugtracker.Dao.Repositories.EmployeeRepository;
import pl.kowalski.bugtracker.model.Entity.Employee;
import pl.kowalski.bugtracker.service.Interfaces.GetEmployeeService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GetEmployeeServiceImpl implements GetEmployeeService {

    EmployeeDaoImpl employeeDao;
    EmployeeRepository employeeRepository;

    @Autowired
    public GetEmployeeServiceImpl(EmployeeDaoImpl employeeDao, EmployeeRepository employeeRepository) {
        this.employeeDao = employeeDao;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String getEmployeeNamesByBugId(Long bugId) {

        StringBuilder allEmployees = new StringBuilder("");
        employeeDao.findEmployeeNamesByBugId(bugId).forEach(employee -> allEmployees.append(employee).append(", "));


        return allEmployees.toString();
    }


    @Override
    public List<String> getInstitutionCodes() {
        return employeeRepository.findAll().stream().map(Employee::getInstitutionCode).collect(Collectors.toList());
    }

    @Override
    public String generateInstitutionCode() {

        boolean checker = true;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder();
        while (checker) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {

                    int index = (int) (AlphaNumericString.length() * Math.random());

                    sb.append(AlphaNumericString.charAt(index));
                }
                sb.append("-");
            }
            String code = sb.substring(0, sb.length() - 1);
            boolean result = checkIfCodeExist(code);
            if (!result) {
                checker =false;
            }
        }

        return sb.substring(0, sb.length() - 1);

    }

    private boolean checkIfCodeExist(String code) {
        List<String> institutionCodes = getInstitutionCodes();
        return institutionCodes.stream().anyMatch(insCode -> insCode.equals(code));
    }

    @Override
    public boolean checkUserHaveThisTask(Long bugId, Employee employee) {
        return false;
    }


}
