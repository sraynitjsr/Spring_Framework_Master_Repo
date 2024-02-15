@Repository
public class CassandraRepository {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    public void insertData(String key, String value) {
        Insert insert = QueryBuilder.insertInto("table_name")
                .value("key", key)
                .value("value", value);

        cassandraTemplate.execute(insert);
    }
}
