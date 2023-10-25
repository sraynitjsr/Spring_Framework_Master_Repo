## Java Persistence API (JPA) is a Java specification for object-relational mapping (ORM).

## It allows us to define and manage the relationships between Java objects and relational database tables.

## JPA provides a set of annotations that we can use to configure and map Java classes to database tables.

## These annotations are typically used in Java entities, which are Java classes representing database tables.

### @Entity: This annotation is used to mark a Java class as a JPA entity. An entity class represents a database table.

### @Table: You can use this annotation to specify the details of the database table associated with the entity. It allows you to set the table name, schema, and other attributes.

### @Id: Annotate a field with this annotation to indicate that it is the primary key of the entity.

### @GeneratedValue: This annotation is often used in conjunction with @Id to specify how the primary key values are generated. Common strategies are GenerationType.IDENTITY (auto-increment) and GenerationType.SEQUENCE.

### @Column: Use this annotation to specify the mapping between an entity field and a database column. You can set attributes like the column name, length, nullable, and more.

### @ManyToOne, @OneToMany, @OneToOne, @ManyToMany: These annotations are used to define relationships between entities. They specify the type of association between entities and can include attributes like mappedBy and cascade.

# @Entity
# public class Department {
#     @Id
#     @GeneratedValue(strategy = GenerationType.IDENTITY)
#     private Long id;

#     @OneToMany(mappedBy = "department")
#     private List<Employee> employees;
# }

# @Entity
# public class Employee {
#     @Id
#     @GeneratedValue(strategy = GenerationType.IDENTITY)
#     private Long id;

#     @ManyToOne
#     @JoinColumn(name = "department_id")
#     private Department department;
# }

### @JoinColumn: This annotation is used to specify the column that is used for a join operation in a relationship.
