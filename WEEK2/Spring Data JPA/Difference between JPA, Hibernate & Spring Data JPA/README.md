# Hands on 4 – Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

- JPA (Java Persistence API) is a specification (JSR 338) for persisting Java objects into a database.
- It defines interfaces and annotations but does not provide an implementation.
- Hibernate is one of the most popular implementations of JPA.

## Hibernate

- Hibernate is an ORM (Object Relational Mapping) framework.
- It implements the JPA specification.
- It manages sessions, transactions, and SQL generation.
- Developers manually handle Session and Transaction objects.

Example:

```java
Session session = factory.openSession();
Transaction tx = session.beginTransaction();
session.save(employee);
tx.commit();
session.close();
```

## Spring Data JPA

- Spring Data JPA is built on top of JPA.
- It reduces boilerplate code.
- No need to manually create Session or Transaction.
- Repository interfaces provide built-in CRUD operations.
- Transaction management is handled using @Transactional.

Repository Example

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

Service Example

```java
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```

## Comparison

| Feature | JPA | Hibernate | Spring Data JPA |
|--------|------|-----------|-----------------|
| Type | Specification | Framework | Spring Module |
| Implementation | No | Yes | Uses JPA |
| Session Handling | No | Manual | Automatic |
| Transactions | Interface Only | Manual | @Transactional |
| CRUD Operations | Defined | Manual | Repository Methods |
| Boilerplate Code | Medium | High | Very Low |

## Conclusion

- JPA defines the standard.
- Hibernate implements the standard.
- Spring Data JPA simplifies Hibernate/JPA by reducing boilerplate code and providing repository support.
