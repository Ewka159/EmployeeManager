package com.project.employeemanager.dataseed;

import com.project.employeemanager.model.Employee;
import com.project.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDataLoader implements CommandLineRunner {

    @Autowired
    EmployeeRepo employeeRepo;

    public void run(String... args) throws Exception {
        loadEmployeeData();
    }

    private void loadEmployeeData() {
        if (employeeRepo.count() == 0) {
            Employee employee1 = new Employee("Lauren", "Peller", "lpeller3@nps.com",
                    "Data Coordiator", "700-332-1394", "http://dummyimage.com/230x100.png/5fa2dd/ffffff", 5000);
            Employee employee2 = new Employee("Jaquelin", "Allwood", "jallwood5@salon.com",
                    "Software Test Engineer", "833-632-3111", "http://dummyimage.com/181x100.png/dddddd/000000", 6000);
            Employee employee3 = new Employee("Reinald", "Grimble", "rgrimble8@toplist.cz",
                    "Internal Auditor", "833-632-3111", "", 7000);
            Employee employee4 = new Employee("Hugo", "Purshouse", "hpurshousea@biblegateway.com",
                    "Developer", "833-632-3111", "http://dummyimage.com/181x100.png/dddddd/000000", 8000);
            Employee employee5 = new Employee("Conrad", "Kitman", "ckitmanp@last.fm",
                    "Help Desk Operator", "428-549-7873", "http://dummyimage.com/242x100.png/5fa2dd/ffffff", 9000);
            Employee employee6 = new Employee("Michal", "Licas", "mlicasw@newsvine.com",
                    "Web Designer", "435-879-5309", "http://dummyimage.com/202x100.png/dddddd/000000", 10000);

            employeeRepo.save(employee1);
            employeeRepo.save(employee2);
            employeeRepo.save(employee3);
            employeeRepo.save(employee4);
            employeeRepo.save(employee5);
            employeeRepo.save(employee6);
        }
    }
}
