package kz.reself.springdata.repository;

import kz.reself.springdata.entity.EmployeeType;
import kz.reself.springdata.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
    @PersistenceContext
    EntityManager entityManager = null;

    @Transactional
    default void insertWithQuery(Employee employee) {
        entityManager.createNativeQuery("INSERT INTO users VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, employee.getId())
                .setParameter(6, employee.getCommRate())
                .setParameter(7, employee.getEmplType())
                .setParameter(3, employee.getFixedSalary())
                .setParameter(4, employee.getHourRate())
                .setParameter(5, employee.getHoursWorked())
                .setParameter(2, employee.getName())
                .executeUpdate();
    }

    List<Employee> findByName(String name);

    void deleteById(Long id);

    Optional<Employee> findById(Long id);

    @Modifying
    @Query(value = "update Employee u set u.fixedSalary = u.fixedSalary*?1 where u.emplType=?2")
    void rewardSalariedCommissionEmployees(double persent, EmployeeType emplType);

    @Modifying
    @Query(value = "update Employee u set u.fixedSalary=u.fixedSalary*?1 where u.hoursWorked>=?2 and u.emplType=?3")
    void salaryHourlyEmployees(double coef, int hoursWorked, EmployeeType employeeType);

    @Modifying
    @Query(value = "update Employee u set u.fixedSalary=u.fixedSalary + (u.fixedSalary*u.commRate) where u.emplType=?1 or u.emplType=?2")
    void salaryCommisionAndSalariedCommision(EmployeeType employeeType1, EmployeeType employeeType2);

    //employee list
    @Query(
            value = "select * from User",
            nativeQuery = true
    )
    Collection<Employee> findAllActiveUsersNative();

}
