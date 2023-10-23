// Spring Framework Promotes Convention Over Configuration
// Below Code Shows Using Simple Annotations

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private MyRepository repository;

    public String fetchData() {
        return repository.getData();
    }
}
